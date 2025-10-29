package co.edu.uniquindio.poo.observer9;

/**
 * Interfaz Observer para implementación con Polling
 */
public interface Observador {
    void actualizar(String dato);
    String getId();
}
