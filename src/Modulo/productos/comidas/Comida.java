package Modulo.productos.comidas;

import Modulo.productos.Producto;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Comida extends Producto {

    //ATRIBUTOS---------------------------------------------------------------------------------------------------

    private boolean paraCompartir;

    //CONSTRUCTORES---------------------------------------------------------------------------------------------

    public Comida() {
        super();
        this.paraCompartir = false;
    }

    public Comida(String nombre, double precio, boolean disponible, String descripcion, boolean paraCompartir) {
        super(nombre, precio, disponible, descripcion);
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
        if (obj != null) {
            if (obj == this) {
                flag = true;
            } else if (obj instanceof Comida) {
                Comida aux = (Comida) obj;
                if (getNombre().equals(aux.getNombre())) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Comida{" +
                super.toString() +
                "paraCompartir=" + paraCompartir +
                '}' + "\n";
    }

    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonComida = new JSONObject();
        jsonComida.put("nombre", getNombre());
        jsonComida.put("precio", getPrecio());
        jsonComida.put("cantidadEnCarrito", getCantidadEnCarrito());
        return jsonComida;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        setNombre(jsonObject.getString("nombre"));
        setPrecio(jsonObject.getDouble("precio"));
        setCantidadEnCarrito(jsonObject.getInt("cantidadEnCarrito"));
    }
}
