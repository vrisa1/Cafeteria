package Modulo.productos.bebidas;

import Modulo.productos.Producto;

public abstract class Bebida extends Producto {

    private double tamaño;

    public Bebida() {
        super();
        this.tamaño=0;
    }

    public Bebida(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion);
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }
}
