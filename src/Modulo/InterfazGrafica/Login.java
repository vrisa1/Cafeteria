package Modulo.InterfazGrafica;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Objects;

public class Login extends JFrame{
    private JFormattedTextField nombreUsuario;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    private JPanel jpanel;
    private JButton crearUsusarioButton;

    public Login() {




        crearUsusarioButton.setOpaque(false);
        crearUsusarioButton.setContentAreaFilled(false);
        crearUsusarioButton.setBorderPainted(false);


        setLocationRelativeTo(null);
        setContentPane(jpanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String usuario = (String) nombreUsuario.getValue();
                    String pas = Arrays.toString(passwordField1.getPassword());
                    ////Como se llama al método de cafetería?
                }
            }
        );

        nombreUsuario.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                ingresarButton.setEnabled(true);
            }
        });

        passwordField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            public void changed () {
                if(passwordField1.getPassword().length==0){
                    ingresarButton.setEnabled(false);
                }else{
                    ingresarButton.setEnabled(true);
                }

            }
        });

        nombreUsuario.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            public void changed () {
                if(nombreUsuario.getText().equals("")){
                    ingresarButton.setEnabled(false);
                }else{
                    ingresarButton.setEnabled(true);
                }

            }

        });
    }


}
