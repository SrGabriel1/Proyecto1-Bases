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
 * Clase interfaz con los metodos para la cuenta
 *
 * @author yohan
 */
public interface ICuenta {

    /**
     * Metodo para crear nuevas cuentas
     *
     * @param numCuenta el numero de cuenta que se va registrar
     * @param idCliente el cliente que va crear la cuenta
     * @return regresa la cuenta que ya se creo
     * @throws persistenciaException validacion por si hay un error
     */
    public CuentaDTO crearCuenta(String numCuenta, int idCliente) throws persistenciaException;

    /**
     * Metodo para eliminar una cuenta
     *
     * @param id El id de la cuenta que se quiere cancelar
     * @return Regresa true si se elimino y false si no se pudo eliminar
     * @throws persistenciaException validacion por si hay un error
     */
    public boolean eliminarCuenta(int id) throws persistenciaException;

    /**
     * Metodo para mostrar las cuentas guardadas
     *
     * @return Regresa la lista de las cuentas
     * @throws persistenciaException validacion por si hay un error
     */
    public List<Cuenta> mostrarCuentas() throws persistenciaException;

    /**
     *Metodo para actualizar el folio de la cuenta
     * @param cuenta cuenta donde se quiere actualizar
     * @return regresa un true si se actualizo y false al contrario
     * @throws persistenciaException validacion por si hay un error
     */
    public boolean actualizarCuenta(Cuenta cuenta) throws persistenciaException;
}
