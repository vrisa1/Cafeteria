package Modulo.productos.bebidas;

import Modulo.productos.bebidas.Bebida;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

/**
 * Subclase, hereda de Bebida.
 * No es abstracta, se puede instanciar.
 * Implementa los métodos de la interfaz I_Json.
 * Tiene atributos propios.
 */
public class Infusion extends Bebida { //y otros

    //ATRIBUTOS------------------------------------------------------------------------------------------------

    public String temperatura;
    private Leche tipoDeLeche;

    //CONSTRUCTORES--------------------------------------------------------------------------------------------

    public Infusion() {
        super();
        this.temperatura = "";
        this.tipoDeLeche = null;
    }

    public Infusion(String nombre, double precio, boolean disponible, String descripcion, double tamaño, String temperatura, Leche tipoDeLeche) {
        super(nombre, precio, disponible, descripcion, tamaño);
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
        if (obj != null) {
            if (obj == this) {
                flag = true;
            } else if (obj instanceof Infusion) {
                Infusion aux = (Infusion) obj;
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
        return "Infusion{" +
                super.toString() +
                "temperatura='" + temperatura + '\'' +
                ", tipoDeLeche=" + tipoDeLeche +
                '}' + "\n";
    }

    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonInfusion = new JSONObject();
        jsonInfusion.put("nombre", getNombre());
        jsonInfusion.put("precio", getPrecio());
        jsonInfusion.put("cantidadEnCarrito", getCantidadEnCarrito());
        jsonInfusion.put("tamaño", getTamaño());
        jsonInfusion.put("temperatura", getTemperatura());
        jsonInfusion.put("tipoDeLeche", getTipoDeLeche().name());
        return jsonInfusion;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        setNombre(jsonObject.getString("nombre"));
        setPrecio(jsonObject.getDouble("precio"));
        setCantidadEnCarrito(jsonObject.getInt("cantidadEnCarrito"));
        setTamaño(jsonObject.getDouble("tamaño"));
        setTemperatura(jsonObject.getString("temperatura"));
        String aux= jsonObject.getString("tipoDeLeche");
        if(aux.equals(Leche.ENTERA.name())){
            setTipoDeLeche(Leche.ENTERA);
        } else if(aux.equals(Leche.ALMENDRA.name())){
            setTipoDeLeche(Leche.ALMENDRA);
        } else if(aux.equals(Leche.COCO.name())) {
            setTipoDeLeche(Leche.COCO);
        } else {
            setTipoDeLeche(Leche.DESLACTOSADA);
        }
    }
}