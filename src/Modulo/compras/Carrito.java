package Modulo.compras;

import Modulo.json.I_Json;
import Modulo.productos.Producto;
import Modulo.productos.comidas.Comida;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Carrito implements I_Json {

    private ArrayList<Producto> carrito;
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

    public void agregarAlCarrito(Producto producto, int cantidad){
        carrito.add(producto);
        producto.aumentarCantidadVendidos(cantidad);
        precioTotal+= (producto.getPrecio() * cantidad);
    }

    //no hay manera de saber que hay mas de 1 de un producto. Nuevo atributo en Producto
    public void eliminarDelCarrito(Producto producto, int cantidad){
        carrito.remove(producto);
        producto.disminuirCantidadVendidos(cantidad);
        precioTotal-= (producto.getPrecio() * cantidad);
    }

    //modificar

    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonCarrito=new JSONArray();
        for(int i=0; i<carrito.size(); i++){
            jsonCarrito.put(carrito.get(i).toJSON());
        }
        jsonObject.put("carrito", jsonCarrito);
        jsonObject.put("precioTotal", getPrecioTotal());
        return jsonObject;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        JSONArray jsonCarrito = jsonObject.getJSONArray("carrito");
        /*
        for (int i=0; i<jsonCarrito.length(); i++){
            Producto aux; //producto es abstracto
            aux.fromJSON(jsonCarrito.getJSONObject(i));
            agregarAlCarrito(aux, 1); //problemas con las cantidades
        }

         */
        setPrecioTotal(jsonObject.getDouble("precioTotal"));
    }


}
