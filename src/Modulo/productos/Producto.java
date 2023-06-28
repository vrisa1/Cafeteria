package Modulo.productos;

import Modulo.json.I_Json;

import java.io.Serializable;

public abstract class Producto implements Serializable, I_Json {

    //ATRIBUTOS--------------------------------------------------------------------------------------------------
    private String nombre;
    private double precio;
    private boolean disponible;
    private int cantidadVendidos;
    private String descripcion;
    private transient int cantidadEnCarrito; //para saber cuantos productos se estan comprando

    //CONSTRUCTORES----------------------------------------------------------------------------------------------

    public Producto() {
        this.nombre = "";
        this.precio = 0;
        this.disponible = false;
        this.cantidadVendidos = 0;
        this.descripcion = "";
        this.cantidadEnCarrito = 0;
    }

    public Producto(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion, int cantidadEnCarrito) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.cantidadVendidos = cantidadVendidos;
        this.descripcion = descripcion;
        this.cantidadEnCarrito = cantidadEnCarrito;
    }

    //GETTERS Y SETTERS------------------------------------------------------------------------------------------

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

    public int getCantidadEnCarrito() {
        return cantidadEnCarrito;
    }

    public void setCantidadEnCarrito(int cantidadEnCarrito) {
        this.cantidadEnCarrito = cantidadEnCarrito;
    }

    //TOSTRING------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", cantidadVendidos=" + cantidadVendidos +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    //para poder aumentar/disminuir cuando se venden
    public void aumentarCantidadVendidos(int cantidad) {
        this.cantidadVendidos += cantidad;
    }


    public void disminuirCantidadVendidos(int cantidad) {
        this.cantidadVendidos -= cantidad;
    }

    public void disminuirCantidadEnCarrito(int cantidad) {
        this.cantidadEnCarrito -= cantidad;
    }
}

