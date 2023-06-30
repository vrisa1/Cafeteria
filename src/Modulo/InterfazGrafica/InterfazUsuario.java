package Modulo.InterfazGrafica;

import Modulo.Cafeteria;
import Modulo.Excepciones.ProductoNoDisponibleException;
import Modulo.compras.Compra;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.bebidas.Leche;
import Modulo.productos.comidas.Comida;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class InterfazUsuario extends JFrame {

    private JPanel panel1;
    private JSpinner cantidad;
    private JTabbedPane productos;
    private JTable comidas;
    private JTable infusiones;
    private JTable bebidas;
    private JButton agregarAlCarritoButton1;
    private JButton verCarritoButton;
    private JComboBox tipoDeLeche;
    private JButton agregarAlCarritoButton;
    private JSpinner cantidad1;
    private JButton agregarAlCarritoButton2;
    private JSpinner cantidad2;
    private JButton salirDelProgramaButton;
    private DefaultTableModel modelComidas;
    private DefaultTableModel modelInfusiones;
    private DefaultTableModel modelEnvasadas;

    public InterfazUsuario(Cafeteria cafeteria) {

        setContentPane(panel1);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        pack();
        setVisible(true);


        //Comidas
        modelComidas = new DefaultTableModel();

        String[] col ={"Nombre","Descripcion","Precio","Compartir", "Disponible"};

        Iterator<Producto> itComida = cafeteria.iterarComida();
        String[][] listaComidas = new String[cafeteria.cantComidas()][col.length];
        int i =0;
        while (itComida.hasNext()){
            String[] comidas = new String[col.length];
            Comida aux = (Comida) itComida.next();
            comidas[0] = aux.getNombre();
            comidas[1] = aux.getDescripcion();
            comidas[2] = new String("$"+ String.valueOf(aux.getPrecio()));
            comidas[3] = String.valueOf(aux.isParaCompartir());
            comidas[4] = String.valueOf(aux.isDisponible());
            listaComidas[i++] = comidas;
        }

        modelComidas.setDataVector(listaComidas,col);
        comidas.setModel(modelComidas);

        TableColumnModel columnModelCom = comidas.getColumnModel();
        TableColumn colCom0 = columnModelCom.getColumn(0);
        TableColumn colCom1 = columnModelCom.getColumn(1);
        TableColumn colCom2 = columnModelCom.getColumn(2);
        TableColumn colCom3 = columnModelCom.getColumn(3);
        TableColumn colCom4 = columnModelCom.getColumn(4);

        colCom0.setMinWidth(150);
        colCom0.setMaxWidth(150);
        colCom1.setMinWidth(500);
        colCom1.setMaxWidth(500);
        colCom2.setMaxWidth(100);
        colCom2.setMinWidth(100);
        colCom3.setMaxWidth(100);
        colCom3.setMinWidth(100);
        colCom4.setMaxWidth(100);
        colCom4.setMinWidth(100);


        //Infusiones
        modelInfusiones = new DefaultTableModel();
        String[] colInfusiones ={"Nombre","Descripcion","Precio","Tamaño", "Temperatura","Disponible"};

        Iterator<Producto> itInfusiones = cafeteria.iterarInfusiones();
        String[][] listaInfusiones = new String[cafeteria.cantInfusiones()][colInfusiones.length];
        int j =0;
        while (itInfusiones.hasNext()){
            String[] infusiones = new String[colInfusiones.length];
            Infusion aux = (Infusion) itInfusiones.next();
            infusiones[0] = aux.getNombre();
            infusiones[1] = aux.getDescripcion();
            infusiones[2] = "$" + String.valueOf(aux.getPrecio());
            infusiones[3] = String.valueOf(aux.getTamaño());
            infusiones[4] = aux.getTemperatura();
            infusiones[5] = String.valueOf(aux.isDisponible());
            listaInfusiones[j++] = infusiones;
        }

        modelInfusiones.setDataVector(listaInfusiones,colInfusiones);
        infusiones.setModel(modelInfusiones);

        TableColumnModel columnModelInf = infusiones.getColumnModel();
        TableColumn colInf0 = columnModelInf.getColumn(0);
        TableColumn colInf1 = columnModelInf.getColumn(1);
        TableColumn colInf2 = columnModelInf.getColumn(2);
        TableColumn colInf3 = columnModelInf.getColumn(3);
        TableColumn colInf4 = columnModelInf.getColumn(4);
        TableColumn colInf5 = columnModelInf.getColumn(5);

        colInf0.setMinWidth(150);
        colInf0.setMaxWidth(150);
        colInf1.setMinWidth(500);
        colInf1.setMaxWidth(500);
        colInf2.setMinWidth(100);
        colInf2.setMaxWidth(100);
        colInf3.setMinWidth(100);
        colInf3.setMaxWidth(100);
        colInf4.setMinWidth(100);
        colInf4.setMaxWidth(100);
        colInf5.setMinWidth(100);
        colInf5.setMaxWidth(100);


        //Bebidas envasadas
        modelEnvasadas = new DefaultTableModel();

        String[] colEnvasadas ={"Nombre","Descripcion","Precio","Tamaño","Linea","Gasificada", "Disponible"};

        Iterator<Producto> itEnvasadas = cafeteria.iterarEnvasadas();
        String[][] listaEnvasadas = new String[cafeteria.cantEnvasadas()][colEnvasadas.length];
        int k =0;
        while (itEnvasadas.hasNext()){
            String[] envasadas = new String[colEnvasadas.length];
            BebidaEnvasada aux = (BebidaEnvasada) itEnvasadas.next();
            envasadas[0] = aux.getNombre();
            envasadas[1] = aux.getDescripcion();
            envasadas[2] = "$" + String.valueOf(aux.getPrecio());
            envasadas[3] = String.valueOf(aux.getTamaño()) + "cc";
            envasadas[4] = aux.getLinea();
            envasadas[5] = String.valueOf(aux.isGas());
            envasadas[6] = String.valueOf(aux.isDisponible());
            listaEnvasadas[k++] = envasadas;
        }

        modelEnvasadas.setDataVector(listaEnvasadas,colEnvasadas);
        bebidas.setModel(modelEnvasadas);

        TableColumnModel columnModelBeb = bebidas.getColumnModel();
        TableColumn colBeb0 = columnModelBeb.getColumn(0);
        TableColumn colBeb1 = columnModelBeb.getColumn(1);
        TableColumn colBeb2 = columnModelBeb.getColumn(2);
        TableColumn colBeb3 = columnModelBeb.getColumn(3);
        TableColumn colBeb4 = columnModelBeb.getColumn(4);
        TableColumn colBeb5 = columnModelBeb.getColumn(5);
        TableColumn colBeb6 = columnModelBeb.getColumn(6);

        colBeb0.setMinWidth(150);
        colBeb0.setMaxWidth(150);
        colBeb1.setMinWidth(500);
        colBeb1.setMaxWidth(500);
        colBeb2.setMinWidth(100);
        colBeb2.setMaxWidth(100);
        colBeb3.setMinWidth(100);
        colBeb3.setMaxWidth(100);
        colBeb4.setMinWidth(100);
        colBeb4.setMaxWidth(100);
        colBeb5.setMinWidth(100);
        colBeb5.setMaxWidth(100);
        colBeb6.setMinWidth(100);
        colBeb6.setMaxWidth(100);


        Compra compra= new Compra(cafeteria.getCantidadCompras());

        //agregar de comidas
        SpinnerNumberModel modelSpinner = new SpinnerNumberModel(1, 1, 9, 1);
        cantidad.setModel(modelSpinner);

        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!comidas.getSelectionModel().isSelectionEmpty() && comidas.getValueAt(comidas.getSelectedRow(), 4).toString().equals("true")){
                    String nombre = comidas.getValueAt(comidas.getSelectedRow(), 0).toString();
                    int cant = (int) cantidad.getValue();
                    Iterator<Producto> itCom = cafeteria.iterarComida();
                    while (itCom.hasNext()){
                        Comida aux = (Comida) itCom.next();
                        if(aux.getNombre().equals(nombre) ){
                            aux.setCantidadEnCarrito(cant);
                            try{
                                compra.agregarAlCarrito(aux);
                                JOptionPane.showMessageDialog(null, nombre + " se agrego al carrito. Cantidad: "+cant);
                            }
                            catch (ProductoNoDisponibleException e1){
                                JOptionPane.showMessageDialog(null, e1.getMessage());
                            }

                        }

                    }
                }
            }
        });


        //agregar de infusiones
        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>();
        defaultComboBoxModel.addElement("");
        defaultComboBoxModel.addElement(Leche.ENTERA.name());
        defaultComboBoxModel.addElement(Leche.DESLACTOSADA.name());
        defaultComboBoxModel.addElement(Leche.ALMENDRA.name());
        defaultComboBoxModel.addElement(Leche.COCO.name());

        tipoDeLeche.setModel(defaultComboBoxModel);

        SpinnerNumberModel modelSpinner1 = new SpinnerNumberModel(1, 1, 9, 1);
        cantidad1.setModel(modelSpinner1);

        agregarAlCarritoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!infusiones.getSelectionModel().isSelectionEmpty() && infusiones.getValueAt(infusiones.getSelectedRow(), 5).toString().equals("true") && !tipoDeLeche.getSelectedItem().toString().isEmpty()){
                    String nombre = infusiones.getValueAt(infusiones.getSelectedRow(), 0).toString();
                    int cant = (int) cantidad1.getValue();
                    Iterator<Producto> itInf = cafeteria.iterarInfusiones();
                    while (itInf.hasNext()){
                        Infusion aux = (Infusion) itInf.next();
                        if(aux.getNombre().equals(nombre) ){
                            aux.setCantidadEnCarrito(cant);

                            if(tipoDeLeche.getSelectedItem().toString().equals(Leche.ENTERA.name())){
                                aux.setTipoDeLeche(Leche.ENTERA);
                            } else if (tipoDeLeche.getSelectedItem().toString().equals(Leche.DESLACTOSADA.name())) {
                                aux.setTipoDeLeche(Leche.DESLACTOSADA);
                            }else if (tipoDeLeche.getSelectedItem().toString().equals(Leche.ALMENDRA.name())){
                                aux.setTipoDeLeche(Leche.ALMENDRA);
                            }else {
                                aux.setTipoDeLeche(Leche.COCO);
                            }

                            try{
                                compra.agregarAlCarrito(aux);
                                JOptionPane.showMessageDialog(null, nombre + " se agrego al carrito. Cantidad: "+cant);
                            }
                            catch (ProductoNoDisponibleException e1){
                                JOptionPane.showMessageDialog(null, e1.getMessage());
                            }

                        }

                    }

                }
            }
        });


        //agregar de bebidas envasadas
        SpinnerNumberModel modelSpinner2 = new SpinnerNumberModel(1, 1, 9, 1);
        cantidad2.setModel(modelSpinner2);

        agregarAlCarritoButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!bebidas.getSelectionModel().isSelectionEmpty() && bebidas.getValueAt(bebidas.getSelectedRow(), 6).toString().equals("true")){
                    String nombre = bebidas.getValueAt(bebidas.getSelectedRow(), 0).toString();
                    int cant = (int) cantidad2.getValue();
                    Iterator<Producto> itEnv = cafeteria.iterarEnvasadas();
                    while (itEnv.hasNext()){
                        BebidaEnvasada aux = (BebidaEnvasada) itEnv.next();
                        if(aux.getNombre().equals(nombre) ){
                            aux.setCantidadEnCarrito(cant);
                            try{
                                compra.agregarAlCarrito(aux);
                                JOptionPane.showMessageDialog(null, nombre + " se agrego al carrito. Cantidad: "+cant);
                            }
                            catch (ProductoNoDisponibleException e1){
                                JOptionPane.showMessageDialog(null, e1.getMessage());
                            }

                        }

                    }


                }
            }
        });

        //ver carrito
        verCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazCarrito interfazCompra= new InterfazCarrito(cafeteria, compra);
            }
        });

        salirDelProgramaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog( null,"Está seguro que desea Salir");
                if(i==0){
                    cafeteria.cerrar();
                    dispose();
                }
            }
        });
    }

}
