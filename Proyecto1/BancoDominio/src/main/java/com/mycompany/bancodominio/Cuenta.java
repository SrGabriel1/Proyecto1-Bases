/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio;

import java.util.Objects;

/**
 * Clase con los atributos de una cuenta.
 *
 * @author yohan
 */
public class Cuenta {

    int idCuenta, saldo, idCliente;
    String fechaApertura, estado, numeroCuenta;

    /**
     * contructor vacio.
     */
    public Cuenta() {
    }

    /**
     * Constructor con los atributos para inicializarlos.
     *
     * @param idCuenta id de la cuenta que se esta creando.
     * @param numeroCuenta el numero de cuenta que se le genera.
     * @param saldo Cantidad de dinero que tiene una cuenta.
     * @param idCliente el id del cliente que creo la cuenta.
     * @param fechaApertura la hora que se abrio la cuenta.
     * @param estado El estado en que se encuentra la cuenta si activa o
     * cancelada.
     */
    public Cuenta(int idCuenta, String numeroCuenta, int saldo, int idCliente, String fechaApertura, String estado) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    /**
     *
     * Constructor con los atributos para inicializarlos sin el id de la cuenta.
     *
     * @param numeroCuenta el numero de cuenta que se le genera.
     * @param saldo Cantidad de dinero que tiene una cuenta.
     * @param idCliente el id del cliente que creo la cuenta.
     * @param fechaApertura la hora que se abrio la cuenta.
     * @param estado El estado en que se encuentra la cuenta si activa o
     * cancelada.
     */
    public Cuenta(String numeroCuenta, int saldo, int idCliente, String fechaApertura, String estado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    /**
     * Metodo para regresar el id de la cuenta.
     *
     * @return id de la cuenta seleccionado.
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Metodo para guardar un id de una cuenta.
     *
     * @param idCuenta la id que se va a guardar.
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Metodo para regresar el numero de la cuenta.
     *
     * @return numero de la cuenta seleccionado.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Metodo para guardar un numero de una cuenta.
     *
     * @param numeroCuenta el numero de cuenta que se va a guardar.
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Metodo para regresar el saldo de la cuenta.
     *
     * @return saldo de la cuenta seleccionado.
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Metodo para guardar el saldo de una cuenta
     *
     * @param saldo el saldo de cuenta que se va a guardar
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * Metodo que obtiene el id del cliente asociado a la cuenta.
     *
     * @return El id del cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Metodo que establece el id del cliente asociado a la cuenta.
     *
     * @param idCliente El id del cliente que se quiere guardar.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Metodo que obtiene la fecha de apertura de la cuenta.
     *
     * @return La fecha de apertura de la cuenta.
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Metodo que establece la fecha de apertura de la cuenta.
     *
     * @param fechaApertura La nueva fecha de apertura.
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     *Metodo que obtiene el estado de la cuenta.
     *
     * @return El estado de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo que establece el estado de la cuenta.
     *
     * @param estado El nuevo estado de la cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo que calcula el hashcode.
     *
     * @return El hashcode generado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idCuenta;
        hash = 41 * hash + Objects.hashCode(this.numeroCuenta);
        hash = 41 * hash + this.saldo;
        hash = 41 * hash + this.idCliente;
        hash = 41 * hash + Objects.hashCode(this.fechaApertura);
        hash = 41 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    /**
     * Metodo que compara la cuenta con otro objeto para verificar si son iguales.
     *
     * @param obj El objeto a comparar.
     * @return true si son iguales, false de lo contrario.
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
        final Cuenta other = (Cuenta) obj;
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        if (this.numeroCuenta != other.numeroCuenta) {
            return false;
        }
        if (this.saldo != other.saldo) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.fechaApertura, other.fechaApertura)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }

    /**
     *Metodo que crea una cadena de texto.
     * @return envia la cadena de texto.
     */
    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", idCliente=" + idCliente + ", fechaApertura=" + fechaApertura + ", estado=" + estado + '}';
    }

}
