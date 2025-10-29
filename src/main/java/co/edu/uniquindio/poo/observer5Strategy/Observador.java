package co.edu.uniquindio.poo.observer5Strategy;

/**
 * Interfaz Observer para composición con Strategy
 */
public interface Observador {
    void actualizar(String mensaje);
    String getNombre();
    boolean estaActivo();
}
