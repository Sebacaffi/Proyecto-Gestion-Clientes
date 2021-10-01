package controlador;

import bd.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;

/**
 * @author G. Gaggero - F. Beltrami - S. Caffi - A. Maltrain
 * @version 10/12/2020
 */

// Hereda los atributos y métodos de la clase Conexión
public class Registro extends Conexion {
    
    private static PreparedStatement ps;
    private static ResultSet res;
    
    public static boolean eliminarCliente(Cliente cli) {
        try {
            conn = conectar();

            String query = "DELETE FROM cliente WHERE rut=?";

            ps = conn.prepareStatement(query);
            ps.setString(1, cli.getRut());
            ps.executeUpdate();
            ps.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente" + e.getMessage());
            return false;
        } finally {
            desconectar();
            System.out.println("Se ha cerrado la conexión");
        }
    }
    
    public static boolean modificarCliente(Cliente cli) {
        try {
            conn = conectar();

            String query = "UPDATE cliente SET rut=?,nombre=?,apaterno=?,amaterno=?,genero=?,telefono=?,email=?,direccion=?,id_comuna=(SELECT id_comuna FROM comuna WHERE nombre_comuna=?),id_estado=(SELECT id_estado FROM estado_civil WHERE nombre_estado = ?) WHERE rut=?";

            ps = conn.prepareStatement(query);

            ps.setString(1, cli.getRut());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getApaterno());
            ps.setString(4, cli.getAmaterno());
            ps.setString(5, cli.getGenero());
            ps.setInt(6, cli.getTelefono());
            ps.setString(7, cli.getEmail());
            ps.setString(8, cli.getDireccion());
            ps.setString(9, cli.getComuna());
            ps.setString(10, cli.getEstadoCivil());
            ps.setString(11, cli.getRut());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar los datos" + e.getMessage());
            return false;
        } finally {
            desconectar();
            System.out.println("Se ha cerrado la conexión");
        }
    }
    
    public static boolean buscarCliente(Cliente cli) {
        try {
            conn = conectar();

            String query = "SELECT * FROM cliente WHERE rut = ?";

            ps = conn.prepareStatement(query);
            ps.setString(1, cli.getRut());
            res = ps.executeQuery();
            
            if (res.next()) {
                cli.setNombre(res.getString("nombre"));
                cli.setApaterno(res.getString("apaterno"));
                cli.setAmaterno(res.getString("amaterno"));
                cli.setGenero(res.getString("genero"));
                cli.setTelefono(res.getInt("telefono"));
                cli.setEmail(res.getString("email"));
                cli.setDireccion(res.getString("direccion"));
                cli.setComuna(res.getString("id_comuna"));
                cli.setEstadoCivil(res.getString("id_estado"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente" + e.getMessage());
            return false;
        } finally {
            desconectar();
            System.out.println("Se ha cerrado la conexión");
        }
    }
    
    public static boolean agregarCliente(Cliente cli) {
        try {
            conn = conectar();
            
            String query = "INSERT INTO cliente(rut,nombre,apaterno,amaterno,genero,telefono,email,direccion,id_comuna,id_estado) VALUES (?,?,?,?,?,?,?,?,(SELECT id_comuna FROM comuna WHERE nombre_comuna = ?),(SELECT id_estado FROM estado_civil WHERE nombre_estado = ?))";
            
            ps = conn.prepareStatement(query);
            
            ps.setString(1, cli.getRut());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getApaterno());
            ps.setString(4, cli.getAmaterno());
            ps.setString(5, cli.getGenero());
            ps.setInt(6, cli.getTelefono());
            ps.setString(7, cli.getEmail());
            ps.setString(8, cli.getDireccion());
            ps.setString(9, cli.getComuna());
            ps.setString(10, cli.getEstadoCivil());
            
            ps.executeUpdate();
            ps.close();
            desconectar();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL" + e.getMessage());
            return false;
        }
    }
}
