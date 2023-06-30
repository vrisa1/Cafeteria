package Modulo.productos;

import Modulo.json.I_Json;

import java.io.Serializable;

/**
 * Clase abstracta. Es "padre" de las clases Comida y Bebida.
 * Implementa la interfaz I_Json para leer y escribir los productos comprados.
 * Implementa Serializable para leer y escribir los archivos del menú.
 */
public abstract class Producto implements Serializable, I_Json {

    //ATRIBUTOS--------------------------------------------------------------------------------------------------
    private String nombre;
    private double precio;
    private boolean disponible;
    private String descripcion;
    private transient int cantidadEnCarrito; //para saber cuantos productos se estan comprando

    //CONSTRUCTORES----------------------------------------------------------------------------------------------

    public Producto() {
        this.nombre = "";
        this.precio = 0;
        this.disponible = false;
        this.descripcion = "";
        this.cantidadEnCarrito = 0;
    }

    public Producto(String nombre, double precio, boolean disponible, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.descripcion = descripcion;
        this.cantidadEnCarrito = 0;
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
                ", descripcion='" + descripcion + '\'' +
                '}';
    }


    //OTROS METODOS------------------------------------------------------------------------------------------------

    /**
     *Permite deshacer el agregado de elementos al carrito, indicando la cantidad que se quiere restar sobre el
     * total del producto indicado.
     * @param cantidad - Número de productos que se disminuirán del total de productos del carrito.
     */
    public void disminuirCantidadEnCarrito(int cantidad) {
        this.cantidadEnCarrito -= cantidad;

    }
}

