/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAO;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.Usuario;
import com.mycompany.bancopersistencia.DTOS.usuarioDTO;
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
 * @author yohan
 */
public class usuarioDAO implements IUsuario {

    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(usuarioDAO.class.getName());

    public usuarioDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Usuario crearUsuario(usuarioDTO usuario) throws persistenciaException {
        String sentenciaSQL = "insert into usuarios(contrasena,usuario,idCliente) values (?,?,?)";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(2, usuario.getUsuario());
            comandoSQL.setInt(1, usuario.getContrasena());
            comandoSQL.setInt(3, usuario.getIdCliente());
            int resultado = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "se han agregado {0}", resultado);
            ResultSet res = comandoSQL.getGeneratedKeys();
            res.next();
            Usuario usuarioGuardado = new Usuario(res.getInt(1), res.getInt(3), usuario.getUsuario());
            return usuarioGuardado;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el usuario", e);
            throw new persistenciaException("No se pudo agregar el usuario");
        }
    }

    @Override
    public List<Usuario> mostrarUsuarios() throws persistenciaException {
        String sentencia = "select idUsuario, contrasena, usuario, idcliente from usuarios;";
        List<Usuario> listaUsuario = new ArrayList<>();
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia)) {
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idUsuario");
                int contrasena = resultado.getInt("contrasena");
                String usuario = resultado.getString("usuario");
                int idcliente = resultado.getInt("idcliente");

                Usuario usuarioGuardado = new Usuario(idcliente, contrasena, idcliente, usuario);
                listaUsuario.add(usuarioGuardado);
            }
            LOG.log(Level.INFO, "Se consultaron{0}", listaUsuario.size());
            return listaUsuario;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontraron usuarios", e);
            throw new persistenciaException("No hay usuarios", e);
        }
    }

}
