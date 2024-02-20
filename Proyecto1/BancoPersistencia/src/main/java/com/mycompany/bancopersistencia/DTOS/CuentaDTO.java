/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DTOS;

/**
 *Clase con los datos de la cuenta para usar
 * @author yohan
 */
public class CuentaDTO {

    int saldo, idCliente;
    String fechaApertura, estado, numeroCuenta;

    /**
     *Constructor Vacio
     */
    public CuentaDTO() {
    }

    /**
     * Constructor con los atributos para inicializarlos.
     *
     * @param numeroCuenta el numero de cuenta que se le genera.
     * @param saldo Cantidad de dinero que tiene una cuenta.
     * @param idCliente el id del cliente que creo la cuenta.
     * @param fechaApertura la hora que se abrio la cuenta.
     * @param estado El estado en que se encuentra la cuenta si activa o
     * cancelada.
     */
    public CuentaDTO(String numeroCuenta, int saldo, int idCliente, String fechaApertura, String estado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    /**
     *   Constructor con los atributos de fecha de apertura y el numero de cuenta para inicializarlos.
     *
     * @param fechaApertura la hora que se abrio la cuenta.
     * @param numeroCuenta el numero de cuenta que se le genera.
     */
    public CuentaDTO(String fechaApertura, String numeroCuenta) {
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
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
     * Metodo que obtiene el estado de la cuenta.
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
}
