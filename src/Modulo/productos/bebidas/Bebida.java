package Modulo.productos.bebidas;

import Modulo.productos.Producto;

public abstract class Bebida extends Producto {

    private double tamaño;

    public Bebida(String nombre, double precio, int disponibilidad, int cantidadVendidos, String descripcion) {
        super(nombre, precio, disponibilidad, cantidadVendidos, descripcion);
    }
}
