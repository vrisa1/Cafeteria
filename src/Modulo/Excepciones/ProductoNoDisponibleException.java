package Modulo.Excepciones;

/**
 *ProductoNoDisponibleException
 * Excepción lanzada al intentar agregar un producto no disponible al carrito.
 */
public class ProductoNoDisponibleException extends Exception{
    /**
     * Constructor de la excepción.
     * Llama a la superclase y envía el String recibido por parámetro,
     * el cual se mostrará al usuario al atrapar la excepción.
     * @param message - Mensaje de error enviado al lanzarse la excepción.
     */
    public ProductoNoDisponibleException(String message) {
        super(message);
    }
}
