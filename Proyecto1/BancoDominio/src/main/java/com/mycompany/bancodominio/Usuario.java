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
    int idUsuario,idCliente;
    String usuario,contrasena;

    public Usuario() {
    }

    public Usuario(int idUsuario,  int idCliente, String usuario,String contrasena) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.idCliente = idCliente;
        this.usuario = usuario;
    }

    public Usuario( int idCliente, String usuario,String contrasena) {
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
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
        int hash = 3;
        hash = 29 * hash + this.idUsuario;
        hash = 29 * hash + this.idCliente;
        hash = 29 * hash + Objects.hashCode(this.usuario);
        hash = 29 * hash + Objects.hashCode(this.contrasena);
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
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.contrasena, other.contrasena);
    }

   
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", contrasena=" + contrasena + ", idCliente=" + idCliente + ", usuario=" + usuario + '}';
    }
}
