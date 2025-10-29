package co.edu.uniquindio.poo.observer7Generico;

/**
 * Interfaz Observer genérica
 * @param <T> Tipo de datos que se observan
 */
public interface Observador<T> {
    void actualizar(T dato);
    String getId();
}
