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
public class Cliente {

    int idCliente, numeroCasa, edad;
    String nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, calle, colonia;

    /**
     * Clase del cliente
     */
    public Cliente() {
    }

    /**
     * Constructor con todos los valores
     *
     * @param idCliente El id del cliente que sera unico
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
     */
    public Cliente(int idCliente, int numeroCasa, int edad, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String calle, String colonia) {
        this.idCliente = idCliente;
        this.numeroCasa = numeroCasa;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.colonia = colonia;
    }

    /**
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
     */
    public Cliente(int numeroCasa, int edad, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String calle, String colonia) {
        this.numeroCasa = numeroCasa;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.colonia = colonia;
    }

    /**
     * Metodo para regresar el id del cliente
     *
     * @return Regresa el id del cliente seleccionado
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Metodo para guardar el id del cliente
     *
     * @param idCliente el id que se va a guardar
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
     * Metodo que crea un numero unico con todos los datos del cliente
     *
     * @return regresa el numero unico
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idCliente;
        hash = 17 * hash + this.numeroCasa;
        hash = 17 * hash + this.edad;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 17 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 17 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 17 * hash + Objects.hashCode(this.calle);
        hash = 17 * hash + Objects.hashCode(this.colonia);
        return hash;
    }

    /**
     * metodo para comparar los atributos del cliente
     *
     * @param obj es el tipo de objeto que se usara para comparar
     * @return regrsa falso si no es igual y verdadero si es igual
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.numeroCasa != other.numeroCasa) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        return Objects.equals(this.colonia, other.colonia);
    }

    /**
     * Cadena de texto con todos los datos del cliente
     *
     * @return Regresa la cadena de textoS
     */
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", numeroCasa=" + numeroCasa + ", edad=" + edad + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", calle=" + calle + ", colonia=" + colonia + '}';
    }

}
