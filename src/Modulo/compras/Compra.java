package Modulo.compras;

import Modulo.compras.Carrito;
import Modulo.json.I_Json;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Compra implements I_Json {
    private int numeroTicket; //????
    private String fechaHora;
    private MetodosDePago metodoDePago;
    private Carrito carrito;

    public Compra() {
        this.numeroTicket = 0;
        this.fechaHora = "";
        this.metodoDePago = MetodosDePago.EFECTIVO;
        this.carrito = new Carrito();
    }

    public Compra(int numeroTicket) {
        this.numeroTicket = numeroTicket;
        this.fechaHora = new Date().toString();
        this.metodoDePago = MetodosDePago.EFECTIVO;
        this.carrito = new Carrito();
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public MetodosDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodosDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }


    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonCompra=new JSONObject();
        jsonCompra.put("numeroTicket", getNumeroTicket());
        jsonCompra.put("fechaHora", getFechaHora());
        jsonCompra.put("metodoDePago", getMetodoDePago());
        jsonCompra.put("carrito", carrito.toJSON());
        return jsonCompra;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        setNumeroTicket(jsonObject.getInt("numeroTicket"));
        setFechaHora(jsonObject.getString("fechaHora"));
        //setMetodoDePago(jsonObject.getJSONObject("metodoDePago")); //enum
        carrito.fromJSON(jsonObject.getJSONObject("carrito"));
    }
}
