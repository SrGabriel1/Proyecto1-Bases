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
public class Cuenta {
    int idCuenta,numeroCuenta,saldo,idCliente;
    String fechaApertura,estado;

    public Cuenta() {
    }

    public Cuenta(int idCuenta, int numeroCuenta, int saldo, int idCliente, String fechaApertura, String estado) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    public Cuenta(int numeroCuenta, int saldo, int idCliente, String fechaApertura, String estado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idCuenta;
        hash = 41 * hash + this.numeroCuenta;
        hash = 41 * hash + this.saldo;
        hash = 41 * hash + this.idCliente;
        hash = 41 * hash + Objects.hashCode(this.fechaApertura);
        hash = 41 * hash + Objects.hashCode(this.estado);
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

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", idCliente=" + idCliente + ", fechaApertura=" + fechaApertura + ", estado=" + estado + '}';
    }
    
}
