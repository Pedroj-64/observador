package co.edu.uniquindio.poo.observer6;

/**
 * Implementación de observador con prioridad
 */
public class ObservadorConPrioridad implements Observador {
    private final String nombre;
    private final int prioridad;
    private final String tipo;
    
    public ObservadorConPrioridad(String nombre, int prioridad, String tipo) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.tipo = tipo;
    }
    
    @Override
    public void actualizar(String evento) {
        System.out.println("  → [" + tipo + "] " + nombre + " procesó: " + evento);
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public int getPrioridad() {
        return prioridad;
    }
    
    @Override
    public int compareTo(Observador otro) {
        // Menor prioridad = mayor importancia (se notifica primero)
        return Integer.compare(this.prioridad, otro.getPrioridad());
    }
    
    @Override
    public String toString() {
        return nombre + " (Prioridad: " + prioridad + ")";
    }
}
