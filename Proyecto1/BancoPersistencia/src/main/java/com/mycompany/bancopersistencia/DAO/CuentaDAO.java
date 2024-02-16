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
    public CuentaDTO crearCuenta(String numCuenta, int idCliente) throws persistenciaException {
        String sentenciaSQL = "insert into Cuentas(numeroCuenta,fechaApertura,saldo,estado,idCliente) values (?, now() ,0,'Activa',?)";
        String sentenciaSQL2 = "select fechaApertura from cuentas where idCuenta=last_insert_id()";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement comandoSQL2 = conexion.prepareStatement(sentenciaSQL2, Statement.RETURN_GENERATED_KEYS);) {
            comandoSQL.setString(1, numCuenta);
            comandoSQL.setInt(2, idCliente);

            int resultado = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "se han agregado {0}", resultado);
            ResultSet res= comandoSQL2.executeQuery();
            res.next();
            CuentaDTO cuentaGenerada= new CuentaDTO(res.getString("fechaApertura"), numCuenta);
            return cuentaGenerada;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "No se pudo crear la cuenta", e);
            throw new persistenciaException("No se crear agregar la cuenta");
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
    public List<Cuenta> mostrarCuentas() throws persistenciaException {
        String sentencia = "select * from usuarios;";
        List<Cuenta> listaCuenta = new ArrayList<>();
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentencia)) {
            ResultSet resultado = comandoSQL.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("idUsuario");
                String numeroCuenta = resultado.getString("numeroCuenta");
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


