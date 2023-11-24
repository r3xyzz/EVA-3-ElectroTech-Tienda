/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import electrotech.ElectroTech;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    // Método para obtener un producto por su ID
    public static Product obtenerProductoPorID(String id) {
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Establecer conexión a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectroTech", "root", "");

            // Consulta SQL para obtener el producto por ID
            String query = "SELECT * FROM PRODUCT WHERE ID = ?";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer el valor del parámetro
            pst.setString(1, id);

            // Ejecutar la consulta
            rs = pst.executeQuery();

            // Verificar si se encontró el producto
            if (rs.next()) {
                // Crear un objeto Product con los datos obtenidos de la base de datos
                Product productoEncontrado = new Product();
                productoEncontrado.setId(rs.getInt("ID"));
                productoEncontrado.setNombre(rs.getString("Nombre"));
                productoEncontrado.setMarca(rs.getString("Marca"));
                productoEncontrado.setCategoria(rs.getString("Categoria"));
                productoEncontrado.setPrecio(rs.getInt("Precios"));
                productoEncontrado.setCantidadEnStock(rs.getInt("CantidadEnStock"));

                // Convertir la fecha de texto a Date
                String fechaTexto = rs.getString("FechaDeAdquisicion");
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date fecha = formatoFecha.parse(fechaTexto);
                    productoEncontrado.setFecha(fecha);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return productoEncontrado;
            } else {
                // No se encontró un producto con ese ID
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto por ID: " + e.getMessage());
            return null;
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
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

    // Método para actualizar un producto en la base de datos
    public void actualizarProducto() {
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            // Establecer conexión a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectroTech", "root", "");

            // Consulta SQL para actualizar el producto por ID
            String query = "UPDATE PRODUCT SET Nombre = ?, Marca = ?, Categoria = ?, Precios = ?, CantidadEnStock = ?, FechaDeAdquisicion = ? WHERE ID = ?";

            // Preparar la declaración
            pst = conexion.prepareStatement(query);

            // Establecer los valores de los parámetros
            pst.setString(1, this.nombre);
            pst.setString(2, this.marca);
            pst.setString(3, this.categoria);
            pst.setInt(4, this.precio);
            pst.setInt(5, this.cantidadEnStock);

            // Convertir la fecha a formato de texto
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaTexto = formatoFecha.format(this.fecha);
            pst.setString(6, fechaTexto);

            pst.setInt(7, this.id);

            // Ejecutar la consulta
            int filasAfectadas = pst.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Producto actualizado exitosamente");
            } else {
                System.out.println("No se pudo actualizar el producto");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
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
