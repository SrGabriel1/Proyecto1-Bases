/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DTOS;

/**
 *
 * @author yohan
 */
public class ClienteDTO {

    int numeroCasa, edad;
    String nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, calle, colonia, contrasena, usuario;

    public ClienteDTO() {
    }

    /**
     * Constructor con todos los valores
     *
     * @param numeroCasa El numero de casa que tiene el cliente para
     * relacionarlo para su direccion
     * @param edad La edad que tiene actualmente el cliente
     * @param nombre El nombre del cliente
     * @param apellidoPaterno El apellido Paterno del cliente
     * @param apellidoMaterno El apellido Materno del cliente
     * @param fechaNacimiento La Fecha de nacimiento del cliente
     * @param calle El nombre de la calle de donde vive el cliente para
     * relacionarlo para su direccion
     * @param colonia El nombre de la colonia de donde vive el cliente para
     * relacionarlo para su direccion
     * @param usuario El usuario que usara el cliente para abrir su aplicacion
     * @param contrasena La contraseña que usara el cliente para abrir su
     * aplicacion
     */
    public ClienteDTO(int numeroCasa, int edad, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String calle, String colonia, String usuario, String contrasena) {
        this.numeroCasa = numeroCasa;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.colonia = colonia;
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    /**
     * Constructor con el usuario y la contraseña 
     *
     * @param usuario El usuario que usara el cliente para abrir su aplicacion
     * @param contrasena La contraseña que usara el cliente para abrir su
     */
    public ClienteDTO(String contrasena, String usuario) {
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    /**
     *
     * Metodo para regresar el numero de la casa
     *
     * @return Regresa el numero de casa seleccionado
     */
    public int getNumeroCasa() {
        return numeroCasa;
    }

    /**
     * Metodo para guardar el numero de casa
     *
     * @param numeroCasa el dato que se guardara como numero de casa
     */
    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    /**
     * Metodo para regresar la edad
     *
     * @return regresa el dato de la edad del cliente
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo que guarda la edad del cliente
     *
     * @param edad Guarda la edad del cliente
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo para regresar el nombre del cliente
     *
     * @return regresa el nombre del cliente seleccionado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para guardar el nombre del cliente
     *
     * @param nombre guarda el nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para regresar el apellido Paterno
     *
     * @return regresa el apellido paterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Metodo que guarda el apellido paterno del cliente
     *
     * @param apellidoPaterno guarda el apellido paterno del cliente
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Metodo para regresar el apellido materno
     *
     * @return regresa el apellido materno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Metodo que guarda el apellido paterno del cliente
     *
     * @param apellidoMaterno guarda el apellido materno del cliente
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Metodo que regresa la fecha de nacimiento del cliente
     *
     * @return regresa la fecha de nacimiento del cliente
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Metodo para establecer la fecha de nacimiento
     *
     * @param fechaNacimiento fecha de nacimiento que se va a guardar
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo para regresar la calle del cliente
     *
     * @return Calle del cliente a mostrar
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Metodo para establecer la calle del cliente
     *
     * @param calle Calle a guardar
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Metodo para obtener la colonia
     *
     * @return colonia a mostrar
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Metodo para guardar la colonia
     *
     * @param colonia colonia a guardar
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
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

}
