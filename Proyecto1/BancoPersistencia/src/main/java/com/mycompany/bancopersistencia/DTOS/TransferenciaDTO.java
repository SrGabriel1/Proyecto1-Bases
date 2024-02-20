/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DTOS;

/**
 * Clase transferencia
 *
 * @author yohan
 */
public class TransferenciaDTO {

    int monto;
    String concepto, cuentaOrigen, cuentaDestino;

    /**
     * Constructor Vacio
     */
    public TransferenciaDTO() {
    }

    /**
     * Constructor con los datos para asignarlos a los atributos
     *
     * @param monto
     * @param concepto
     * @param cuentaOrigen
     * @param cuentaDestino
     */
    public TransferenciaDTO(int monto, String concepto, String cuentaOrigen, String cuentaDestino) {
        this.monto = monto;
        this.concepto = concepto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    /**
     * Metodo para mostar el monto de la transferencia
     *
     * @return El monto seleccionado a mostar
     */
    public int getMonto() {
        return monto;
    }

    /**
     * Metodo para guardar el monto de la transferencia
     *
     * @param monto El monto seleccionado a guardar
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * Metodo para mostar el concepto de la transferencia
     *
     * @return El concepto seleccionado a mostar
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Metodo para guardar el concepto de la transferencia
     *
     * @param concepto El concepto seleccionado a guardar
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * Metodo para mostar la cuenta de origen de la transferencia
     *
     * @return La cuenta de origen seleccionada a mostar
     */
    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    /**
     * Metodo para guardar la cuenta de origen de la transferencia
     *
     * @param cuentaOrigen La cuenta de origen seleccionado a guardar
     */
    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    /**
     * Metodo para mostar la cuenta de destino de la transferencia
     *
     * @return La cuenta de destino seleccionada a mostar
     */
    public String getCuentaDestino() {
        return cuentaDestino;
    }

    /**
     * Metodo para guardar la cuenta de origen de la transferencia
     *
     * @param cuentaDestino La cuenta de destino seleccionado a guardar
     */
    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

}
