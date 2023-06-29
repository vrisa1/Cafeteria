package Modulo.InterfazGrafica;

import Modulo.Cafeteria;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.BebidaEnvasada;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.comidas.Comida;
import Modulo.productos.comidas.Usuario;

import javax.swing.*;
import javax.swing.table.*;
import java.util.Iterator;
import java.util.Map;

public class InterfazAdmin extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JSpinner spinner1;
    private JButton agregarAlCarritoButton;
    private JTable table1;
    private JScrollPane Comidas;
    private JTabbedPane tabbedPane2;
    private JTable table2;
    private JTable table3;
    private JTable tablaUsuarios;

    private DefaultTableModel modelUsuarios;
    private DefaultTableModel modelComidas;

    private DefaultTableModel modelInfusiones;
    private DefaultTableModel modelEnvasadas;

    private DefaultTableModel defaultTableModel;
    public InterfazAdmin(Cafeteria cafeteria) {

        //setLocationRelativeTo(null);
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        /*
        modelUsuarios = new DefaultTableModel();

        String[] colUsuarios ={"Nombre de Usuario","Mail","Administrador"};

        Iterator<Map.Entry<String, Modulo.usuarios.Usuario>> itUsuarios = cafeteria.iterarUsuarios();
        String[][] listaUsuarios = new String[cafeteria.cantUsuarios()][colUsuarios.length];
        int u =0;
        while (itUsuarios.hasNext()){
            String[] usuarios = new String[colUsuarios.length];
            Usuario aux = (Usuario) itUsuarios.next();
            usuarios[0] = aux.getNombre();
            usuarios[1] = aux.getDescripcion();
            usuarios[2] = new String("$"+ String.valueOf(aux.getPrecio()));
            usuarios[3] = String.valueOf(aux.isParaCompartir());
            usuarios[4] = String.valueOf(aux.isDisponible());
            listaUsuarios[u++] = usuarios;
        }

        modelUsuarios.setDataVector(listaUsuarios,colUsuarios);


        tablaUsuarios.setModel(modelUsuarios);

        */






           modelComidas = new DefaultTableModel();

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

        modelInfusiones = new DefaultTableModel();
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
        table2.setModel(modelInfusiones);


        modelEnvasadas = new DefaultTableModel();

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
        table3.setModel(modelEnvasadas);


            //defaultTableModel = new DefaultTableModel();
            //defaultTableModel.setDataVector(data,col);

            //defaultTableModel.setColumnIdentifiers(col);
        /*
            JSpinner spinner = new JSpinner();
            spinner.setValue(0);
            TableColumnModel model = table1.getColumnModel();
            TableColumn seleccion = model.getColumn(0);
            //seleccion.setCellEditor((TableCellEditor) (Default)spinner.getEditor());

            table1.setModel(defaultTableModel);
            //defaultTableModel.addRow(aa.toArray());
            spinner1.setVisible(false);


            /*
            table1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {


                if(!event.getValueIsAdjusting()){

                    if(event.getLastIndex()==-1){
                        agregarAlCarritoButton.setEnabled(false);
                    }else{
                        spinner1.setVisible(true);
                        if ((int)spinner1.getValue()!=0){
                            String producto = table1.getValueAt(table1.getSelectedRow(), 0).toString();
                            //String producto = table1.getValueAt(event.getLastIndex(),0).toString();


                            agregarAlCarritoButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int cantidad = (int) spinner1.getValue();
                                    spinner1.setValue((int)0);
                                    JOptionPane.showMessageDialog(null, producto +" "+cantidad);
                                }
                            });
                        }

                    }

                }

            }
        });


        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAlCarritoButton.setEnabled(false);
                String producto = table1.getValueAt(table1.getSelectedRow(), 0).toString();
                if(!table1.getSelectionModel().isSelectionEmpty()){
                    spinner1.setVisible(true);
                    int cantidad = (int) spinner1.getValue();
                    if ((int)spinner1.getValue()!=0){
                        agregarAlCarritoButton.setEnabled(true);
                    JOptionPane.showMessageDialog(null, producto +" "+cantidad);
                }
            }
                }
        });





          */







    }



}
