/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAO;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.DTOS.clienteDTO;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LV322
 */
public class clienteDAO implements ICliente {

    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(clienteDAO.class.getName());

    public clienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cliente agregarCliente(clienteDTO cliente) throws persistenciaException {
        String sentenciaSQL = "insert into clientes(nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,numeroCasa,calle,colonia,edad) values (?,?,?,?,?,?,?,?)";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getFechaNacimiento());
            comandoSQL.setInt(5, cliente.getNumeroCasa());
            comandoSQL.setString(6, cliente.getCalle());
            comandoSQL.setString(7, cliente.getColonia());
            comandoSQL.setInt(8, cliente.getEdad());

            int resultado = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "se han agregado {0}", resultado);
            ResultSet res = comandoSQL.getGeneratedKeys();
            res.next();
            Cliente clienteGuardado = new Cliente(res.getInt(5), res.getInt(8), cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaNacimiento(), cliente.getCalle(), cliente.getColonia());
            return clienteGuardado;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el cliente", e);
            throw new persistenciaException("No se pudo agregar el cliente");
        }
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) throws persistenciaException {
        String sentenciaSQL = "update clientes set nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?,fechaNacimiento=?,numeroCasa=?,calle=?,colonia=?,edad=? where idCliente=?";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getFechaNacimiento());
            comandoSQL.setInt(5, cliente.getNumeroCasa());
            comandoSQL.setString(6, cliente.getCalle());
            comandoSQL.setString(7, cliente.getColonia());
            comandoSQL.setInt(8, cliente.getEdad());
            comandoSQL.setInt(9, cliente.getIdCliente());
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "Se ha actualizado {0}", resultado);

            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el cliente", e);
            throw new persistenciaException("No se pudo actualizar el cliente");
        }
    }

    @Override
    public List<Cliente> ConsultarClientes() throws persistenciaException {
        String sentencia = "select idCliente, nombre, apellidoPaterno, apellidoMaterno,fechaNacimiento,numeroCasa,calle,colonia,edad from clientes;";
        List<Cliente> listaClientes = new ArrayList<>();
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia)) {
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idCliente");
                String nombre = resultado.getString("nombre");
                String apellidoPaterno = resultado.getString("apellidoPaterno");
                String apellidoMaterno = resultado.getString("apellidoMaterno");
                String fechaNacimiento = resultado.getString("fechaNacimiento");
                int numeroCasa = resultado.getInt("numeroCasa");
                String calle = resultado.getString("calle");
                String colonia = resultado.getString("colonia");
                int edad = resultado.getInt("edad");

                Cliente clienteConsultado = new Cliente(id, numeroCasa, edad, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, calle, colonia);
                listaClientes.add(clienteConsultado);
            }
            LOG.log(Level.INFO, "Se consultaron{0}", listaClientes.size());
            return listaClientes;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontraron clientes", e);
            throw new persistenciaException("No hay clientes", e);
        }
    }

}
