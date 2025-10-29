package co.edu.uniquindio.poo.observer3;

/**
 * Interfaz Observer para implementación Thread-Safe
 */
public interface Observador {
    void actualizar(String mensaje);
    String getNombre();
}
