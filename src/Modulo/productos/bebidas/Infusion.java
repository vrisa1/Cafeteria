package Modulo.productos.bebidas;

import Modulo.productos.bebidas.Bebida;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;


public class Infusion extends Bebida { //y otros

    //ATRIBUTOS------------------------------------------------------------------------------------------------

    public String temperatura;
    private Leche tipoDeLeche;

    //CONSTRUCTORES--------------------------------------------------------------------------------------------

    public Infusion() {
        super();
        this.temperatura = "";
        this.tipoDeLeche = Leche.ENTERA;
        //no se si dejar leche entera como default y cambiarla despues
        //o si eliminar el constructor vacio
    }
  
    public Infusion(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion, int cantidadEnCarrito, double tamaño, String temperatura, Leche tipoDeLeche) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion, cantidadEnCarrito, tamaño);
        this.temperatura = temperatura;
        this.tipoDeLeche = tipoDeLeche;
    }

    //GETTERS Y SETTERS----------------------------------------------------------------------------------------

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

    //EQUALS Y TOSTRING----------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj != null){
            if(obj == this){
                flag = true;
            }
            else if(obj instanceof Infusion){
                Infusion aux = (Infusion) obj;
                if(getNombre().equals(aux.getNombre()) && getTamaño()==aux.getTamaño() &&
                getTemperatura().equals(aux.getTemperatura()) && getTipoDeLeche().equals(aux.getTipoDeLeche())){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        return "Infusion{" +
                super.toString() +
                "temperatura='" + temperatura + '\'' +
                ", tipoDeLeche=" + tipoDeLeche +
                '}';
    }

    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonInfusion = new JSONObject();
        jsonInfusion.put("nombre", getNombre());
        jsonInfusion.put("precio", getPrecio());
        jsonInfusion.put("disponible", isDisponible());
        jsonInfusion.put("cantidadVendidos", getCantidadVendidos());
        jsonInfusion.put("descripcion", getDescripcion());
        jsonInfusion.put("cantidadEnCarrito", getCantidadEnCarrito());
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
        setCantidadEnCarrito(jsonObject.getInt("cantidadEnCarrito"));
        setTamaño(jsonObject.getDouble("tamaño"));
        setTemperatura(jsonObject.getString("temperatura"));
        //setTipoDeLeche(jsonObject.getJSONObject("tipoDeLeche")); //como leo esto de json??
    }
}
