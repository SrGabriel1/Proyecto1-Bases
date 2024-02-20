/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.DAO;


import com.mycompany.bancodominio.Usuario;
import com.mycompany.bancopersistencia.DTOS.UsuarioDTO;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;
import java.util.List;

/**
 *Clase interfaz con los metodos para usuario
 * @author yohan
 */
public interface IUsuario {

    /**
     *Metodo para crear un usuario
     * @param usuario usuartio que se quiere guardar sus datos
     * @return el usuario guardado
     * @throws persistenciaException validacion por si hay un error
     */
    public Usuario crearUsuario(UsuarioDTO usuario) throws persistenciaException;

    /**
     * Metodo para mostrar todo los usuarios que hay
     * @return la lista de usuarios
     * @throws persistenciaException validacion por si hay un error
     */
    public List<Usuario> mostrarUsuarios() throws persistenciaException;

    /**
     *Metodo para consultar un solo usuario
     * @param usuario usuario a consultar
     * @return regresa  el usuario  si esta en la base de datos
     * @throws persistenciaException validacion por si hay un error
     */
    public Usuario consultarUsuario(UsuarioDTO usuario) throws persistenciaException;
}
