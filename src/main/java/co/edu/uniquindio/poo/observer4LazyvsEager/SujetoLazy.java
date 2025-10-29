package co.edu.uniquindio.poo.observer4LazyvsEager;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación LAZY (Perezosa) del patrón Observer
 * La lista de observadores se inicializa solo cuando es necesaria
 */
public class SujetoLazy {
    private static SujetoLazy instancia;
    private List<Observador> observadores;
    private String estado;
    
    // Constructor privado para Singleton
    private SujetoLazy() {
        System.out.println("[Lazy] Constructor llamado - Instancia creada");
        // NO inicializamos la lista aquí (lazy)
    }
    
    /**
     * Obtiene la instancia (Lazy Initialization)
     * La instancia se crea solo cuando se solicita por primera vez
     */
    public static SujetoLazy getInstancia() {
        if (instancia == null) {
            System.out.println("[Lazy] Creando instancia por primera vez...");
            instancia = new SujetoLazy();
        }
        return instancia;
    }
    
    /**
     * Inicialización perezosa de la lista de observadores
     */
    private List<Observador> getObservadores() {
        if (observadores == null) {
            System.out.println("[Lazy] Inicializando lista de observadores por primera vez...");
            observadores = new ArrayList<>();
        }
        return observadores;
    }
    
    public void agregarObservador(Observador observador) {
        getObservadores().add(observador);
        System.out.println("[Lazy] Observador agregado: " + observador.getId());
    }
    
    public void eliminarObservador(Observador observador) {
        if (observadores != null) {
            observadores.remove(observador);
            System.out.println("[Lazy] Observador eliminado: " + observador.getId());
        }
    }
    
    public void notificarObservadores() {
        if (observadores != null && !observadores.isEmpty()) {
            System.out.println("[Lazy] Notificando a " + observadores.size() + " observadores...");
            for (Observador obs : observadores) {
                obs.actualizar(estado);
            }
        } else {
            System.out.println("[Lazy] No hay observadores para notificar");
        }
    }
    
    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("[Lazy] Estado cambiado a: " + nuevoEstado);
        notificarObservadores();
    }
    
    public String getEstado() {
        return estado;
    }
}
