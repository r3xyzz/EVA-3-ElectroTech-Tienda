/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import electrotech.ElectroTech;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
/**
 *
 * @author r3xzz
 * @author araceli
 */
public class Product {
    private String nombre, marca, categoria;
    private int id, precio, cantidadEnStock;
    private Date fecha;
    
    //const sin parametro

    public Product() {
    }
    
    //const con parametro

    public Product(String nombre, String marca, String categoria, int precio, int cantidadEnStock, Date fecha) {
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.fecha = fecha;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {    
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //getter y setter
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean validarNombre(String nombre) {
        try {
            String sql = "select count(*) as count from product where nombre = '"+nombre+"'";
            ElectroTech.conectar();
            ElectroTech.sentencia = ElectroTech.conexion.prepareStatement(sql);
            ResultSet res = ElectroTech.sentencia.executeQuery(sql);
            
            res.next();
            int count = res.getInt("count");

            return count > 0;
        } catch (Exception e) {
            System.out.println("Error");  
            return false;
        }
    }
    
    // metodo custom agregar
    // Método custom para agregar un producto a la base de datos
    public void agregarProducto() {
        try{
                       
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = formato.format(fecha);
        
            String sql = "INSERT INTO PRODUCT (Nombre, Marca, Categoria, Precios, CantidadEnStock, FechaDeAdquisicion) VALUES ('"+nombre+"', '"+marca+"', '"+categoria+"',"+precio+", "+cantidadEnStock+",'"+fechaFormateada+"')";

            ElectroTech.conectar();
            ElectroTech.sentencia = ElectroTech.conexion.prepareStatement(sql);
            ElectroTech.sentencia.execute(sql);
            System.out.println("Datos Almacenados");
            ElectroTech.desconectar();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error al agregar PRODUCTO");
        }
    }

    // Método custom para eliminar un producto de la base de datos
    public boolean eliminarProducto(String nombre) {
    try {
        // Establecer conexión a la base de datos
        //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectroTech", "root", "");
        ElectroTech.conectar();

        // Consulta SQL para eliminar el producto por nombre
        String query = "DELETE FROM PRODUCT WHERE ID = ?";

        // Preparar la declaración
        //pst = conexion.prepareStatement(query);
        ElectroTech.sentencia = ElectroTech.conexion.prepareStatement(query);
        

        // Establecer el valor del parámetro
        //pst.setString(1, nombre);
        ElectroTech.sentencia.setString(1, nombre);

        // Ejecutar la consulta
        //int filasAfectadas = pst.executeUpdate();
        int filasAfectadas = ElectroTech.sentencia.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Producto eliminado exitosamente");
            return true;
        } else {
            System.out.println("No se encontró un producto con este ID");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Error al eliminar el producto: " + e.getMessage());
        return false;
    } finally {
        // Cerrar recursos
        try {
            if (ElectroTech.sentencia != null) {
                ElectroTech.sentencia.close();
            }
            if (ElectroTech.conexion != null) {
                ElectroTech.conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar los recursos: " + ex.getMessage());
        }
    }
}

}
