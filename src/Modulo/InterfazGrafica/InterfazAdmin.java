package Modulo.InterfazGrafica;

import Modulo.Cafeteria;
import Modulo.compras.Compra;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.bebidas.Leche;
import Modulo.productos.comidas.Comida;
import Modulo.usuarios.Usuario;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Double.parseDouble;

public class InterfazAdmin extends JFrame{
    private JPanel panel1;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTable tablaUsuarios;
    private JComboBox<String> comboBoxTipoProducto;
    private JTextField agregarPNombre;
    private JTextField agregarPPrecio;
    private JCheckBox disponibleCheckBox;
    private JTextField agregarPDescripción;
    private JButton confirmarButton;
    private JTextField agregarEnvasadaLinea;
    private JComboBox<String> agregarEnvasadaGas;
    private JTextField agregarEnvasadaTamaño;
    private JPanel panelABebida;
    private JCheckBox checkBoxCompartir;
    private JPanel panelAComida;
    private JTextField agregarITemp;
    private JComboBox<String> comboBoxtipoLeche;
    private JPanel panelAInfusion;
    private JTextField agregarITamaño;
    private JButton eliminarComidaButton;
    private JButton eliminarEnvasadasButton;
    private JButton eliminarInfusionesButton;
    private JTable tablaCompras;
    private JButton salirDelProgramaButton;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane1;
    private JPanel panelAProducto;
    private JButton modificarPrecioComidaButton;
    private JButton modificarDisponibilidadComidaButton;
    private JButton modificarDispinibilidadEnvasadas;
    private JButton modificarPrecioEnvasadas;
    private JButton modificarDisponibilidadInfusiones;
    private JButton modificarPrecioInfusiones;

