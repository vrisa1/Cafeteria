package Modulo.productos.comidas;

import Modulo.productos.Producto;

public class Comida extends Producto {

    //private Date horarios;
    private boolean paraCompartir;

    public Comida(String nombre, double precio, int disponibilidad, int cantidadVendidos, String descripcion) {
        super(nombre, precio, disponibilidad, cantidadVendidos, descripcion);
    }
}
