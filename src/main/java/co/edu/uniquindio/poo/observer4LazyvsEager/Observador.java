package co.edu.uniquindio.poo.observer4LazyvsEager;

/**
 * Interfaz Observer para implementación Lazy/Eager
 */
public interface Observador {
    void actualizar(String evento);
    String getId();
}
