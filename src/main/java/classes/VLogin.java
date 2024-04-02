package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.HeadlessException;
import java.sql.SQLException;

public class VLogin {
    public static boolean validateUser(JTextField user, JPasswordField password) {
        try {
            if(MySQLConnection.connectDB()){
                Connection conecction = MySQLConnection.getConnection();
                String query = """
                               select * from users where username=? 
                               and password_usr=?;
                               """;
                PreparedStatement ps = conecction.prepareStatement(query);
                ps.setString(1, user.getText());
                ps.setString(2, String.valueOf(
                        password.getPassword()));
                ResultSet rs = ps.executeQuery();
                return rs.next();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Error al conectarse con la base de datos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return false;
            }
        } catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al tratar de iniciar sesión\n" + e,
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
}