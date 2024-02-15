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
import com.mycompany.bancopersistencia.conexion.ConexionBD;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;

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

    public Usuario agregarUsuario(Usuario usuario) throws persistenciaException {
        for (int i = 0; i < usuarioDAO.mostrarUsuarios().size(); i++) {
            if (usuarioDAO.mostrarUsuarios().get(i).getIdUsuario() == usuario.getIdUsuario()) {
                return null;
            }
        }
        return usuario;
    }

    public void agregarCliente(Cliente cliente) {

    }

    public void agregarCuenta(Cuenta cuenta) {

    }

}
