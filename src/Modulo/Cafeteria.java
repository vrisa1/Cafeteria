package Modulo;

import Modulo.Excepciones.ContraseñaIncorrectaException;
import Modulo.Excepciones.UsuarioNoExisteException;
import Modulo.archivos.ControladorArchivosObjetos;
import Modulo.compras.Compra;
import Modulo.compras.MetodosDePago;
import Modulo.Excepciones.UsuarioYaExisteException;
import Modulo.InterfazGrafica.InterfazAdmin;
import Modulo.genericas.Contenedor;
import Modulo.genericas.ContenedorMapa;

import Modulo.json.JsonUtiles;
import Modulo.productos.Producto;
import Modulo.usuarios.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class Cafeteria {

    private ContenedorMapa<String, Usuario> usuarios;
    private ContenedorMapa<Integer, Compra> compras;
    private int cantidadCompras; //para el numero de ticket

    private Contenedor<Producto> comidas;
    private Contenedor<Producto> infusiones;
    private Contenedor<Producto> bebidasEnvasadas;

    public Cafeteria() {
        this.usuarios = new ContenedorMapa<>();
        this.compras= new ContenedorMapa<>();
        this.cantidadCompras=0;
        this.comidas = new Contenedor<>();
        this.infusiones = new Contenedor<>();
        this.bebidasEnvasadas = new Contenedor<>();
    }

    public int getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(int cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }


    //USUARIOS------------------------------------------------------------------------------------------------------

    public boolean CrearUsuario(String nombre,String cont,String mail) throws UsuarioYaExisteException {
        boolean agregado = false;
        if(usuarios.buscar(nombre)==null){
            Usuario nuevo = new Usuario(nombre,cont,mail);
           usuarios.agregar(nuevo.getNombreDeUsuario(),nuevo);
            agregado = true;
        }else {
            throw new UsuarioYaExisteException("Usuario ya Existe");
        }
       return agregado; /// sacar retornos?
    }

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
                throw new ContraseñaIncorrectaException("Contraseña Incorrecta");
            }
        }else{
            throw new UsuarioNoExisteException("Usuario Incorrecto");
        }
        return ingreso;
    }

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

    public String mostrar(){
        return usuarios.listar();
    }

    public String eliminarUsuario(String usuario) throws UsuarioNoExisteException {
        String eliminado="";
        if(!usuarios.quitar(usuario)){
            throw new UsuarioNoExisteException("Usuario no Existe");
        }else{
            eliminado= "Eliminado con éxito";
        }
        return eliminado;
    }


    //COMPRAS--------------------------------------------------------------------------------------------------------

    public void iniciarCompras() throws JSONException {

        //leo el json y lo guardo en el contenedor
        JSONArray jsonArray =new JSONArray(JsonUtiles.leer("compras"));
        for (int i=0; i< jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Compra aux= new Compra();
            aux.fromJSON(jsonObject);
            compras.agregar(aux.getNumeroTicket(), aux);
        }

        cantidadCompras = compras.contar() + 1; //
    }

    public void finalizarCompra(Compra compra, MetodosDePago metodoDePago){
        compra.setMetodoDePago(metodoDePago);
        compras.agregar(compra.getNumeroTicket(), compra);
        cantidadCompras++;
    }
    public String mostrarCompras(){
        return compras.listar();
    }

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

    public void cargarMenu(){
        ControladorArchivosObjetos.leer("Comida.dat",comidas);
        ControladorArchivosObjetos.leer("Infusion.dat",infusiones);
        ControladorArchivosObjetos.leer("BebidaEnvasada.dat",bebidasEnvasadas);
    }

    public void actualizarMenu(){
        ControladorArchivosObjetos.grabar("Comida.dat",comidas);
        ControladorArchivosObjetos.grabar("Infusion.dat",infusiones);
        ControladorArchivosObjetos.grabar("BebidaEnvasada.dat",bebidasEnvasadas);
    }

    public String mostrarMenu(){
        String menu = "";
        menu += comidas.listar() + "\n";
        menu += infusiones.listar() + "\n";
        menu += bebidasEnvasadas.listar();
        return menu;
    }

}
