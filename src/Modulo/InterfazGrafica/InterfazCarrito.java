package Modulo.InterfazGrafica;

import Modulo.Cafeteria;
import Modulo.Excepciones.ProductoNoDisponibleException;
import Modulo.compras.Compra;
import Modulo.compras.MetodosDePago;
import Modulo.productos.Producto;
import Modulo.productos.bebidas.Infusion;
import Modulo.productos.bebidas.Leche;
import Modulo.productos.comidas.Comida;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class InterfazCarrito extends JFrame {

    private JTable carritoTabla;
    private JButton modificarCantidadButton;
    private JPanel panel;
    private JTable compraTabla;
    private JSpinner cantidad;
    private JComboBox comboBoxPago;
    private JButton volverButton;
    private JButton finalizarCompraButton;
    private DefaultTableModel modelCompra;
    private DefaultTableModel modelCarrito;

    public InterfazCarrito(Cafeteria cafeteria, Compra compra){

        //setLocationRelativeTo(null);
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        ArrayList<Producto> carrito= compra.getCarrito();

        modelCarrito = new DefaultTableModel();

        String[] colCarrito ={"Nombre", "Cantidad", "Precio x unidad", "Precio total"};

        String[][] listaCarrito = new String[carrito.size()][colCarrito.length];
        int i =0;
        while (i <carrito.size()){
            String[] productos = new String[colCarrito.length];
            productos[0] = carrito.get(i).getNombre();
            productos[1] = String.valueOf(carrito.get(i).getCantidadEnCarrito());
            productos[2] = new String("$"+ String.valueOf(carrito.get(i).getPrecio()));
            productos[3] = new String("$"+ String.valueOf(carrito.get(i).getPrecio() * carrito.get(i).getCantidadEnCarrito()));
            listaCarrito[i++] = productos;
        }

        modelCarrito.setDataVector(listaCarrito,colCarrito);

        carritoTabla.setModel(modelCarrito);

        TableColumnModel columnModelCarrito = carritoTabla.getColumnModel();
        TableColumn colCarrito0 = columnModelCarrito.getColumn(0);
        TableColumn colCarrito1 = columnModelCarrito.getColumn(1);
        TableColumn colCarrito2 = columnModelCarrito.getColumn(2);
        TableColumn colCarrito3 = columnModelCarrito.getColumn(3);

        colCarrito0.setMinWidth(150);
        colCarrito0.setMaxWidth(150);
        colCarrito1.setMinWidth(150);
        colCarrito1.setMaxWidth(150);
        colCarrito2.setMaxWidth(150);
        colCarrito2.setMinWidth(150);
        colCarrito3.setMaxWidth(150);
        colCarrito3.setMinWidth(150);


        modelCompra = new DefaultTableModel();

        String[] colCompra ={"Numero de ticket", "Fecha-Hora", "Metodo de pago", "Precio final"};

        String[][] listaCompra = new String[1][colCompra.length];

        String[] atributos = new String[colCompra.length];
        atributos[0] = String.valueOf(compra.getNumeroTicket());
        atributos[1] = String.valueOf(compra.getFechaHora());
        atributos[2] = String.valueOf(compra.getMetodoDePago());
        atributos[3] = new String("$"+ String.valueOf(compra.getPrecioTotal()));
        listaCompra[0] = atributos;

        modelCompra.setDataVector(listaCompra,colCompra);

        compraTabla.setModel(modelCompra);

        TableColumnModel columnModelCompra = compraTabla.getColumnModel();
        TableColumn colCompra0 = columnModelCompra.getColumn(0);
        TableColumn colCompra1 = columnModelCompra.getColumn(1);
        TableColumn colCompra2 = columnModelCompra.getColumn(2);
        TableColumn colCompra3 = columnModelCompra.getColumn(3);

        colCompra0.setMinWidth(150);
        colCompra0.setMaxWidth(150);
        colCompra1.setMinWidth(200);
        colCompra1.setMaxWidth(200);
        colCompra2.setMinWidth(150);
        colCompra2.setMaxWidth(150);
        colCompra3.setMinWidth(150);
        colCompra3.setMaxWidth(150);


        //modificar cantidad

        SpinnerNumberModel modelSpinner = new SpinnerNumberModel(1, 1, 9, 1);
        cantidad.setModel(modelSpinner);

        modificarCantidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!carritoTabla.getSelectionModel().isSelectionEmpty()){
                    String nombre = carritoTabla.getValueAt(carritoTabla.getSelectedRow(), 0).toString();
                    int cant = (int) cantidad.getValue();
                    int i=0;
                    while (i<carrito.size()){
                        if(carrito.get(i).getNombre().equals(nombre)){
                            compra.modificarCantidad(carrito.get(i), cant);
                            JOptionPane.showMessageDialog(null, "La cantidad de "+nombre +" fue modificada correctamente");
                        }
                    }

                }
            }
        });


        //finalizarCompra
        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>();
        defaultComboBoxModel.addElement("");
        defaultComboBoxModel.addElement(MetodosDePago.EFECTIVO.name());
        defaultComboBoxModel.addElement(MetodosDePago.DEBITO.name());
        defaultComboBoxModel.addElement(MetodosDePago.CREDITO.name());

        comboBoxPago.setModel(defaultComboBoxModel);


        finalizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!comboBoxPago.getSelectedItem().toString().isEmpty()){

                    if(comboBoxPago.getSelectedItem().toString().equals(MetodosDePago.EFECTIVO.name())){
                        cafeteria.finalizarCompra(compra, MetodosDePago.EFECTIVO);
                        JOptionPane.showMessageDialog(null, "Compra finalizada");
                    } else if (comboBoxPago.getSelectedItem().toString().equals(MetodosDePago.DEBITO.name())) {
                        cafeteria.finalizarCompra(compra, MetodosDePago.DEBITO);
                        JOptionPane.showMessageDialog(null, "Compra finalizada");
                    }else {
                        cafeteria.finalizarCompra(compra, MetodosDePago.CREDITO);
                        JOptionPane.showMessageDialog(null, "Compra finalizada");
                    }

                }
            }
        });



        //volver
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
