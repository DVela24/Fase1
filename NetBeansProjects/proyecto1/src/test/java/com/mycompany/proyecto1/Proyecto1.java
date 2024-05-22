

package com.mycompany.proyecto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proyecto1 {
    
    public static void main(String[] args) {
    
            String url = "jdbc:mysql://localhost:3306/ejemplo1";
            String usuario = "root";
            String password = "";
            String driver = "com.mysql,cj.jdbc.Driver";
            Connection conexion = null;
            Statement statement = null;
            ResultSet rs = null;
            
            try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Proyecto1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar los recursos en un bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Proyecto1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

