package co.edu.uniquindio.poo.observer6Prioridades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sujeto que notifica a observadores según su prioridad
 */
public class SujetoConPrioridades {
    private final List<Observador> observadores = new ArrayList<>();
    private String estado;
    
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
        // Ordenar por prioridad después de agregar
        Collections.sort(observadores);
        System.out.println("Observador agregado: " + observador.getNombre() + 
                         " (Prioridad: " + observador.getPrioridad() + ")");
    }
    
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
        System.out.println("Observador eliminado: " + observador.getNombre());
    }
    
    /**
     * Notifica a los observadores en orden de prioridad
     */
    public void notificarObservadores() {
        System.out.println("\n--- Notificando en orden de prioridad ---");
        for (int i = 0; i < observadores.size(); i++) {
            Observador obs = observadores.get(i);
            System.out.println((i + 1) + ". Prioridad " + obs.getPrioridad() + ":");
            obs.actualizar(estado);
        }
    }
    
    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("\n>> Estado cambiado a: " + nuevoEstado);
        notificarObservadores();
    }
    
    public void mostrarOrdenNotificacion() {
        System.out.println("\n--- Orden de notificación actual ---");
        for (int i = 0; i < observadores.size(); i++) {
            Observador obs = observadores.get(i);
            System.out.println((i + 1) + ". " + obs.getNombre() + 
                             " (Prioridad: " + obs.getPrioridad() + ")");
        }
    }
}
