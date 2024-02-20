/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.excepciones;

/**
 * Excepción personalizada para manejar errores relacionados con la persistencia
 * de datos.
 *
 * @author pablo
 */
public class persistenciaException extends Exception {

    /**
     * Constructor Vacio
     */
    public persistenciaException() {
    }

    /**
     * Constructor que acepta un mensaje descriptivo para la excepción de
     * persistencia.
     *
     * @param message Mensaje descriptivo de la excepción.
     */
    public persistenciaException(String message) {
        super(message);
    }

  /**
     * Constructor que acepta un mensaje descriptivo y una causa subyacente para la excepción de persistencia.
     *
     * @param message Mensaje descriptivo de la excepción.
     * @param cause Causa de la excepción.
     */
    public persistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

 /**
     * Constructor que acepta una causa subyacente para la excepción de persistencia.
     *
     * @param cause Causa de la excepción.
     */
    public persistenciaException(Throwable cause) {
        super(cause);
    }

  /**
     * Constructor que acepta un mensaje descriptivo, una causa subyacente, un indicador para habilitar o deshabilitar la supresión de la excepción
     * y un indicador para habilitar o deshabilitar la escritura de la traza de la pila para la excepción de persistencia.
     *
     * @param message Mensaje descriptivo de la excepción.
     * @param cause Causa subyacente de la excepción.
     * @param enableSuppression Indica si la supresión de la excepción está habilitada o no.
     * @param writableStackTrace Indica si la traza de la pila debe ser escribible o no.
     */
    public persistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
