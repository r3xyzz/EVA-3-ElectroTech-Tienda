/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electrotech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author r3xzz
 */
public class ElectroTech {

    public static Connection conexion;
    public static PreparedStatement sentencia;

    public static void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // com.mysql.cj.jdbc.Driver
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectroTech", "root", "");
            if (conexion != null){
                System.out.println("Conexión establecida con exito");
            }      
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            //System.out.println(e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("e");
        }
    }

    public static void desconectar() throws SQLException{
        conexion.close();
    }
}
//ethan
 