package Modulo.productos.bebidas;

import Modulo.productos.bebidas.Bebida;
import org.json.JSONException;
import org.json.JSONObject;

public class BebidaEnvasada extends Bebida {

    private boolean gas;
    private String linea;

    public BebidaEnvasada() {
        super();
        this.gas=true;
        this.linea="";
    }

    public BebidaEnvasada(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion);
    }

    public boolean isGas() {
        return gas;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonBebida = new JSONObject();
        jsonBebida.put("nombre", getNombre());
        jsonBebida.put("precio", getPrecio());
        jsonBebida.put("disponible", isDisponible());
        jsonBebida.put("cantidadVendidos", getCantidadVendidos());
        jsonBebida.put("descripcion", getDescripcion());
        jsonBebida.put("tamaño", getTamaño()); //claves con ñ?????
        jsonBebida.put("gas", isGas());
        jsonBebida.put("linea", getLinea());
        return jsonBebida;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        setNombre(jsonObject.getString("nombre"));
        setPrecio(jsonObject.getDouble("precio"));
        setDisponible(jsonObject.getBoolean("disponible"));
        setCantidadVendidos(jsonObject.getInt("cantidadVendidos"));
        setDescripcion(jsonObject.getString("descripcion"));
        setTamaño(jsonObject.getDouble("tamaño"));
        setGas(jsonObject.getBoolean("gas"));
        setLinea(jsonObject.getString("linea"));
    }
}
