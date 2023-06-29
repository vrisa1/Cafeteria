package Modulo.InterfazGrafica;

import Modulo.Cafeteria;
import Modulo.productos.Producto;
import Modulo.productos.comidas.Comida;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.util.Iterator;

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

    private DefaultTableModel model;

    private DefaultTableModel defaultTableModel;
    public InterfazAdmin(Cafeteria cafeteria) {

        //setLocationRelativeTo(null);
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

           model = new DefaultTableModel();

            String[] col ={"Nombre","Descripcion","Precio","Compartir","Disponible"};

            Iterator<Producto> itComida = cafeteria.iterarComida();
            String[][] listaComidas = new String[cafeteria.cantBebidas()][col.length];
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

            model.setDataVector(listaComidas,col);


            table1.setModel(model);

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
