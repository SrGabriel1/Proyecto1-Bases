/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DTOS;

/**
 * Clase con datos de un usuario para usar
 *
 * @author yohan
 */
public class UsuarioDTO {

    int idCliente;
    String usuario, contrasena;

    /**
     * Constructor Vacio
     */
    public UsuarioDTO() {
    }

    /**
     * Constructor con los atributos de un usuario
     *
     * @param idCliente id del cliente relacionado al usuario
     * @param usuario El nombre de usuario
     * @param contrasena La contraseña que eligan
     *
     */
    public UsuarioDTO(String contrasena, int idCliente, String usuario) {
        this.contrasena = contrasena;
        this.idCliente = idCliente;
        this.usuario = usuario;
    }

    public UsuarioDTO(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    /**
     * Metodo que regresa la contraseña del usuario
     *
     * @return La contraseña del usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Metodo que guarda la contraseña del usuario
     *
     * @param contrasena La contraseña del usuario
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Metodo que regresa el id del cliente relacionado al usuario
     *
     * @return El id del cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Metodo que guarda el id del cliente relacionado al usuario
     *
     * @param idCliente El id del cliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Metodo que regresa el nombre del usuario
     *
     * @return El nombre del usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo que regresa el nombre del usuario
     *
     * @param usuario El nombre del usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
