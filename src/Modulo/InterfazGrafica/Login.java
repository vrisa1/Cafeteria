package Modulo.InterfazGrafica;

import Modulo.Cafeteria;
import Modulo.Excepciones.ContraseñaIncorrectaException;
import Modulo.Excepciones.UsuarioNoExisteException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class Login extends JFrame{
    private JFormattedTextField nombreUsuario;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    private JPanel jpanel;
    private JButton crearUsusarioButton;
    private JButton salirButton;

    public Login(Cafeteria cafeteria) {




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

                    String usuario = nombreUsuario.getText();
                    String pas = new String(passwordField1.getPassword());
                    try {
                        int ingreso = cafeteria.login(usuario,pas);
                        if(ingreso==1){
                            setVisible(false);
                            InterfazAdmin interfazAdmin = new InterfazAdmin(cafeteria);
                        }else {
                            setVisible(false);
                            JOptionPane.showMessageDialog(null,ingreso);///acceso interfaz usuario
                        }
                    }catch (UsuarioNoExisteException | ContraseñaIncorrectaException ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }

                }
            }
        );



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
        crearUsusarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearUsuario crearUsuario = new CrearUsuario(cafeteria);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


}
