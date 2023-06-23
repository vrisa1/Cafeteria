package Modulo.productos.comidas;

import Modulo.productos.Producto;

import java.util.Objects;

public class Comida extends Producto {

    //ATRIBUTOS---------------------------------------------------------------------------------------------------

    //private Date horarios;
    private boolean paraCompartir;

    //CONSTRUCTORES---------------------------------------------------------------------------------------------

    public Comida() {
        super();
        this.paraCompartir = false;
    }

    public Comida(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion, boolean paraCompartir) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion);
        this.paraCompartir = paraCompartir;
    }

    //GETTERS Y SETTERS------------------------------------------------------------------------------------------

    public boolean isParaCompartir() {
        return paraCompartir;
    }

    public void setParaCompartir(boolean paraCompartir) {
        this.paraCompartir = paraCompartir;
    }

    //EQUALS Y TOSTRING------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj != null){
            if(obj == this){
                flag = true;
            }
            else if(obj instanceof Comida){
                Comida aux = (Comida) obj;
                if(getNombre().equals(aux.getNombre())){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        return "Comida{" +
                super.toString() +
                "paraCompartir=" + paraCompartir +
                '}';
    }

}
