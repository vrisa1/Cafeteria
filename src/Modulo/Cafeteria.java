package Modulo;

import Modulo.Excepciones.ContraseñaIncorrectaException;
import Modulo.Excepciones.UsuarioNoExisteException;
import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.compras.Compra;
import Modulo.compras.MetodosDePago;
import Modulo.Excepciones.UsuarioYaExisteException;
import Modulo.genericas.Contenedor;
import Modulo.genericas.ContenedorMapa;

import Modulo.json.JsonUtiles;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.comidas.Comida;
import Modulo.usuarios.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

/**
 * Clase envoltorio.
 * Se encarga de dar funcionamiento al programa, acoplando las colecciones, leyendo y escribiendo
 * archivos y json, da comienzo y fin a la ejecución.
 * Contiene un mapa de usuarios y otro de compras, set de productos segun la clasificacion de los
 * mismos, y el numero de ticket para dar seguimiento
 * a las ventas realizadas.
 */
public class Cafeteria {

    //ATRIBUTOS-----------------------------------------------------------------------------------------------------

    private ContenedorMapa<String, Usuario> usuarios;
    private ContenedorMapa<Integer, Compra> compras;
    private int cantidadCompras; //para el numero de ticket
    private Contenedor<Producto> comidas;
    private Contenedor<Producto> infusiones;
    private Contenedor<Producto> bebidasEnvasadas;

    //CONSTRUCTOR---------------------------------------------------------------------------------------------------

    public Cafeteria() {
        this.usuarios = new ContenedorMapa<>();
        this.compras= new ContenedorMapa<>();
        this.cantidadCompras=0;
        this.comidas = new Contenedor<>();
        this.infusiones = new Contenedor<>();
        this.bebidasEnvasadas = new Contenedor<>();
    }

    //GETTERS Y SETTER---------------------------------------------------------------------------------------------

    public int getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(int cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }

    //Iniciar y cerrar programa
    public String iniciar(){
        String exception = "Carga correcta de compras";

        cargarMenu(); //lee los archivos de productos
        crearAdmin();
        cargarUsuarios(); //lee el archivo de usuarios

        try{
            iniciarCompras(); //lee el json de compras
        }
        catch (JSONException e){
            exception= e.getMessage();
        }
        return exception;
    }

    public String cerrar(){
        String exception="Compras guardadas";

        actualizarMenu(); //guarda los productos en archivos
        actualizarUsuarios(); //guarda los usuarios en el archivo

        try{
            guardarJsonCompras(); //guarda las compras en json
        }
        catch (JSONException e){
            exception= e.getMessage();
        }
        return exception;
    }

    //USUARIOS------------------------------------------------------------------------------------------------------

    /**
     * Crea un nuevo usuario y asigna nombre, email y contraseña correspondiente.
     * @param nombre - Identificador del usuario.
     * @param cont - Contraseña de la cuenta.
     * @param mail - Email asociado a la cuenta.
     * @return agregado - Boolean que indica si el usuario fue creado correctamente.
     * @throws UsuarioYaExisteException - Si el identificador de usuario ya pertenece a otra cuenta.
     */
    public boolean CrearUsuario(String nombre,String cont,String mail) throws UsuarioYaExisteException {
        boolean agregado = false;
        if(usuarios.buscar(nombre)==null){
            Usuario nuevo = new Usuario(nombre,cont,mail);
           usuarios.agregar(nuevo.getNombreDeUsuario(),nuevo);
            agregado = true;
        }else {
            throw new UsuarioYaExisteException("Usuario ya Existe");
        }
       return agregado;
    }

    /**
     * Crea un usuario de tipo administrador.
     * @return boolean - Indica si el usuario administrador fue creado correctamente.
     */
    private boolean crearAdmin(){
        Usuario admin = new Usuario("admin","1234","");
        admin.setAdministrador(true);
        return usuarios.agregar(admin.getNombreDeUsuario(),admin);
    }

