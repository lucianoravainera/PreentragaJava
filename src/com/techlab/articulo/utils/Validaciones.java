package com.techlab.articulo.utils;

/**
 * Clase utilitaria de validaciones.
 *
 * Se declara como final para indicar que no debe heredarse.
 * Además, todos sus métodos son static porque no necesitamos crear
 * objetos de Validaciones: simplemente queremos reutilizar funciones.
 */
public final class Validaciones {

    /**
     * Constructor privado.
     *
     * ¿Por qué privado?
     * Porque esta clase no debe instanciarse.
     * Solo contiene métodos utilitarios estáticos.
     */
    private Validaciones() {
    }

    /**
     * Valida que un texto no sea nulo ni vacío.
     *
     * @param texto texto a validar.
     * @return true si es válido, false si es nulo o vacío.
     */
    public static boolean validarTextoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida que un texto no supere cierta longitud máxima.
     *
     * @param texto texto a validar.
     * @param maximo longitud máxima permitida.
     * @return true si cumple, false si supera el máximo.
     */
    public static boolean validarLongitudMaxima(String texto, int maximo) {
        if (texto == null) {
            return false;
        }
        return texto.trim().length() <= maximo;
    }

    /**
     * Valida que un número entero no sea negativo.
     *
     * @param valor valor a validar.
     * @return true si es 0 o mayor, false si es negativo.
     */
    public static boolean validarNoNegativo(int valor) {
        return valor >= 0;
    }

    /**
     * Valida que un número decimal no sea negativo.
     *
     * @param valor valor a validar.
     * @return true si es 0 o mayor, false si es negativo.
     */
    public static boolean validarNoNegativo(double valor) {
        return valor >= 0;
    }
}
