package Modulo.productos.comidas;

import Modulo.productos.Producto;

public class Comida extends Producto {

    //private Date horarios;
    private boolean paraCompartir;

    public Comida(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion, boolean paraCompartir) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion);
        this.paraCompartir = paraCompartir;
    }

}
