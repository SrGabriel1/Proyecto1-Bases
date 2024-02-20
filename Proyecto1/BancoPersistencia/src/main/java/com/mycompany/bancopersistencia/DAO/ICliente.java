/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.DAO;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;
import java.util.List;

/**
 * Clase interfaz para los metodos de los clientes
 *
 * @author pablo
 */
public interface ICliente {

    /**
     * Metodo para agregar un cliente
     *
     * @param cliente Cliente que se quiere agregar
     * @throws persistenciaException validacion por si hay un error
     */
    public void agregarCliente(ClienteDTO cliente) throws persistenciaException;

    /**
     *Metodo para actualizar un cliente
     * @param cliente cliente a actualizar
     * @return  regesa un true si se actualizo y un false si no
     * @throws persistenciaException validacion por si hay un error
     */
    public boolean actualizarCliente(Cliente cliente) throws persistenciaException;

    /**
     * Metodo para consultar los cliente
     *
     * @return Regresa una lista con los clientes
     * @throws persistenciaException validacion por si hay un error
     */
    public List<Cliente> consultarClientes() throws persistenciaException;

    /**
     * Metodo para consultar los cliente
     *
     * @param id id del cliente para consultar
     * @return regresa el cliente con ese id
     * @throws persistenciaException validacion por si hay un error
     */
    public Cliente consultarClientePorID(int id) throws persistenciaException;

    /**
     * Metodo para consultar un cliente
     *
     * @param cliente cliente para consultar
     * @return el cliente consultado
     * @throws persistenciaException validacion por si hay un error
     */
    public Cliente consultarCliente(ClienteDTO cliente) throws persistenciaException;


}
