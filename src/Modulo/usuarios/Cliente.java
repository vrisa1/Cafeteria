package Modulo.usuarios;

import Modulo.Compra;

import java.util.HashMap;

public class Cliente extends Usuario {
    HashMap<Integer, Compra> compras; //key: num de ticket



    public Cliente(String id, String nombreDeUsuario, String contraseña) {
        super(id, nombreDeUsuario, contraseña);
    }

    @Override
    public String toString() {
        return "Cliente{}"+super.toString();
    }
}
