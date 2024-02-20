/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.DAO;

import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;
import java.util.List;

/**
 *
 * @author yohan
 */
public interface ICuenta {

    public CuentaDTO crearCuenta(String numCuenta, int idCliente) throws persistenciaException;

    public boolean eliminarCuenta(int id) throws persistenciaException;
    
    public List<Cuenta> mostrarCuentas() throws persistenciaException;
    
    public List<Cuenta> mostrarCuentasDeCliente(int idCliente) throws persistenciaException;

}
