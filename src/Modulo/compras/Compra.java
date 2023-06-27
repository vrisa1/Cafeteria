package Modulo.compras;

import Modulo.compras.Carrito;
import Modulo.json.I_Json;
import Modulo.productos.bebidas.Leche;
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
        this.metodoDePago = null;
        this.carrito = new Carrito();
    }

    public Compra(int numeroTicket) {
        this.numeroTicket = numeroTicket;
        this.fechaHora = new Date().toString();
        this.metodoDePago = null;
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


    //donde va la compra? como se compra? :/
    public void realizarCompra(){
        Carrito nuevo = new Carrito();
    }


    //JSON -----------------------------------------------------------------------------------------------------
    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jsonCompra=new JSONObject();
        jsonCompra.put("numeroTicket", getNumeroTicket());
        jsonCompra.put("fechaHora", getFechaHora());
        jsonCompra.put("metodoDePago", getMetodoDePago().name());
        jsonCompra.put("carrito", carrito.toJSON());
        return jsonCompra;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException {
        setNumeroTicket(jsonObject.getInt("numeroTicket"));
        setFechaHora(jsonObject.getString("fechaHora"));
        String aux= jsonObject.getString("metodoDePago");
        if(aux.equals(MetodosDePago.EFECTIVO.name())){
            setMetodoDePago(MetodosDePago.EFECTIVO);
        } else if(aux.equals(MetodosDePago.DEBITO.name())){
            setMetodoDePago(MetodosDePago.DEBITO);
        } else {
            setMetodoDePago(MetodosDePago.CREDITO);
        }
        carrito.fromJSON(jsonObject.getJSONObject("carrito"));
    }
}