    /**
     * Permite iniciar sesión en el sistema.
     * @param usuario - Nombre del usuario que inicia sesión.
     * @param cont - Contraseña del usuario que inicia sesión.
     * @return ingreso - int que indica el tipo de usuario que inició sesión: 1 si es administrador
     * o 2 si es cliente.
     * @throws UsuarioNoExisteException - Excepción lanzada si el identificador de usuario ingresado
     * no existe o no es válido.
     * @throws ContraseñaIncorrectaException - Excepción lanzada si la contraseña de usuario ingresada
     * no existe o no es válida.
     */
    public int login(String usuario,String cont) throws UsuarioNoExisteException, ContraseñaIncorrectaException {
        Usuario encontrado = usuarios.buscar(usuario);
        int ingreso=0;

        if(encontrado!=null){
            if(encontrado.getContraseña().equals(cont)){
                if(encontrado.isAdministrador()){
                   ingreso =1; ///Ingreso admin
                }else{
                    ingreso=2;///Ingreso cliente
                }
            }else{
                throw new ContraseñaIncorrectaException("Contraseña Incorrecta", usuario);
            }
        }else{
            throw new UsuarioNoExisteException("Usuario Incorrecto", usuario);
        }
        return ingreso;
    }

    /**
     * Permite modificar los datos de un usuario.
     * @param usuario - Nombre del usuario que se desea modificar.
     * @param mail - Email del usuario que se desea modificar.
     * @param cont - Contraseña del usuario que se desea modificar.
     * @return modif - boolean que indica si el usuario fue modificado correctamente.
     */
    public boolean modificarUsuario(String usuario,String mail,String cont){
        boolean modif= false;
        if(usuarios.buscar(usuario)!=null){
            Usuario aux = usuarios.buscar(usuario);
            aux.setMail(mail);
            aux.setContraseña(cont);
            modif = true;
        }
        return modif;
    }

    /**
     * Lista datos de usuarios (ContenedorMapa).
     * @return String - datos del ContenedorMapa de usuarios listados en forma de String.
     */
    public String mostrar(){
        return usuarios.listar();
    }

    /**
     * Permite eliminar un usuario buscándolo por identificador.
     * @param usuario - Nombre de usuario que se quiere eliminar.
     * @return eliminado - boolean que indica si el usuario fue correctamente eliminado.
     * @throws UsuarioNoExisteException - Excepción que se lanza si el usuario que se quiere
     * eliminar no existe.
     */
    public boolean eliminarUsuario(String usuario) throws UsuarioNoExisteException {
        boolean eliminado=false;
        if(!usuarios.quitar(usuario)){
            throw new UsuarioNoExisteException("Usuario no Existe", usuario);
        }else{
            eliminado= true;
        }
        return eliminado;
    }

    /**
     *
     * @return iterator de mapa de usuarios.
     */
    public Iterator<Map.Entry<String, Usuario>> iterarUsuarios(){
        return usuarios.iterar();
    }

    /**
     * Cuenta la cantidad de usuarios.
     * @return cantidad de usuarios en el mapa.
     */
    public int cantUsuarios(){
        return usuarios.contar();
    }

    /**
     * Lee el archivo de usuarios y escribe los datos en el mapa.
     */
    public void cargarUsuarios(){
        ControladorArchivosObjetos.leer("usuarios.dat",usuarios);
    }

    /**
     * Escribe usuarios almacenados en el mapa en un archivo.
     */
    public void actualizarUsuarios(){
        ControladorArchivosObjetos.grabar("usuarios.dat",usuarios);
    }

    //COMPRAS--------------------------------------------------------------------------------------------------------

    /**
     * Lee el json de compras y las agrega en el mapa de compras.
     * Cuenta la cantidad de compras para actualizar el atributo cantidadCompras.
     * @throws JSONException - Excepción lanzada al producirse un error de lectura de json.
     */
    public void iniciarCompras() throws JSONException {

        //leo el json y lo guardo en el contenedor
        JSONArray jsonArray =new JSONArray(JsonUtiles.leer("compras"));
        for (int i=0; i< jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Compra aux= new Compra();
            aux.fromJSON(jsonObject);
            compras.agregar(aux.getNumeroTicket(), aux);
        }

        cantidadCompras = compras.contar() + 1;
    }

    /**
     * Finaliza una compra y la guarda en el contenedor.
     * @param compra - Compra a finalizar.
     * @param metodoDePago - Método de pago elegido.
     */
    public void finalizarCompra(Compra compra, MetodosDePago metodoDePago){
        compra.setMetodoDePago(metodoDePago);
        compras.agregar(compra.getNumeroTicket(), compra);
        cantidadCompras++;
    }

