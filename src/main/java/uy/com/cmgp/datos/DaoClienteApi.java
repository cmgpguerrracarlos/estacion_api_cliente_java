/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.cmgp.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uy.com.cmgp.dominio.*;

/**
 *
 * @author cmgp
 */
public class DaoClienteApi {
    private static final String SQL_SELECT = "SELECT * FROM datos_java ORDER BY fecha_hora ASC LIMIT 70 ";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM datos_java WHERE id_estacion=? and fecha_hora=?";
    private static final String SQL_INSERT = "INSERT INTO datos_java VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE datos_java SET nombre=?, apellido=?, email=?, telefono=?,saldo=? where id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM datos_java WHERE id_cliente=?";

    public List<ClienteApi> listar() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClienteApi> clientes = new ArrayList<>();
        try {
            conn = ConexionEstacion.getConnection();            
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteApi cliente = new ClienteApi();
                cliente.setId_estacion(rs.getInt("id_estacion"));
                cliente.setFecha(rs.getString("fecha_hora"));
                cliente.setTemperatura(rs.getString("temperatura"));
                cliente.setPresion(rs.getString("presion"));
                cliente.setDireccion(rs.getInt("direccion_viento"));
                cliente.setVelocidad(rs.getString("velocidad_viento"));
                cliente.setSolar(rs.getInt("radiacion_solar"));
                cliente.setUv(rs.getInt("radiacion_uv"));
                cliente.setHumedad(rs.getString("humedad"));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (rs != null) {
                ConexionEstacion.close(rs);
            }
            if(ps != null ){
                ConexionEstacion.close(ps);
            }
            
            if(conn != null){
               ConexionEstacion.close(conn); 
            }
            return clientes;
        }

    }

    public Boolean encontrar(int id, String fecha) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ClienteApi cliente = null;
        Boolean resultado = false;
        try {
            conn = ConexionEstacion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, id);
            ps.setString(2, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new ClienteApi();
                resultado = true;
//                cliente.setIdCliente(rs.getInt("id_cliente"));
//                cliente.setNombre(rs.getString("nombre"));
//                cliente.setApellido(rs.getString("apellido"));
//                cliente.setEmail(rs.getString("email"));
//                cliente.setTelefono(rs.getString("telefono"));
//                cliente.setSaldo(rs.getDouble("saldo"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (rs != null) {
                ConexionEstacion.close(rs);
            }
            if(ps != null ){
                ConexionEstacion.close(ps);
            }
            
            if(conn != null){
               ConexionEstacion.close(conn); 
            }
        }
        return resultado;
    }

    public int insertar(ClienteApi cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        if(!this.encontrar(cliente.getId_estacion(), cliente.getFecha())){
        System.out.println(cliente);
        try {
            conn = ConexionEstacion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, cliente.getId_estacion());
            ps.setString(2, cliente.getFecha());
            ps.setString(3, cliente.getTemperatura());
            ps.setString(4, cliente.getPresion());
            ps.setInt(6, cliente.getDireccion());
            ps.setString(5, cliente.getVelocidad());
            ps.setInt(7, cliente.getSolar());
            ps.setInt(8, cliente.getUv());
            ps.setString(9, cliente.getHumedad());
            rows = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            
            if(ps != null ){
                ConexionEstacion.close(ps);
            }
            
            if(conn != null){
               ConexionEstacion.close(conn); 
            }
        }
        }
        return rows;
    }

    
    
    public int actualizar(ClienteApi cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = ConexionEstacion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
//            ps.setString(1, cliente.getNombre());
//            ps.setString(2, cliente.getApellido());
//            ps.setString(3, cliente.getEmail());
//            ps.setString(4, cliente.getTelefono());
//            ps.setDouble(5, cliente.getSaldo());
//            ps.setDouble(6, cliente.getIdCliente());
            rows = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            
            if(ps != null ){
                ConexionEstacion.close(ps);
            }
            
            if(conn != null){
               ConexionEstacion.close(conn); 
            }
        }
        return rows;
    }

    public int eliminar(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = ConexionEstacion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setDouble(1, id);

            rows = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            
            if(ps != null ){
                ConexionEstacion.close(ps);
            }
            
            if(conn != null){
               ConexionEstacion.close(conn); 
            }
        }
        return rows;
    }

}
