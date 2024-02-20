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
import com.mycompany.bancopersistencia.DTOS.RetiroDTO;
import com.mycompany.bancopersistencia.DTOS.TransferenciaDTO;
import com.mycompany.bancopersistencia.DTOS.UsuarioDTO;
import com.mycompany.bancopersistencia.Encriptacion.encriptacion;
import com.mycompany.bancopersistencia.conexion.ConexionBD;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yohan
 */
public class Control {

    /**
     * variable de la cuenta dao
     */
    public CuentaDAO cuentaDAO;

    /**
     * variable del cliente dao
     */
    public ClienteDAO clienteDAO;

    /**
     * variable del usuario dao
     */
    public UsuarioDAO usuarioDAO;

    String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    String user = "root";
    String contra = "1233";
    IConexionBD conexionBD = new ConexionBD(cadenaConexion, user, contra);
    Random random = new Random();
    StringBuilder numeroAleatorio;

    /**
     * Constructor Inicializador
     */
    public Control() {
        this.cuentaDAO = new CuentaDAO(conexionBD);
        this.clienteDAO = new ClienteDAO(conexionBD);
    }

    /**
     * Metodo para agregar un cliente
     *
     * @param cliente Cliente que se quiere agregar
     * @throws persistenciaException validacion por si hay un error
     */
    public void agregarCliente(Cliente cliente) throws persistenciaException, Throwable {
        if (!clienteDAO.consultarClientes().isEmpty()) {
            for (int i = 0; i < clienteDAO.consultarClientes().size(); i++) {
                if (clienteDAO.consultarClientes().get(i).getUsuario().equalsIgnoreCase(cliente.getUsuario())) {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    throw new persistenciaException("El usuario ya existe");
                }
            }
        }
        clienteDAO.agregarCliente(new ClienteDTO(cliente.getNumeroCasa(), cliente.getEdad(), cliente.getNombre(), cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno(), cliente.getFechaNacimiento(), cliente.getCalle(), cliente.getColonia(),
                cliente.getUsuario(), cliente.getContrasena()));
    }

<<<<<<< Updated upstream
=======
    /**
     * Metodo para actualizar un cliente
     *
     * @param cliente cliente a actualizar
     * @return regesa un true si se actualizo y un false si no
     * @throws persistenciaException validacion por si hay un error
     */
    public boolean actualizarCliente(Cliente cliente) throws persistenciaException {
        return clienteDAO.actualizarCliente(cliente);
    }

    /**
     * Metodo para consultar los clientes
     *
     * @return Regresa una lista con los clientes
     * @throws persistenciaException validacion por si hay un error
     */
>>>>>>> Stashed changes
    public Cliente consultarCliente(ClienteDTO cliente) throws persistenciaException {
        return clienteDAO.consultarCliente(cliente);
    }

    /**
     * Metodo para crear nuevas cuentas
     *
     * @param cliente el cliente que va crear la cuenta
     * @return regresa la cuenta que ya se creo
     * @throws persistenciaException validacion por si hay un error
     */
    public CuentaDTO agregarCuenta(Cliente cliente) throws persistenciaException {
        boolean bandera = true;
        while (bandera) {
            // Generar un número aleatorio de 6 dígitos como una cadena
            numeroAleatorio = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int digito = random.nextInt(10); // Generar un dígito aleatorio (0-9)
                numeroAleatorio.append(digito); // Agregar el dígito al número aleatorio
            }
            if (!cuentaDAO.mostrarCuentas().isEmpty()) {
                for (int i = 0; i < cuentaDAO.mostrarCuentas().size(); i++) {
                    if (!cuentaDAO.mostrarCuentas().get(i).getNumeroCuenta().equalsIgnoreCase(numeroAleatorio.toString())) {
                        bandera = false;
                        break;
                    }
                }
            } else {
                bandera = false;
            }
        }
        return cuentaDAO.crearCuenta(numeroAleatorio.toString(), cliente.getIdCliente());
    }

  /**
     *Metodo para consultar una cuenta por su numero
     * @param numeroCuenta numero para consultar una cuenta
     * @return regresa la cuenta
     * @throws persistenciaException validacion por si hay un error
     */
    public Cuenta consultarCuentaPorNumeroCuenta(String numeroCuenta) throws persistenciaException {
        return cuentaDAO.consultarCuentaPorNumeroCuenta(numeroCuenta);
    }

 /**
     *Metodo para hacer la transferencia
     * @param transferencia la transferencia que se va a hacer
     * @return true si se logro y false en lo contrario
     */
    public boolean transferencia(TransferenciaDTO transferencia) {
        return cuentaDAO.transferencia(transferencia);
    }

  /**
     *Metodo para mostrar las cuentas de un cliente
     * @param idCliente id del cliente que se va mostrar las cuentas
     * @return las cuentas que tiene el cliente
     * @throws persistenciaException validacion por si hay un error
     */
    public List<Cuenta> mostrarCuentasDeCliente(int idCliente) throws persistenciaException {
        return cuentaDAO.mostrarCuentasDeCliente(idCliente);
    }

   /**
     *Metodo para depositar dinero
     * @param cuenta Cuenta donde se va a depositar
     * @param montoDeposito cantidad a depositar
     * @return regresa true si se logro, false en caso contrario
     */
    public boolean depositar(Cuenta cuenta, int montoDeposito) {
        if (montoDeposito % 100 != 0) {
            JOptionPane.showMessageDialog(null, "Solo se admiten valores de 100 en 100", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            try {
                cuentaDAO.depositarDinero(cuenta, montoDeposito);
            } catch (persistenciaException ex) {
                JOptionPane.showMessageDialog(null, "Error al realizar el deposito", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

   /**
     *Metodo para crear un retiro sin cuenta
     * @param retiro cantidad del retiro
     * @return true si se logro y false en lo contrario
     */
    public boolean crearRetiro(RetiroDTO retiro) {
        Random random = new Random(); // Generar un número aleatorio de 8 dígitos 
        int folio = random.nextInt(90000000) + 10000000; // Genera un número entre 10000000 y 99999999
        int contra = random.nextInt(90000000) + 10000000; // Genera un número entre 10000000 y 99999999
        retiro.setContraseña(contra);
        retiro.setFolio(folio);
        return cuentaDAO.crearRetiroSinCuenta(retiro);
    }

  /**
     *Metodo que realiza el retiro sin cuenta
     * @param folio el folio para hacer el retiro
     * @param contra la contra para  hacer el retiro
     * @return true si se logro y false en lo contrario
     */
    public boolean reaizarRetiro(int folio, int contra) {
        return cuentaDAO.realizarRetiroSinCuenta(folio, contra);
    }
}
