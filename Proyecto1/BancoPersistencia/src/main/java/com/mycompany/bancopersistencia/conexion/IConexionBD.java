/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *Clase de interfaz para la conexion a la base de datos
 * @author pablo
 */
public interface IConexionBD {

    /**
     *Metodo para crear la conexion
     * @return Regresa la coneccion
     * @throws SQLException Es para saber en que falle
     */
    public Connection crearConexion() throws SQLException;
}
