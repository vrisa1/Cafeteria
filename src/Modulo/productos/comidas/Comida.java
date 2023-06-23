package Modulo.productos.comidas;

import Modulo.productos.Producto;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Comida extends Producto {

    //ATRIBUTOS---------------------------------------------------------------------------------------------------

    //private Date horarios;
    private boolean paraCompartir;

    //CONSTRUCTORES---------------------------------------------------------------------------------------------

    public Comida() {
        super();
        this.paraCompartir = false;
    }

    public Comida(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion, int cantidadEnCarrito, boolean paraCompartir) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion, cantidadEnCarrito);
        this.paraCompartir = paraCompartir;
    }

    //GETTERS Y SETTERS------------------------------------------------------------------------------------------

    public boolean isParaCompartir() {
        return paraCompartir;
    }

    public void setParaCompartir(boolean paraCompartir) {
        this.paraCompartir = paraCompartir;
    }


    //EQUALS Y TOSTRING------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj != null){
            if(obj == this){
                flag = true;
            }
            else if(obj instanceof Comida){
                Comida aux = (Comida) obj;
                if(getNombre().equals(aux.getNombre())){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        return "Comida{" +
                super.toString() +
                "paraCompartir=" + paraCompartir +
                '}';
    }


    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonComida = new JSONObject();
        jsonComida.put("nombre", getNombre());
        jsonComida.put("precio", getPrecio());
        jsonComida.put("disponible", isDisponible());
        jsonComida.put("cantidadVendidos", getCantidadVendidos());
        jsonComida.put("descripcion", getDescripcion());
        jsonComida.put("cantidadEnCarrito", getCantidadEnCarrito());
        jsonComida.put("paraCompartir", isParaCompartir());
        return jsonComida;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        setNombre(jsonObject.getString("nombre"));
        setPrecio(jsonObject.getDouble("precio"));
        setDisponible(jsonObject.getBoolean("disponible"));
        setCantidadVendidos(jsonObject.getInt("cantidadVendidos"));
        setDescripcion(jsonObject.getString("descripcion"));
        setCantidadEnCarrito(jsonObject.getInt("cantidadEnCarrito"));
        setParaCompartir(jsonObject.getBoolean("paraCompartir"));
    }
}


