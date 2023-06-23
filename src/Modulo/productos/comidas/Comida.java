package Modulo.productos.comidas;

import Modulo.productos.Producto;
import org.json.JSONException;
import org.json.JSONObject;

public class Comida extends Producto {

    //private Date horarios;
    private boolean paraCompartir;

    public Comida() {
        super();
        this.paraCompartir = true;
    }

    public Comida(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion, boolean paraCompartir) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion);
        this.paraCompartir = paraCompartir;
    }

    public boolean isParaCompartir() {
        return paraCompartir;
    }

    public void setParaCompartir(boolean paraCompartir) {
        this.paraCompartir = paraCompartir;
    }

    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonComida = new JSONObject();
        jsonComida.put("nombre", getNombre());
        jsonComida.put("precio", getPrecio());
        jsonComida.put("disponible", isDisponible());
        jsonComida.put("cantidadVendidos", getCantidadVendidos());
        jsonComida.put("descripcion", getDescripcion());
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
        setParaCompartir(jsonObject.getBoolean("paraCompartir"));
    }
}
