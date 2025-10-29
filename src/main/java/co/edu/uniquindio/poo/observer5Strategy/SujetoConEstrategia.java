package co.edu.uniquindio.poo.observer5Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Sujeto que usa el patrón Strategy para notificaciones
 * Composición de Observer + Strategy
 */
public class SujetoConEstrategia {
    private final List<Observador> observadores = new ArrayList<>();
    private EstrategiaNotificacion estrategia;
    private String estado;
    
    public SujetoConEstrategia(EstrategiaNotificacion estrategia) {
        this.estrategia = estrategia;
        System.out.println("Sujeto creado con estrategia: " + estrategia.getNombre());
    }
    
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
        System.out.println("Observador agregado: " + observador.getNombre());
    }
    
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
        System.out.println("Observador eliminado: " + observador.getNombre());
    }
    
    /**
     * Cambia la estrategia de notificación en tiempo de ejecución
     */
    public void setEstrategia(EstrategiaNotificacion nuevaEstrategia) {
        System.out.println("\n*** Cambiando estrategia de notificación ***");
        System.out.println("Anterior: " + this.estrategia.getNombre());
        System.out.println("Nueva: " + nuevaEstrategia.getNombre() + "\n");
        this.estrategia = nuevaEstrategia;
    }
    
    /**
     * Notifica usando la estrategia actual
     */
    public void notificarObservadores() {
        System.out.println("\n--- Notificando con: " + estrategia.getNombre() + " ---");
        for (Observador observador : observadores) {
            estrategia.notificar(observador, estado);
        }
    }
    
    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("\n>> Estado cambiado a: " + nuevoEstado);
        notificarObservadores();
    }
    
    public EstrategiaNotificacion getEstrategia() {
        return estrategia;
    }
}
