/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio;

import java.util.Objects;

/**
 *
 * @author yohan
 */
public class Usuario {
    int idUsuario,contrasena,idCliente;
    String usuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, int contrasena, int idCliente, String usuario) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.idCliente = idCliente;
        this.usuario = usuario;
    }

    public Usuario(int contrasena, int idCliente, String usuario) {
        this.contrasena = contrasena;
        this.idCliente = idCliente;
        this.usuario = usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idUsuario;
        hash = 59 * hash + this.contrasena;
        hash = 59 * hash + this.idCliente;
        hash = 59 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

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
        if (this.contrasena != other.contrasena) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", contrasena=" + contrasena + ", idCliente=" + idCliente + ", usuario=" + usuario + '}';
    }
}
