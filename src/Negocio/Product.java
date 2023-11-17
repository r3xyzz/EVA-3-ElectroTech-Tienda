/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author r3xzz
 * @author araceli
 */
public class Product {
    private String nombre, marca, categoria;
    private int precio, cantidadEnStock;
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

    //getter y setter
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // metodo custom agregar
    // Método custom para agregar un producto a la base de datos
    public void agregarProducto() {
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            // Establecer conexión a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectroTech", "root", "");

            // Consulta SQL para insertar un nuevo producto
            String query = "INSERT INTO PRODUCT (Nombre, Marca, Categoria, Precio, Cantidad_Stock, Fecha_Adquisicion) VALUES (?, ?, ?, ?, ?,?)";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer los valores de los parámetros
            pst.setString(1, this.nombre);
            pst.setString(2, this.marca);
            pst.setString(3,this.categoria);
            pst.setInt(4, this.precio);
            pst.setInt(5, this.cantidadEnStock);
            pst.setDate(6, (java.sql.Date) this.fecha);

            // Ejecutar la consulta
            pst.executeUpdate();

            System.out.println("Producto agregado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar los recursos: " + ex.getMessage());
            }
        }
    }
}


