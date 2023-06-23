package Modulo.productos.bebidas;

import Modulo.productos.bebidas.Bebida;
import Modulo.productos.comidas.Comida;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class BebidaEnvasada extends Bebida {

    //ATRIBUTOS-------------------------------------------------------------------------------------------------

    private boolean gas;
    private String linea;

    //CONSTRUCTORES---------------------------------------------------------------------------------------------

    public BebidaEnvasada() {
        super();
        this.gas = false;
        this.linea = "";
    }

    public BebidaEnvasada(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion, int cantidadEnCarrito, double tamaño, boolean gas, String linea) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion, cantidadEnCarrito, tamaño);
        this.gas = gas;
        this.linea = linea;
    }

    //GETTERS Y SETTERS-----------------------------------------------------------------------------------------

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

    //EQUALS Y TOSTRING-----------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj != null){
            if(obj == this){
                flag = true;
            }
            else if(obj instanceof BebidaEnvasada){
                BebidaEnvasada aux = (BebidaEnvasada) obj;
                if(getNombre().equals(aux.getNombre()) && getTamaño()==aux.getTamaño() &&
                        getLinea().equals(aux.getLinea()) && isGas()==aux.isGas()){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        return "BebidaEnvasada{" +
                super.toString() +
                "gas=" + gas +
                ", linea='" + linea + '\'' +
                '}';
    }

    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonBebida = new JSONObject();
        jsonBebida.put("nombre", getNombre());
        jsonBebida.put("precio", getPrecio());
        jsonBebida.put("disponible", isDisponible());
        jsonBebida.put("cantidadVendidos", getCantidadVendidos());
        jsonBebida.put("descripcion", getDescripcion());
        jsonBebida.put("cantidadEnCarrito", getCantidadEnCarrito());
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
        setCantidadEnCarrito(jsonObject.getInt("cantidadEnCarrito"));
        setTamaño(jsonObject.getDouble("tamaño"));
        setGas(jsonObject.getBoolean("gas"));
        setLinea(jsonObject.getString("linea"));
    }
}
