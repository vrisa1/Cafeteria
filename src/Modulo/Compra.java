package Modulo;

import java.util.Date;

public class Compra {
    private int numeroTicket; //????
    private Date fechaHora;

    //private metodoDePago; enum hacer
    private Carrito carrito;

    public Compra(int numeroTicket) {
        this.numeroTicket = numeroTicket;
        this.fechaHora = new Date();
        //this.metodoDePago = ""; //?
        this.carrito = new Carrito();
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public Date getFechaHora() {
        return fechaHora;
    }


}
