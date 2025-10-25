package co.edu.uniquindio.poo.observer4;

/**
 * Interfaz Observer para implementación Lazy/Eager
 */
public interface Observador {
    void actualizar(String evento);
    String getId();
}
