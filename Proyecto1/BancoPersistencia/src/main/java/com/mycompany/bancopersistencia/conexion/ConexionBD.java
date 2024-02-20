/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para hacer la conexion con la base de datos
 *
 * @author pablo
 */
public class ConexionBD implements IConexionBD {

    final String cadenaConexion, usuario, contra;
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());

    /**
     * Constructo con los parametros para la conexion
     *
     * @param cadenaConexion Es el texto con la localizacion de la base de datos
     * @param usuario El usuario con el que se inicia secion en el mysql
     * @param contra La contraseña con el que se inicia secion en el mysql
     */
    public ConexionBD(String cadenaConexion, String usuario, String contra) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contra = contra;
    }

    /**
     * Metodo para crear la conexion
     *
     * @return Regresa la coneccion
     * @throws SQLException Es para saber en que falle
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra);
        LOG.log(Level.INFO, "Conexion establecida{0}", cadenaConexion);
        return conexion;

    }

}
