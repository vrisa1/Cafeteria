package Modulo.compras;

import Modulo.Excepciones.ProductoNoDisponibleException;
import Modulo.json.I_Json;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.comidas.Comida;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Contiene una coleccion de productos y ofrece funcionalidad para comprar.
 * Implementa la interfaz I_Json para leer y escribir las compras realizadas.
 */
public class Compra implements I_Json {

    //ATRIBUTOS--------------------------------------------------------------------------------------------------
    private int numeroTicket;
    private String fechaHora;
    private MetodosDePago metodoDePago;
    private ArrayList<Producto> carrito;
    private double precioTotal;
    private boolean entregado;

    //CONSTRUCTORES----------------------------------------------------------------------------------------------
    public Compra() {
        this.numeroTicket = 0;
        this.fechaHora = "";
        this.metodoDePago = null;
        this.carrito = new ArrayList<>();
        this.precioTotal=0;
        this.entregado=false;
    }

    public Compra(int numeroTicket) {
        this.numeroTicket = numeroTicket;
        this.fechaHora = new Date().toString();
        this.metodoDePago = null;
        this.carrito = new ArrayList<>();
        this.precioTotal=0;
        this.entregado=false;
    }

    //GETTERS Y SETTERS------------------------------------------------------------------------------------------
    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public MetodosDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodosDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public ArrayList<Producto> getCarrito() {
        return carrito;
    }


    //METODOS AGREGAR, ELIMINAR, MODIFICAR -------------------------------------------------------------------------

    /**
     * Permite agregar un producto al carrito (Lista de productos), suma el precio del producto agregado a un
     *  acumulador.
     * @param producto - Producto a agregar.
     * @throws ProductoNoDisponibleException - Lanza esta excepcion cuando el producto que se quiere agregar no
     *  esta disponible.
     */
    public void agregarAlCarrito(Producto producto) throws ProductoNoDisponibleException {
        if(!producto.isDisponible()){
            throw new ProductoNoDisponibleException("El producto no esta disponible");
        } else {
            carrito.add(producto);
            precioTotal+= (producto.getPrecio() * (producto.getCantidadEnCarrito()));
        }
    }

    /**
     * Permite eliminar un producto del carrito (Lista de productos), resta el precio del producto eliminado del
     *  acumulador.
     * @param producto - Producto a eliminar.
     */
    public void eliminarDelCarrito(Producto producto){
        carrito.remove(producto);
        precioTotal-= (producto.getPrecio() * producto.getCantidadEnCarrito());
        producto.setCantidadEnCarrito(0);
    }

    /**
     * Permite modificar la cantidad de un producto que ya se encuentra en el carrito (Lista de productos), resta
     *  el precio de las cantidades eliminadas del producto.
     * @param producto - Producto al que se le quiere modificar la cantidad.
     * @param cantidad - La cantidad de unidades a disminuir del producto.
     */
    public void modificarCantidad(Producto producto, int cantidad){
        if (producto.getCantidadEnCarrito()>cantidad){
            producto.disminuirCantidadEnCarrito(cantidad);
            precioTotal-= (producto.getPrecio() * cantidad);
        } else {
            eliminarDelCarrito(producto);
        }
    }

    //TOSTRING----------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Compra{" +
                "numeroTicket=" + numeroTicket +
                ", fechaHora='" + fechaHora + '\'' +
                ", metodoDePago=" + metodoDePago +
                ", carrito=" + carrito.toString() +
                ", precioTotal=" + precioTotal +
                '}';
    }

    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonCompra=new JSONObject();
        jsonCompra.put("numeroTicket", getNumeroTicket());
        jsonCompra.put("fechaHora", getFechaHora());

        //carrito
        JSONArray jsonComida=new JSONArray();
        JSONArray jsonEnvasada=new JSONArray();
        JSONArray jsonInfusion=new JSONArray();
        for(int i=0; i<carrito.size(); i++){
            if(carrito.get(i) instanceof Comida){
                jsonComida.put(carrito.get(i).toJSON());
            } else if (carrito.get(i) instanceof Infusion){
                jsonInfusion.put(carrito.get(i).toJSON());
            } else {
                jsonEnvasada.put(carrito.get(i).toJSON());
            }
        }
        jsonCompra.put("carritoDeComidas", jsonComida);
        jsonCompra.put("carritoDeBebidasEnvasadas", jsonEnvasada);
        jsonCompra.put("carritoDeInfusiones", jsonInfusion);

        jsonCompra.put("metodoDePago", getMetodoDePago().name());
        jsonCompra.put("precioTotal", getPrecioTotal());
        jsonCompra.put("entregado", isEntregado());
        return jsonCompra;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        setNumeroTicket(jsonObject.getInt("numeroTicket"));
        setFechaHora(jsonObject.getString("fechaHora"));
        //carrito
        JSONArray jsonComida = jsonObject.getJSONArray("carritoDeComidas");
        for (int i=0; i<jsonComida.length(); i++){
            Producto aux = new Comida();
            aux.fromJSON(jsonComida.getJSONObject(i));
            carrito.add(aux);
        }
        JSONArray jsonEnvasada = jsonObject.getJSONArray("carritoDeBebidasEnvasadas");
        for (int i=0; i<jsonEnvasada.length(); i++){
            Producto aux1 = new BebidaEnvasada();
            aux1.fromJSON(jsonEnvasada.getJSONObject(i));
            carrito.add(aux1);
        }
        JSONArray jsonInfusion = jsonObject.getJSONArray("carritoDeInfusiones");
        for (int i=0; i<jsonInfusion.length(); i++){
            Producto aux2 = new Infusion();
            aux2.fromJSON(jsonInfusion.getJSONObject(i));
            carrito.add(aux2);
        }

        String auxS= jsonObject.getString("metodoDePago");
        if(auxS.equals(MetodosDePago.EFECTIVO.name())){
            setMetodoDePago(MetodosDePago.EFECTIVO);
        } else if(auxS.equals(MetodosDePago.DEBITO.name())){
            setMetodoDePago(MetodosDePago.DEBITO);
        } else {
            setMetodoDePago(MetodosDePago.CREDITO);
        }
        setPrecioTotal(jsonObject.getDouble("precioTotal"));
        setEntregado(jsonObject.getBoolean("entregado"));
    }
}
