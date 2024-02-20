/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAO;

import com.mycompany.bancodominio.Usuario;
import com.mycompany.bancopersistencia.DTOS.UsuarioDTO;
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
 *Clase con los atributos de usuarios
 * @author yohan
 */
public abstract class UsuarioDAO implements IUsuario {

    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class.getName());

    /**
     * Constructor para hacer la conexion con la base de datos
     *
     * @param conexionBD la conexion con la base de datos
     */
    public UsuarioDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

     /**
     *Metodo para crear un usuario
     * @param usuario usuartio que se quiere guardar sus datos
     * @return el usuario guardado
     * @throws persistenciaException validacion por si hay un error
     */
    @Override
    public Usuario crearUsuario(UsuarioDTO usuario) throws persistenciaException {
        String sentenciaSQL = "insert into usuarios(contrasena,usuario,idCliente) values (?,?,?)";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, usuario.getContrasena());
            comandoSQL.setString(2, usuario.getUsuario());
            comandoSQL.setInt(3, usuario.getIdCliente());
            int resultado = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "se han agregado {0}", resultado);
            ResultSet res = comandoSQL.getGeneratedKeys();
            res.next();
            Usuario usuarioGuardado = new Usuario(res.getInt("idCliente"), usuario.getUsuario(),usuario.getContrasena());
            return usuarioGuardado;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el usuario", e);
            throw new persistenciaException("No se pudo agregar el usuario");
        }
    }

    /**
     * Metodo para mostrar todo los usuarios que hay
     * @return la lista de usuarios
     * @throws persistenciaException validacion por si hay un error
     */
    @Override
    public List<Usuario> mostrarUsuarios() throws persistenciaException {
        String sentencia = "select idUsuario, contrasena, usuario, idcliente from usuarios;";
        List<Usuario> listaUsuario = new ArrayList<>();
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia)) {
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idUsuario");
                String contrasena = resultado.getString("contrasena");
                String usuario = resultado.getString("usuario");
                int idcliente = resultado.getInt("idcliente");

                Usuario usuarioGuardado = new Usuario(id, idcliente, usuario, contrasena);
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
