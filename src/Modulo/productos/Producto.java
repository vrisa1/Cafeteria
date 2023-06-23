package Modulo.productos;

import Modulo.json.I_Json;

public abstract class Producto implements I_Json {
    private String nombre;
    private double precio;
    private boolean disponible;
    private int cantidadVendidos;
    private String descripcion;

    public Producto() {
        this.nombre = "";
        this.precio = 0;
        this.disponible = true;
        this.cantidadVendidos = 0;
        this.descripcion = "";
    }

    public Producto(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.cantidadVendidos = cantidadVendidos;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    public void setCantidadVendidos(int cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //temporal; para poder aumentar cuando se venden
    public void aumentarCantidadVendidos(int cantidad){
        this.cantidadVendidos+=cantidad;
    }
    public void disminuirCantidadVendidos(int cantidad){
        this.cantidadVendidos-=cantidad;
    }
}
