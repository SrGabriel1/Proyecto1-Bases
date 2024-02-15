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
 *
 * @author LV322
 */
public interface ICliente {

    public Cliente agregarCliente(ClienteDTO cliente) throws persistenciaException;

    public boolean actualizarCliente(Cliente cliente) throws persistenciaException;

    public List<Cliente> consultarClientes() throws persistenciaException;

    public Cliente consultarClientePorID(int id) throws persistenciaException;
}
