/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DTOS;

/**
 *
 * @author USER
 */
public class RetiroDTO {
    int idRetiro, folio, monto, contraseña, idTransaccion;
    String cuenta, fechaOperacion, fechaVencimiento,estado;

    public RetiroDTO (int idRetiro, int folio, int monto, int contraseña, int idTransaccion, String cuenta, String fechaOperacion, String fechaVencimiento, String estado) {
        this.idRetiro = idRetiro;
        this.folio = folio;
        this.monto = monto;
        this.contraseña = contraseña;
        this.idTransaccion = idTransaccion;
        this.cuenta = cuenta;
        this.fechaOperacion = fechaOperacion;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public RetiroDTO (int folio, int monto, int contraseña, int idTransaccion, String cuenta, String fechaOperacion, String fechaVencimiento, String estado) {
        this.folio = folio;
        this.monto = monto;
        this.contraseña = contraseña;
        this.idTransaccion = idTransaccion;
        this.cuenta = cuenta;
        this.fechaOperacion = fechaOperacion;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }
    
    public RetiroDTO () {
       
    }

    public RetiroDTO(int folio, int contraseña) {
        this.folio = folio;
        this.contraseña = contraseña;
    }

    public RetiroDTO(int folio, int monto, int contraseña, String cuenta) {
        this.folio = folio;
        this.monto = monto;
        this.contraseña = contraseña;
        this.cuenta = cuenta;
    }
    
    

    public int getIdRetiro() {
        return idRetiro;
    }

    public void setIdRetiro(int idRetiro) {
        this.idRetiro = idRetiro;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(String fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
