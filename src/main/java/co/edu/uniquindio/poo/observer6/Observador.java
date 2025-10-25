package co.edu.uniquindio.poo.observer6;

/**
 * Interfaz Observer con prioridad
 */
public interface Observador extends Comparable<Observador> {
    void actualizar(String evento);
    String getNombre();
    int getPrioridad(); // Menor número = mayor prioridad
}