    public InterfazAdmin(Cafeteria cafeteria) {

        setContentPane(panel1);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        pack();
        setVisible(true);

        DefaultTableModel modelUsuarios = new DefaultTableModel();

        String[] colUsuarios ={"Nombre de Usuario","Mail","Administrador"};

        Iterator<Map.Entry<String, Modulo.usuarios.Usuario>> itUsuarios = cafeteria.iterarUsuarios();
        String[][] listaUsuarios = new String[cafeteria.cantUsuarios()][colUsuarios.length];
        int u =0;
        while (itUsuarios.hasNext()){
            String[] usuarios = new String[colUsuarios.length];
            Usuario aux = (Usuario) itUsuarios.next().getValue();
            usuarios[0] = aux.getNombreDeUsuario();
            usuarios[1] = aux.getMail();
            usuarios[2] = String.valueOf(aux.isAdministrador());
            listaUsuarios[u++] = usuarios;
        }

        modelUsuarios.setDataVector(listaUsuarios,colUsuarios);
        tablaUsuarios.setDefaultEditor(Object.class, null);

        tablaUsuarios.setModel(modelUsuarios);


        DefaultTableModel modelComidas = new DefaultTableModel();

            String[] colComidas ={"Nombre","Descripcion","Precio","Compartir","Disponible"};

            Iterator<Producto> itComida = cafeteria.iterarComida();
            String[][] listaComidas = new String[cafeteria.cantComidas()][colComidas.length];
            int i =0;
            while (itComida.hasNext()){
                String[] comidas = new String[colComidas.length];
                Comida aux = (Comida) itComida.next();
                comidas[0] = aux.getNombre();
                comidas[1] = aux.getDescripcion();
                comidas[2] = new String("$"+ String.valueOf(aux.getPrecio()));
                comidas[3] = String.valueOf(aux.isParaCompartir());
                comidas[4] = String.valueOf(aux.isDisponible());
                listaComidas[i++] = comidas;
            }

            modelComidas.setDataVector(listaComidas,colComidas);
            table1.setDefaultEditor(Object.class, null);

            table1.setModel(modelComidas);

        TableColumnModel columnModel = table1.getColumnModel();
        TableColumn col0 = columnModel.getColumn(0);
        TableColumn col1 = columnModel.getColumn(1);
        TableColumn col2 = columnModel.getColumn(2);
        TableColumn col3 = columnModel.getColumn(3);
        TableColumn col4 = columnModel.getColumn(4);


        col0.setMinWidth(150);
        col0.setMaxWidth(150);
        col1.setMinWidth(500);
        col1.setMaxWidth(500);
        col2.setMaxWidth(80);
        col2.setMinWidth(80);
        col3.setMaxWidth(80);
        col3.setMinWidth(80);
        col4.setMaxWidth(80);
        col4.setMinWidth(80);

        DefaultTableModel modelInfusiones = new DefaultTableModel();
        String[] colInfusiones ={"Nombre","Descripcion","Precio","Temperatura","Disponible"};

        Iterator<Producto> itInfusiones = cafeteria.iterarInfusiones();
        String[][] listaInfusiones = new String[cafeteria.cantInfusiones()][colInfusiones.length];
        int j =0;
        while (itInfusiones.hasNext()){
            String[] infusiones = new String[colInfusiones.length];
            Infusion aux = (Infusion) itInfusiones.next();
            infusiones[0] = aux.getNombre();
            infusiones[1] = aux.getDescripcion();
            infusiones[2] = "$" + String.valueOf(aux.getPrecio());
            infusiones[3] = aux.getTemperatura();
            infusiones[4] = String.valueOf(aux.isDisponible());
            listaInfusiones[j++] = infusiones;
        }

        modelInfusiones.setDataVector(listaInfusiones,colInfusiones);
        table2.setDefaultEditor(Object.class, null);
        table2.setModel(modelInfusiones);


        DefaultTableModel modelEnvasadas = new DefaultTableModel();

        String[] colEnvasadas ={"Nombre","Descripcion","Precio","Linea","Gasificada","Tamaño","Disponible"};

        Iterator<Producto> itEnvasadas = cafeteria.iterarEnvasadas();
        String[][] listaEnvasadas = new String[cafeteria.cantEnvasadas()][colEnvasadas.length];
        int k =0;
        while (itEnvasadas.hasNext()){
            String[] envasadas = new String[colEnvasadas.length];
            BebidaEnvasada aux = (BebidaEnvasada) itEnvasadas.next();
            envasadas[0] = aux.getNombre();
            envasadas[1] = aux.getDescripcion();
            envasadas[2] = new String("$"+ String.valueOf(aux.getPrecio()));
            envasadas[3] = aux.getLinea();
            envasadas[4] = String.valueOf(aux.isGas());
            envasadas[5] = String.valueOf(aux.getTamaño()) + "cc";
            envasadas[6] = String.valueOf(aux.isDisponible());
            listaEnvasadas[k++] = envasadas;
        }

        modelEnvasadas.setDataVector(listaEnvasadas,colEnvasadas);
        table3.setDefaultEditor(Object.class, null);
        table3.setModel(modelEnvasadas);


        DefaultTableModel modelCompra = new DefaultTableModel();

        String[] colCompra ={"Numero de ticket", "Fecha-Hora", "Metodo de pago", "Precio final"};
        Iterator<Map.Entry<Integer,Compra>> itCompras = cafeteria.iterarCompras();
        int iCompras=0;
        String[][] listaCompra = new String[cafeteria.getCantidadCompras()][colCompra.length];
        while (itCompras.hasNext()){
            Compra compra = itCompras.next().getValue();
            String[] atributos = new String[colCompra.length];
            atributos[0] = String.valueOf(compra.getNumeroTicket());
            atributos[1] = String.valueOf(compra.getFechaHora());
            atributos[2] = String.valueOf(compra.getMetodoDePago());
            atributos[3] = "$" + String.valueOf(compra.getPrecioTotal());
            listaCompra[iCompras++] = atributos;
        }

        modelCompra.setDataVector(listaCompra,colCompra);

        tablaCompras.setModel(modelCompra);
        tablaCompras.setDefaultEditor(Object.class, null);




        panelAComida.setVisible(false);
        panelABebida.setVisible(false);
        panelAInfusion.setVisible(false);

        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>();
        defaultComboBoxModel.addElement("");
        defaultComboBoxModel.addElement("Bebida Envasada");
        defaultComboBoxModel.addElement("Infusion");
        defaultComboBoxModel.addElement("Comida");

        comboBoxTipoProducto.setModel(defaultComboBoxModel);


        DefaultComboBoxModel<String> defaultComboBoxModel1 = new DefaultComboBoxModel<>();

        defaultComboBoxModel1.addElement("");
        defaultComboBoxModel1.addElement("Con Gas");
        defaultComboBoxModel1.addElement("Sin Gas");

        agregarEnvasadaGas.setModel(defaultComboBoxModel1);


        comboBoxTipoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxTipoProducto.getSelectedItem().toString().equals("Bebida Envasada")){
                    panelABebida.setVisible(true);
                    panelAComida.setVisible(false);
                    panelAInfusion.setVisible(false);
                } else if (comboBoxTipoProducto.getSelectedItem().toString().equals("Comida")) {
                    panelAComida.setVisible(true);
                    panelABebida.setVisible(false);
                    panelAInfusion.setVisible(false);
                }else if (comboBoxTipoProducto.getSelectedItem().toString().equals("Infusion")){
                    panelAInfusion.setVisible(true);
                    panelAComida.setVisible(false);
                    panelABebida.setVisible(false);
                }else {
                    panelAComida.setVisible(false);
                    panelABebida.setVisible(false);
                    panelAInfusion.setVisible(false);
                }
            }
        });

        DefaultComboBoxModel<String> defaultComboBoxModel2 = new DefaultComboBoxModel<>();

        defaultComboBoxModel2.addElement("");
        defaultComboBoxModel2.addElement(Leche.ENTERA.name());
        defaultComboBoxModel2.addElement(Leche.DESLACTOSADA.name());
        defaultComboBoxModel2.addElement(Leche.ALMENDRA.name());
        defaultComboBoxModel2.addElement(Leche.COCO.name());

        comboBoxtipoLeche.setModel(defaultComboBoxModel2);
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!agregarPNombre.getText().isEmpty() && !agregarPDescripción.getText().isEmpty() && !agregarPPrecio.getText().isEmpty() && !comboBoxTipoProducto.getSelectedItem().toString().isEmpty()){
                    Producto nueva=null;
                    String nombre = agregarPNombre.getText();
                    double precio = parseDouble(agregarPPrecio.getText());
                    boolean disponible = disponibleCheckBox.isSelected();
                    String descripción = agregarPDescripción.getText();

                    if(comboBoxTipoProducto.getSelectedItem().toString().equals("Bebida Envasada") && !agregarEnvasadaTamaño.getText().isEmpty() && !agregarEnvasadaGas.getSelectedItem().toString().isEmpty() && !agregarEnvasadaLinea.getText().isEmpty()){
                            nueva = new BebidaEnvasada(nombre,precio,disponible,descripción, parseDouble(agregarEnvasadaTamaño.getText()),agregarEnvasadaGas.getSelectedItem().equals("Con Gas"),agregarEnvasadaLinea.getText());
                    }else if (comboBoxTipoProducto.getSelectedItem().toString().equals("Comida")) {
                        nueva = new Comida(nombre,precio,disponible,descripción,checkBoxCompartir.isSelected());
                    }else if (!agregarITamaño.getText().isEmpty() && !agregarITemp.getText().isEmpty() && !comboBoxtipoLeche.getSelectedItem().toString().isEmpty()){
                        nueva = new Infusion(nombre,precio,disponible,descripción,parseDouble(agregarITamaño.getText()),agregarITemp.getText(), Leche.valueOf(comboBoxtipoLeche.getSelectedItem().toString()));
                    }

                    if(nueva!=null){
                        cafeteria.agregarProducto(nueva);
                        borrarDatos();
                        JOptionPane.showMessageDialog(null,nueva.getNombre()+" Agregado Exitosamente");
                    }

                }
            }

            public void borrarDatos(){
                agregarPNombre.setText("");
                agregarPPrecio.setText("");
                agregarPDescripción.setText("");
                comboBoxTipoProducto.setSelectedIndex(0);

                agregarEnvasadaTamaño.setText("");
                agregarEnvasadaGas.setSelectedIndex(0);
                agregarEnvasadaLinea.setText("");

                agregarITamaño.setText("");
                agregarITemp.setText("");

            }

        });
        eliminarComidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getValueAt(table1.getSelectedRow(),0)!=null){
                   int i = JOptionPane.showConfirmDialog( null,"Está seguro que desea Eliminar");
                   if(i==0){
                       JOptionPane.showMessageDialog(null,"ELiminado Éxito");
                       Comida aux = new Comida();
                       aux.setNombre(table1.getValueAt(table1.getSelectedRow(),0).toString());
                       cafeteria.eliminarProducto(aux);
                   }
                }
            }
        });
        eliminarEnvasadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table3.getValueAt(table3.getSelectedRow(),0)!=null){
                    int i = JOptionPane.showConfirmDialog( null,"Está seguro que desea Eliminar");
                    if(i==0){
                        JOptionPane.showMessageDialog(null,"ELiminado Éxito");
                        BebidaEnvasada aux = new BebidaEnvasada();
                        aux.setNombre(table3.getValueAt(table3.getSelectedRow(),0).toString());
                        cafeteria.eliminarProducto(aux);
                    }
                }
            }
        });
        eliminarInfusionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table2.getValueAt(table2.getSelectedRow(),0)!=null){
                    int i = JOptionPane.showConfirmDialog( null,"Está seguro que desea Eliminar");
                    if(i==0){
                        JOptionPane.showMessageDialog(null,"ELiminado Éxito");
                        Infusion aux = new Infusion();
                        aux.setNombre(table2.getValueAt(table2.getSelectedRow(),0).toString());
                        cafeteria.eliminarProducto(aux);
                    }
                }
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

        modificarDisponibilidadComidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!table1.getSelectionModel().isSelectionEmpty()){
                    String nombre = table1.getValueAt(table1.getSelectedRow(), 0).toString();
                    Iterator<Producto> itCom = cafeteria.iterarComida();
                    while (itCom.hasNext()){
                        Comida aux = (Comida) itCom.next();
                        if(aux.getNombre().equals(nombre) ){
                            if(aux.isDisponible()){
                                JOptionPane.showMessageDialog(null,nombre + " Ahora no está disponible");
                                aux.setDisponible(false);
                            }else{
                                JOptionPane.showMessageDialog(null,nombre + " Ahora está disponible");
                                aux.setDisponible(true);
                            }
                        }
                    }
            }
                }

        });


        modificarDispinibilidadEnvasadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!table3.getSelectionModel().isSelectionEmpty()) {
                    String nombre = table3.getValueAt(table3.getSelectedRow(), 0).toString();
                    Iterator<Producto> itCom = cafeteria.iterarEnvasadas();
                    while (itCom.hasNext()){
                        BebidaEnvasada aux = (BebidaEnvasada) itCom.next();
                        if(aux.getNombre().equals(nombre) ){
                            if(aux.isDisponible()){
                                JOptionPane.showMessageDialog(null,nombre + " Ahora no está disponible");
                                aux.setDisponible(false);
                            }else{
                                JOptionPane.showMessageDialog(null,nombre + " Ahora está disponible");
                                aux.setDisponible(true);
                            }
                        }
                    }
                }
            }
        });
        modificarDisponibilidadInfusiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !table2.getSelectionModel().isSelectionEmpty()){
                    String nombre = table2.getValueAt(table2.getSelectedRow(), 0).toString();
                    Iterator<Producto> itCom = cafeteria.iterarInfusiones();
                    while (itCom.hasNext()){
                        Infusion aux = (Infusion) itCom.next();
                        if(aux.getNombre().equals(nombre) ){
                            if(aux.isDisponible()){
                                JOptionPane.showMessageDialog(null,nombre + " Ahora no está disponible");
                                aux.setDisponible(false);
                            }else{
                                JOptionPane.showMessageDialog(null,nombre + " Ahora está disponible");
                                aux.setDisponible(true);
                            }
                        }
                    }
                    }
                }
                });
        modificarPrecioComidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!table1.getSelectionModel().isSelectionEmpty()){
                    String nombre = table1.getValueAt(table1.getSelectedRow(), 0).toString();
                    Iterator<Producto> itCom = cafeteria.iterarComida();
                    while (itCom.hasNext()){
                        Comida aux = (Comida) itCom.next();
                        if(aux.getNombre().equals(nombre) ){
                             double precio = parseDouble(JOptionPane.showInputDialog("Ingrese nuevo Precio"));
                             aux.setPrecio(precio);
                             JOptionPane.showMessageDialog(null,nombre + " Ahora cuesta: "+precio);
                            }
                        }
                    }
                }

        });
        modificarPrecioEnvasadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!table3.getSelectionModel().isSelectionEmpty()){
                    String nombre = table3.getValueAt(table3.getSelectedRow(), 0).toString();
                    Iterator<Producto> itCom = cafeteria.iterarEnvasadas();
                    while (itCom.hasNext()){
                        BebidaEnvasada aux = (BebidaEnvasada) itCom.next();
                        if(aux.getNombre().equals(nombre) ){
                            double precio = parseDouble(JOptionPane.showInputDialog("Ingrese nuevo Precio"));
                            aux.setPrecio(precio);
                            JOptionPane.showMessageDialog(null,nombre + " Ahora cuesta: "+precio);
                        }
                    }
                }
            }

        });

    }



}
