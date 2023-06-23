package Modulo.productos.bebidas;

import Modulo.productos.bebidas.Bebida;

import java.util.Objects;

public class Infusion extends Bebida { //y otros

    //ATRIBUTOS------------------------------------------------------------------------------------------------

    public String temperatura;
    private Leche tipoDeLeche;

    //CONSTRUCTORES--------------------------------------------------------------------------------------------

    public Infusion() {
        super();
        this.temperatura = "";
        this.tipoDeLeche = Leche.ENTERA;
        //no se si dejar leche entera como default y cambiarla despues
        //o si eliminar el constructor vacio
    }

    public Infusion(String nombre, double precio, boolean disponible, int cantidadVendidos, String descripcion,
                    int tamaño, String temperatura, Leche tipoDeLeche) {
        super(nombre, precio, disponible, cantidadVendidos, descripcion, tamaño);
        this.temperatura = temperatura;
        this.tipoDeLeche = tipoDeLeche;
    }

    //GETTERS Y SETTERS----------------------------------------------------------------------------------------

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public Leche getTipoDeLeche() {
        return tipoDeLeche;
    }

    public void setTipoDeLeche(Leche tipoDeLeche) {
        this.tipoDeLeche = tipoDeLeche;
    }

    //EQUALS Y TOSTRING----------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj != null){
            if(obj == this){
                flag = true;
            }
            else if(obj instanceof Infusion){
                Infusion aux = (Infusion) obj;
                if(getNombre().equals(aux.getNombre()) && getTamaño()==aux.getTamaño() &&
                getTemperatura().equals(aux.getTemperatura()) && getTipoDeLeche().equals(aux.getTipoDeLeche())){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        return "Infusion{" +
                super.toString() +
                "temperatura='" + temperatura + '\'' +
                ", tipoDeLeche=" + tipoDeLeche +
                '}';
    }

}
