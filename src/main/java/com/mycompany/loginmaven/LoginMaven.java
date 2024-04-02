package com.mycompany.loginmaven;
import forms.*;
import classes.MySQLConnection;
import javax.swing.JOptionPane;

public class LoginMaven {

    public static void main(String[] args) {
        if(MySQLConnection.connectDB()) {
            Login login = new Login();
            login.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Fallo en la conexión con la base de datos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}