/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.Controlador;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancodominio.Usuario;
import com.mycompany.bancopersistencia.DAO.ClienteDAO;
import com.mycompany.bancopersistencia.DAO.CuentaDAO;
import com.mycompany.bancopersistencia.DAO.UsuarioDAO;
import com.mycompany.bancopersistencia.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.DTOS.UsuarioDTO;
import com.mycompany.bancopersistencia.conexion.ConexionBD;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;
import javax.swing.JOptionPane;

/**
 *
 * @author yohan
 */
public class Control {

    public CuentaDAO cuentaDAO;
    public ClienteDAO clienteDAO;
    public UsuarioDAO usuarioDAO;
    String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    String user = "root";
    String contra = "16426Mel";
    IConexionBD conexionBD = new ConexionBD(cadenaConexion, user, contra);

    public Control() {
        this.cuentaDAO = new CuentaDAO(conexionBD);
        this.clienteDAO = new ClienteDAO(conexionBD);
        this.usuarioDAO = new UsuarioDAO(conexionBD);
    }

    public void agregarUsuario(Usuario usuario) throws persistenciaException {
        for (int i = 0; i < usuarioDAO.mostrarUsuarios().size(); i++) {
            if (usuarioDAO.mostrarUsuarios().get(i).getUsuario().equalsIgnoreCase(usuario.getUsuario())) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ingresado ya existe","Error",JOptionPane.ERROR_MESSAGE);
                 throw new persistenciaException("El nombre de usuario ingresado ya existe");
            }
        }
        usuarioDAO.crearUsuario(new UsuarioDTO(usuario.getContrasena(), usuario.getIdCliente(), usuario.getUsuario()));
    }

    public void agregarCliente(Cliente cliente) throws persistenciaException, Throwable {
        for (int i = 0; i < clienteDAO.consultarClientes().size(); i++) {
            if (clienteDAO.consultarClientes().get(i).getIdCliente() == cliente.getIdCliente()) {
                System.exit(0);
            }
        }
        clienteDAO.agregarCliente(new ClienteDTO(cliente.getNumeroCasa(), cliente.getEdad(), cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaNacimiento(), cliente.getCalle(), cliente.getColonia()));
    }

    public void agregarCuenta(Cuenta cuenta) throws persistenciaException {
        for (int i = 0; i < cuentaDAO.mostrarCuentas().size(); i++) {
            if (cuentaDAO.mostrarCuentas().get(i).getIdCuenta() == cuenta.getIdCuenta()) {
                System.exit(0);
            }
        }
        cuentaDAO.agregarCuenta(new CuentaDTO(cuenta.getNumeroCuenta(),cuenta.getSaldo(), cuenta.getIdCuenta(), cuenta.getFechaApertura(), cuenta.getEstado()));
    }
    public Usuario consultarUsuario(UsuarioDTO usuario) throws persistenciaException {
        return usuarioDAO.consultarUsuario(usuario);
    }
}