    /**
     * Lista las compras del contenedor.
     * @return String - Listado de compras.
     */
    public String mostrarCompras(){
        return compras.listar();
    }

    /**
     *
     * @return iterator de mapa de compras.
     */
    public Iterator<Map.Entry<Integer,Compra>> iterarCompras(){
        return  compras.iterar();
    }

    /**
     * Guarda el mapa de compras en json.
     * @throws JSONException - Se lanza ante un error de escritura de json.
     */
    public void guardarJsonCompras() throws JSONException {

        //guardo el contenedor en json
        JSONArray jsonArray =new JSONArray();
        Iterator<Map.Entry<Integer, Compra>> it = compras.iterar();
        while (it.hasNext()){
            jsonArray.put(it.next().getValue().toJSON());
        }
        JsonUtiles.grabar(jsonArray, "compras");
    }

//PRODUCTOS--------------------------------------------------------------------------------------------------------

    /**
     * Lee los archivos de productos y los carga en los contenedores.
     */
    public void cargarMenu(){
        ControladorArchivosObjetos.leer("Comida.dat",comidas);
        ControladorArchivosObjetos.leer("Infusion.dat",infusiones);
        ControladorArchivosObjetos.leer("BebidaEnvasada.dat",bebidasEnvasadas);
    }

    /**
     * Escribe en los archivos de productos el contenido de los contenedores.
     */
    public void actualizarMenu(){
        ControladorArchivosObjetos.grabar("Comida.dat",comidas);
        ControladorArchivosObjetos.grabar("Infusion.dat",infusiones);
        ControladorArchivosObjetos.grabar("BebidaEnvasada.dat",bebidasEnvasadas);
    }

    /**
     * Agrega un producto a un contenedor según su clase.
     * @param nuevo - Producto que se quiere agregar al contenedor.
     */
    public void agregarProducto(Producto nuevo){ //arreglar!!
        if(nuevo instanceof Comida){
            comidas.agregarProducto(nuevo);
        } else if (nuevo instanceof Infusion) {
            infusiones.agregarProducto(nuevo);
        }else {
            bebidasEnvasadas.agregarProducto(nuevo);
        }
    }

    /**
     * Elimina un producto de su respectivo contenedor.
     * @param producto - Producto a eliminar.
     */
    public void eliminarProducto(Producto producto){
        if (producto instanceof Comida){
            comidas.quitarProducto((Comida) producto);
        } else if(producto instanceof BebidaEnvasada){
            bebidasEnvasadas.quitarProducto((BebidaEnvasada) producto);
        } else {
            infusiones.quitarProducto((Infusion) producto);
        }
    }

    /**
     *
     * @return iterator de set de comidas.
     */
    public Iterator<Producto> iterarComida(){
        return  comidas.iterar();
    }

    /**
     *
     * @return iterator de set de infusiones.
     */
    public Iterator<Producto> iterarInfusiones(){
        return infusiones.iterar();
    }

    /**
     *
     * @return iterator de set de bebidas envasadas.
     */
    public Iterator<Producto> iterarEnvasadas(){
        return bebidasEnvasadas.iterar();
    }

    /**
     * Cuenta la cantidad de comidas en el contenedor.
     * @return cantidad de comidas en el set.
     */
    public int cantComidas(){
        return comidas.contar();
    }

    /**
     * Cuenta la cantidad de infusiones en el contenedor.
     * @return cantidad de infusiones en el set.
     */
    public int cantInfusiones(){
        return infusiones.contar();
    }

    /**
     * Cuenta la cantidad de bebidas envasadas en el contenedor.
     * @return cantidad de bebidas envasadas en el set.
     */
    public int cantEnvasadas(){
        return bebidasEnvasadas.contar();
    }

    /**
     * Lista todos los productos de todos los set.
     * @return listado de productos en formato String.
     */
    public String mostrarMenu(){
        String menu = "";
        menu += comidas.listar() + "\n";
        menu += infusiones.listar() + "\n";
        menu += bebidasEnvasadas.listar() + "\n";
        return menu;
    }

}
