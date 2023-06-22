package Modulo.productos.bebidas;

import Modulo.productos.bebidas.Bebida;

public class Infusion extends Bebida { //y otros

    public String temperatura;
    private Leche tipoDeLeche;


    public Infusion(String nombre, double precio, int disponibilidad, int cantidadVendidos, String descripcion) {
        super(nombre, precio, disponibilidad, cantidadVendidos, descripcion);
    }
}
