package com.techlab.articulo.utils;

/**
 * Clase utilitaria encargada de generar códigos automáticos.
 *
 * ¿Por qué la usamos?
 * Porque tanto las categorías como los artículos necesitan códigos únicos
 * e incrementales.
 *
 * En lugar de dejar esa lógica repartida por distintos menús,
 * la centralizamos aquí.
 */
public final class Secuencias {

    // Próximo código disponible para artículos.
    private static int proximoCodigoArticulo = 1;

    // Próximo código disponible para categorías.
    private static int proximoCodigoCategoria = 1;

    /**
     * Constructor privado para impedir instanciación.
     */
    private Secuencias() {
    }

    /**
     * Genera y devuelve el próximo código de artículo.
     *
     * Usamos el operador post-incremento:
     * primero devuelve el valor actual y luego incrementa.
     *
     * @return nuevo código de artículo.
     */
    public static int generarCodigoArticulo() {
        return proximoCodigoArticulo++;
    }

    /**
     * Genera y devuelve el próximo código de categoría.
     *
     * @return nuevo código de categoría.
     */
    public static int generarCodigoCategoria() {
        return proximoCodigoCategoria++;
    }
}
