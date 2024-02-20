/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAO;

import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.DTOS.TransferenciaDTO;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.excepciones.persistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase con los atributos de cuenta
 * @author yohan
 */
public class CuentaDAO implements ICuenta {

    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    /**
     * Constructor para hacer la conexion con la base de datos
     *
     * @param conexionBD la conexion con la base de datos
     */
    public CuentaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Metodo para crear nuevas cuentas
     *
     * @param numCuenta el numero de cuenta que se va registrar
     * @param idCliente el cliente que va crear la cuenta
     * @return regresa la cuenta que ya se creo
     * @throws persistenciaException validacion por si hay un error
     */
    @Override
    public CuentaDTO crearCuenta(String numCuenta, int idCliente) throws persistenciaException {
        String sentenciaSQL = "insert into Cuentas(numeroCuenta,fechaApertura,saldo,estado,idCliente) values (?, now() ,0,'Activa',?)";
        String sentenciaSQL2 = "select fechaApertura from cuentas where idCuenta=last_insert_id()";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); PreparedStatement comandoSQL2 = conexion.prepareStatement(sentenciaSQL2, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, numCuenta);
            comandoSQL.setInt(2, idCliente);

            int resultado = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "se han agregado {0}", resultado);
            ResultSet res = comandoSQL2.executeQuery();
            res.next();
            CuentaDTO cuentaGenerada = new CuentaDTO(res.getString("fechaApertura"), numCuenta);
            return cuentaGenerada;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
            throw new persistenciaException("No se crear agregar la cuenta");
        }
    }

    /**
     * Metodo para eliminar una cuenta
     *
     * @param id El id de la cuenta que se quiere cancelar
     * @return Regresa true si se elimino y false si no se pudo eliminar
     * @throws persistenciaException validacion por si hay un error
     */
    @Override
    public boolean eliminarCuenta(int id) throws persistenciaException {
        String sentencia = "delete from cuentas where idCuenta =?";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia)) {
            comandoSQL.setInt(1, id);
            return true;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo eliminar  la cuenta", e);
            throw new persistenciaException("No se pudo eliminar la cuenta");
        }
    }

    /**
     * Metodo para mostrar las cuentas guardadas
     *
     * @return Regresa la lista de las cuentas
     * @throws persistenciaException validacion por si hay un error
     */
    @Override
    public List<Cuenta> mostrarCuentas() throws persistenciaException {
        String sentencia = "select * from cuentas;";
        List<Cuenta> listaCuenta = new ArrayList<>();
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia)) {
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idCuenta");
                String numeroCuenta = resultado.getString("numeroCuenta");
                String fechaApertura = resultado.getString("fechaApertura");
                int saldo = resultado.getInt("saldo");
                String estado = resultado.getString("estado");
                int idcliente = resultado.getInt("idcliente");

                Cuenta CuentaGuardada = new Cuenta(id, numeroCuenta, saldo, idcliente, fechaApertura, estado);
                listaCuenta.add(CuentaGuardada);
            }
            LOG.log(Level.INFO, "Se consultaron{0}", listaCuenta.size());
            return listaCuenta;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontraron cuentas", e);
            throw new persistenciaException("No hay cuentas", e);
        }
    }

    /**
     *Metodo para consultar una cuenta por su numero
     * @param numeroCuenta numero para consultar una cuenta
     * @return regresa la cuenta
     * @throws persistenciaException validacion por si hay un error
     */
    public Cuenta consultarCuentaPorNumeroCuenta(String numeroCuenta) throws persistenciaException {
        String sentenciaSQL = "call cuentaPorNumero(?)";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, numeroCuenta);
            ResultSet res = comandoSQL.executeQuery();
            int id = res.getInt("idCuenta");
            String numeroCuentas = res.getString("numeroCuenta");
            String fechaApertura = res.getString("fechaApertura");
            int saldo = res.getInt("saldo");
            String estado = res.getString("estado");
            int idcliente = res.getInt("idcliente");
            res.next();
            Cuenta CuentaGuardada = new Cuenta(id, numeroCuentas, saldo, idcliente, fechaApertura, estado);
            return CuentaGuardada;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo consultar la cuenta", e);
            throw new persistenciaException("No se consulto  la cuenta");
        }
    }

    /**
     *Metodo para hacer la transferencia
     * @param transferencia la transferencia que se va a hacer
     * @return true si se logro y false en lo contrario
     */
    public boolean transferencia(TransferenciaDTO transferencia) {
        String sentenciaSQL = "call realizar_transferencia(?,?,?,?)";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareCall(sentenciaSQL)) {
            comandoSQL.setInt(1, transferencia.getMonto());
            comandoSQL.setString(2, transferencia.getCuentaOrigen());
            comandoSQL.setString(3, transferencia.getCuentaDestino());
            comandoSQL.setString(4, transferencia.getConcepto());
            comandoSQL.execute();

            LOG.log(Level.INFO, " se pudo hacer la transferencia");

            return true;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo hacer la transferencia", e);
            return false;
        }
    }

    /**
     * Metodo para actualizar el folio de la cuenta
     *
     * @param cuenta cuenta donde se quiere actualizar
     * @return regresa un true si se actualizo y false al contrario
     * @throws persistenciaException validacion por si hay un error
     */
    @Override
    public boolean actualizarCuenta(Cuenta cuenta) throws persistenciaException {
        String sentenciaSQL = "update cuentas set estado=? where numeroCuenta=?";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, cuenta.getEstado());
            comandoSQL.setString(2, cuenta.getNumeroCuenta());
            int resultado = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "Se ha actualizado {0}", resultado);

            return true;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el cliente", e);
            throw new persistenciaException("No se pudo actualizar el cliente");
        }
    }

}
