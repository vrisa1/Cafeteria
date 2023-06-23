package Modulo.InterfazGrafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JFormattedTextField formattedTextField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;

    public Login() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        pack();
        setVisible(true);
    }
}
