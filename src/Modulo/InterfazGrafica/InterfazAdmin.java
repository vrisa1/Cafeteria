package Modulo.InterfazGrafica;

import Modulo.usuarios.Usuario;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfazAdmin extends JFrame{
    private JPanel panel1;
    private JSpinner spinner1;
    private JButton agregarAlCarritoButton;
    private JTable table1;
    private JButton verCarritoButton;
    private JList list1;

    private DefaultListModel<String> model;

    private DefaultTableModel defaultTableModel;
    public InterfazAdmin() {

        final ArrayList<Usuario>[] aa = new ArrayList[]{new ArrayList<>()};
            aa[0].add(new Usuario("aa","1234","mail"));
            aa[0].add(new Usuario("bb","1234","mail"));
            aa[0].add(new Usuario("cc","1234","mail"));

            //String[] productos = {"café1","café2","café3","café4","café5"};
        /*
            model = new DefaultListModel<>();
            model.addElement("café1");
            model.addElement("café2");
            model.addElement("café3");
            model.addElement("café4");
            model.addAll(aa);
            //list1.setModel(model);
*/
            String[] col ={"Productos","Precio"};

            String[][] data = new String[aa[0].size()][col.length];
            int i = 0;
            for (Usuario users : aa[0]) {
            String[] userdata = new String[col.length];
            userdata[0] = users.getNombreDeUsuario();
            userdata[1] = users.getContraseña();

            data[i++] = userdata;
        }

            defaultTableModel = new DefaultTableModel();
            defaultTableModel.setDataVector(data,col);

            //defaultTableModel.setColumnIdentifiers(col);
            /*
            JSpinner spinner = new JSpinner();
            spinner.setValue(0);
            TableColumnModel model = table1.getColumnModel();
            TableColumn seleccion = model.getColumn(0);
            seleccion.setCellEditor((TableCellEditor) (Default)spinner.getEditor());
            */
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
        */

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







            setLocationRelativeTo(null);
            setContentPane(panel1);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            pack();
            setVisible(true);



    }



}
