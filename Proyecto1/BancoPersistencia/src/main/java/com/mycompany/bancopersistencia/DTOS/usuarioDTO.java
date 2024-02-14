/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DTOS;

/**
 *
 * @author yohan
 */
public class usuarioDTO {

    int contrasena, idCliente;
    String usuario;

    public usuarioDTO() {
    }

    public usuarioDTO(int contrasena, int idCliente, String usuario) {
        this.contrasena = contrasena;
        this.idCliente = idCliente;
        this.usuario = usuario;
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
    
}
