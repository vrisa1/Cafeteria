package Modulo.productos.bebidas;

import Modulo.productos.bebidas.Bebida;
import org.json.JSONException;
import org.json.JSONObject;

public class Infusion extends Bebida { //y otros

    public String temperatura;
    private Leche tipoDeLeche;

    public Infusion() {
        super();
        this.temperatura = "";
    }

    public Infusion(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion);
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public Leche getTipoDeLeche() {
        return tipoDeLeche;
    }

    public void setTipoDeLeche(Leche tipoDeLeche) {
        this.tipoDeLeche = tipoDeLeche;
    }

    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonInfusion = new JSONObject();
        jsonInfusion.put("nombre", getNombre());
        jsonInfusion.put("precio", getPrecio());
        jsonInfusion.put("disponible", isDisponible());
        jsonInfusion.put("cantidadVendidos", getCantidadVendidos());
        jsonInfusion.put("descripcion", getDescripcion());
        jsonInfusion.put("tamaño", getTamaño());
        jsonInfusion.put("temperatura", getTemperatura());
        jsonInfusion.put("tipoDeLeche", getTipoDeLeche());
        return jsonInfusion;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        setNombre(jsonObject.getString("nombre"));
        setPrecio(jsonObject.getDouble("precio"));
        setDisponible(jsonObject.getBoolean("disponible"));
        setCantidadVendidos(jsonObject.getInt("cantidadVendidos"));
        setDescripcion(jsonObject.getString("descripcion"));
        setTamaño(jsonObject.getDouble("tamaño"));
        setTemperatura(jsonObject.getString("temperatura"));
        //setTipoDeLeche(jsonObject.getJSONObject("tipoDeLeche")); //como leo esto de json??
    }
}
