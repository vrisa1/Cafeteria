package Modulo.productos.bebidas;

import Modulo.productos.bebidas.Bebida;

public class BebidaEnvasada extends Bebida {

    private boolean gas;
    private String linea;

    public BebidaEnvasada(String nombre, double precio, int disponibilidad, int cantidadVendidos, String descripcion) {
        super(nombre, precio, disponibilidad, cantidadVendidos, descripcion);
    }
}
