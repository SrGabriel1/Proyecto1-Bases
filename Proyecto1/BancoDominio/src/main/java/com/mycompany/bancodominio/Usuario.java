/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio;

import java.util.Objects;

/**
 * Clase con los atributos del usuario.
 *
 * @author yohan
 */
public class Usuario {

    int idUsuario, idCliente;
    String usuario, contrasena;

    /**
     * Constructor vacio
     */
    public Usuario() {
    }

    /**
     * Constructor con los atributos de un usuario
     *
     * @param idUsuario id del usuario
     * @param idCliente id del cliente relacionado al usuario
     * @param usuario El nombre de usuario
     * @param contrasena La contraseña que eligan
     */
    public Usuario(int idUsuario, int idCliente, String usuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.idCliente = idCliente;
        this.usuario = usuario;
    }

    /**
     * Constructor con los atributos de un usuario sin el id de usuario
     *
     * @param idCliente id del cliente relacionado al usuario
     * @param usuario El nombre de usuario
     * @param contrasena La contraseña que eligan
     */
    public Usuario(int idCliente, String usuario, String contrasena) {
        this.contrasena = contrasena;
        this.idCliente = idCliente;
        this.usuario = usuario;
    }

    /**
     * Metodo que regresa el id del usuario
     *
     * @return El id del usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Metodo que guarda el id del usuario
     *
     * @param idUsuario El id del usuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    /**
     * Metodo que genera un hash code
     *
     * @return hash code generado
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idUsuario;
        hash = 29 * hash + this.idCliente;
        hash = 29 * hash + Objects.hashCode(this.usuario);
        hash = 29 * hash + Objects.hashCode(this.contrasena);
        return hash;
    }

    /**
     *Metodo que compara todos los atributos del usuario con un objeto
     * @param obj objeto a comparar
     * @return regresa un true si es igual y false si es diferente
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.contrasena, other.contrasena);
    }

    /**
     *Metodo para generar una cadena de texto
     * @return cadena de texto  generada
     */
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", contrasena=" + contrasena + ", idCliente=" + idCliente + ", usuario=" + usuario + '}';
    }
}
