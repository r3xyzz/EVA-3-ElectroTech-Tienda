/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electrotech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author r3xzz
 */
public class ElectroTech {

    public static Connection conexion = null;
    public static Statement sentencia;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectroTech", "root", "");
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // erm lo que hice aquí se hace después de hacer todo el tandeo de settear los programas y crear la tabla
    // y crear la DATABASE

    public static void desconectar() throws SQLException{
        conexion.close();
    }
}
//ethan
 