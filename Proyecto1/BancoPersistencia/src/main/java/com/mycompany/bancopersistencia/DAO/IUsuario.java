/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.DAO;

import com.mycompany.bancodominio.Usuario;
import com.mycompany.bancopersistencia.DTOS.usuarioDTO;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;
import java.util.List;

/**
 *
 * @author yohan
 */
public interface IUsuario {

    public Usuario crearUsuario(usuarioDTO usuario) throws persistenciaException;

    public List<Usuario> mostrarUsuarios() throws persistenciaException;

}
