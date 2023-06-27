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

public class Carrito implements I_Json {

    private ArrayList<Producto> carrito; //un arreglo por tipo de producto o agregar un atributo o hacer el metodo estatico
    private double precioTotal;

    public Carrito(){
        this.carrito=new ArrayList<>();
        this.precioTotal=0;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void agregarAlCarrito(Producto producto, int cantidad) throws ProductoNoDisponibleException {
        if(!producto.isDisponible()){
            throw new ProductoNoDisponibleException("El producto no esta disponible");
        } else {
            carrito.add(producto);
            producto.setCantidadEnCarrito(cantidad);
            producto.aumentarCantidadVendidos(cantidad);
            precioTotal+= (producto.getPrecio() * cantidad);
        }
    }

    public void eliminarDelCarrito(Producto producto){
        carrito.remove(producto);
        producto.disminuirCantidadVendidos(producto.getCantidadEnCarrito());
        precioTotal-= (producto.getPrecio() * producto.getCantidadEnCarrito());
        producto.setCantidadEnCarrito(0);
    }
    //no se si disminuir la cantidad deberia ser una opcion de eliminar o de modificar,
    // o sea que eliminar saque el producto y todas sus unidades
    public void eliminarDelCarrito(Producto producto, int cantidad){ //nombre: eliminar o modificar
        if (producto.getCantidadEnCarrito()>cantidad){
            producto.disminuirCantidadEnCarrito(cantidad);
            producto.disminuirCantidadVendidos(cantidad);
            precioTotal-= (producto.getPrecio() * cantidad);
        } else if(producto.getCantidadEnCarrito()==cantidad){
            eliminarDelCarrito(producto);
        } else { //la cantidad que quiere sacar es mayor a la existente
            //no se si ignorarlo y hacer esto:
            //eliminarDelCarrito(producto);
            //o tirar una excepcion
        }
    }

    //modificar

    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject=new JSONObject();
        //probar si se pueden separar los productos al cargar el json
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
        jsonObject.put("carritoDeComidas", jsonComida);
        jsonObject.put("carritoDeBebidasEnvasadas", jsonEnvasada);
        jsonObject.put("carritoDeInfusiones", jsonInfusion);
        jsonObject.put("precioTotal", getPrecioTotal());
        return jsonObject;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
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
