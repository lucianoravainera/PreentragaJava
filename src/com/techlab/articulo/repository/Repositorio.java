package com.techlab.articulo.repository;

// Importamos ArrayList porque los datos se almacenarán en memoria.
import java.util.ArrayList;

// Importamos Collections para devolver copias inmodificables si hiciera falta,
// pero en este ejemplo trabajaremos con copias nuevas de la lista.
import java.util.List;

// Importamos la interfaz Identificable para restringir el tipo genérico.
import com.techlab.articulo.interfaces.Identificable;

/**
 * Repositorio genérico en memoria.
 *
 * ¿Qué significa genérico?
 * Que esta clase puede trabajar con distintos tipos de objetos, siempre que
 * esos objetos implementen Identificable.
 *
 * Por eso la definición es:
 * Repositorio<T extends Identificable>
 *
 * Esto quiere decir:
 * "T puede ser cualquier tipo, pero debe tener getCodigo()".
 *
 * Esta idea es muy importante porque luego se parece al uso real de Spring Boot
 * con estructuras como JpaRepository<T, ID>.
 *
 * @param <T> tipo de objeto que almacenará el repositorio.
 */
public class Repositorio<T extends Identificable> {

    // Lista interna donde guardamos los objetos.
    private final ArrayList<T> lista;

    /**
     * Constructor del repositorio.
     *
     * Inicializa la lista vacía.
     */
    public Repositorio() {
        this.lista = new ArrayList<>();
    }

    /**
     * Agrega un objeto a la lista.
     *
     * Además valida que no exista otro objeto con el mismo código,
     * para evitar duplicados técnicos.
     *
     * @param objeto objeto a agregar.
     * @return true si se agregó, false si no se pudo.
     */
    public boolean agregar(T objeto) {
        if (objeto == null) {
            return false;
        }

        if (buscarPorCodigo(objeto.getCodigo()) != null) {
            return false;
        }

        return lista.add(objeto);
    }

    /**
     * Devuelve una copia de la lista.
     *
     * ¿Por qué devolvemos una copia y no la lista original?
     * Para proteger mejor el encapsulamiento y evitar modificaciones externas directas.
     *
     * @return lista de objetos.
     */
    public List<T> listar() {
        return new ArrayList<>(lista);
    }

    /**
     * Busca un objeto por su código.
     *
     * @param codigo código a buscar.
     * @return objeto encontrado o null si no existe.
     */
    public T buscarPorCodigo(int codigo) {
        for (T objeto : lista) {
            if (objeto.getCodigo() == codigo) {
                return objeto;
            }
        }
        return null;
    }

    /**
     * Elimina un objeto de la lista.
     *
     * @param objeto objeto a eliminar.
     * @return true si se eliminó, false si no se eliminó.
     */
    public boolean eliminar(T objeto) {
        if (objeto == null) {
            return false;
        }

        return lista.remove(objeto);
    }

    /**
     * Indica si el repositorio está vacío.
     *
     * @return true si no hay elementos, false si hay al menos uno.
     */
    public boolean estaVacio() {
        return lista.isEmpty();
    }

    /**
     * Devuelve la cantidad de elementos almacenados.
     *
     * @return cantidad de objetos.
     */
    public int cantidad() {
        return lista.size();
    }
}
