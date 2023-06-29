package Modulo.InterfazGrafica;

import Modulo.Cafeteria;
import Modulo.Excepciones.ContraseñaIncorrectaException;
import Modulo.Excepciones.UsuarioNoExisteException;
import Modulo.Excepciones.UsuarioYaExisteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearUsuario extends JFrame{
    private JTextField nombreUsuario;
    private JTextField mail;
    private JPasswordField passwordField1;
    private JButton cancelarButton;
    private JButton confirmarButton;
    private JPanel Jpanel;

    public CrearUsuario(Cafeteria cafeteria) {

    setLocationRelativeTo(null);
    setContentPane(Jpanel);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    pack();
    setVisible(true);
    confirmarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(nombreUsuario.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Ingrese Nombre de Ususario");
            } else if (mail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Ingrese mail");
            } else if (passwordField1.getPassword().length ==0) {
                JOptionPane.showMessageDialog(null,"Ingrese Contraseña");
            }else{
                try {
                    cafeteria.CrearUsuario(nombreUsuario.getText(),new String(passwordField1.getPassword()), mail.getText());
                    dispose();
                }catch (UsuarioYaExisteException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        }
    });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
