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

public class Compra implements I_Json {
    private int numeroTicket; //????
    private String fechaHora;
    private MetodosDePago metodoDePago;
    private ArrayList<Producto> carrito; //un arreglo por tipo de producto o agregar un atributo o hacer el metodo estatico
    private double precioTotal;

    //private Carrito carrito;

    public Compra() {
        this.numeroTicket = 0;
        this.fechaHora = "";
        this.metodoDePago = null;
        this.carrito = new ArrayList<>();
        this.precioTotal=0;
    }

    public Compra(int numeroTicket) {
        this.numeroTicket = numeroTicket;
        this.fechaHora = new Date().toString();
        this.metodoDePago = null;
        this.carrito = new ArrayList<>();
        this.precioTotal=0;
    }

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

    //METODOS AGREGAR, ELIMINAR, MODIFICAR
    public void agregarAlCarrito(Producto producto) throws ProductoNoDisponibleException {
        if(!producto.isDisponible()){
            throw new ProductoNoDisponibleException("El producto no esta disponible");
        } else {
            carrito.add(producto);
            //producto.aumentarCantidadVendidos(producto.getCantidadEnCarrito());
            precioTotal+= (producto.getPrecio() * (producto.getCantidadEnCarrito()));
        }
    }

    public void eliminarDelCarrito(Producto producto){
        carrito.remove(producto);
        //producto.disminuirCantidadVendidos(producto.getCantidadEnCarrito());
        precioTotal-= (producto.getPrecio() * producto.getCantidadEnCarrito());
        producto.setCantidadEnCarrito(0);
    }

    public void modificarCantidad(Producto producto, int cantidad){
        if (producto.getCantidadEnCarrito()>cantidad){
            producto.disminuirCantidadEnCarrito(cantidad);
            //producto.disminuirCantidadVendidos(cantidad);
            precioTotal-= (producto.getPrecio() * cantidad);
        } else {
            //si la cantidad que quiere sacar es mayor a la existente
            //no se si ignorarlo y hacer esto:
            //eliminarDelCarrito(producto);
            //o tirar una excepcion
            eliminarDelCarrito(producto);
        }
    }


    //toString
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
        jsonCompra.put("metodoDePago", getMetodoDePago().name());

        //carrito //probar si se pueden separar los productos al cargar el json
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

        jsonCompra.put("precioTotal", getPrecioTotal());
        return jsonCompra;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        setNumeroTicket(jsonObject.getInt("numeroTicket"));
        setFechaHora(jsonObject.getString("fechaHora"));
        String auxS= jsonObject.getString("metodoDePago");
        if(auxS.equals(MetodosDePago.EFECTIVO.name())){
            setMetodoDePago(MetodosDePago.EFECTIVO);
        } else if(auxS.equals(MetodosDePago.DEBITO.name())){
            setMetodoDePago(MetodosDePago.DEBITO);
        } else {
            setMetodoDePago(MetodosDePago.CREDITO);
        }
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

        setPrecioTotal(jsonObject.getDouble("precioTotal"));
    }
}
