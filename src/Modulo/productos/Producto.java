package Modulo.productos;

import java.io.Serializable;
import java.util.Objects;

public abstract class Producto implements Serializable {

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
    }

    public Producto(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.cantidadVendidos = cantidadVendidos;
        this.descripcion = descripcion;
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

}
