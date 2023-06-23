package Modulo.productos.bebidas;

import Modulo.productos.Producto;

public abstract class Bebida extends Producto {

    //ATRIBUTOS-------------------------------------------------------------------------------------------------

    private double tamaño;

    //CONSTRUCTORES---------------------------------------------------------------------------------------------

    public Bebida() {
        super();
        this.tamaño = 0;
    }

    public Bebida(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion, int cantidadEnCarrito, double tamaño) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion, cantidadEnCarrito);
        this.tamaño = tamaño;
    }

    //GETTERS Y SETTERS-----------------------------------------------------------------------------------------

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    //TOSTRING--------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Bebida{" +
                super.toString() +
                "tamaño=" + tamaño +
                '}';
    }

}
