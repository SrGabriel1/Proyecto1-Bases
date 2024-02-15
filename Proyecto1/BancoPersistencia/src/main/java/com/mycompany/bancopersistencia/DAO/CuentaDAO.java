/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAO;


import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.DTOS.CuentaDTO;
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
 *
 * @author yohan
 */
public class CuentaDAO implements ICuenta {

    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public CuentaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws persistenciaException {
        String sentenciaSQL = "insert into Cuentas(numeroCuenta,fechaApertura,saldo,estado,idCliente) values (?,?,?,?,?)";

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setInt(1, cuenta.getNumeroCuenta());
            comandoSQL.setString(2, cuenta.getFechaApertura());
            comandoSQL.setInt(3, cuenta.getSaldo());
            comandoSQL.setString(4, cuenta.getEstado());
            comandoSQL.setInt(5, cuenta.getIdCliente());

            int resultado = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "se han agregado {0}", resultado);
            ResultSet res = comandoSQL.getGeneratedKeys();
            res.next();
            Cuenta cuentaGuardada = new Cuenta(res.getInt(1), res.getInt(3), res.getInt(5), cuenta.getFechaApertura(), cuenta.getEstado());
            return cuentaGuardada;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la cuenta", e);
            throw new persistenciaException("No se pudo agregar la cuenta");
        }
    }

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

    @Override
    public List<Cuenta> mostrarCuentas(CuentaDTO cuenta) throws persistenciaException {
        String sentencia = "select idCuenta, numeroCuenta, fechaApertura, saldo,estado,idCliente from usuarios;";
        List<Cuenta> listaCuenta = new ArrayList<>();
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia)) {
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idUsuario");
                int numeroCuenta = resultado.getInt("numeroCuenta");
                String fechaApertura = resultado.getString("fechaApertura");
                int saldo = resultado.getInt("saldo");
                String estado = resultado.getString("estado");
                int idcliente = resultado.getInt("idcliente");

                Cuenta CuentaGuardada= new Cuenta(id, numeroCuenta, saldo, idcliente, fechaApertura, estado);
                listaCuenta.add(CuentaGuardada);
            }
            LOG.log(Level.INFO, "Se consultaron{0}", listaCuenta.size());
            return listaCuenta;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se encontraron cuentas", e);
            throw new persistenciaException("No hay cuentas", e);
        }
    }
}


