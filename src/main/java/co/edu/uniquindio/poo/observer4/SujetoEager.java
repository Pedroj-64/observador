package co.edu.uniquindio.poo.observer4;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación EAGER (Anticipada) del patrón Observer
 * La instancia y todos los recursos se inicializan inmediatamente
 */
public class SujetoEager {
    // Inicialización anticipada - se crea al cargar la clase
    private static final SujetoEager INSTANCIA = new SujetoEager();
    
    // Lista inicializada inmediatamente en la declaración
    private final List<Observador> observadores = new ArrayList<>();
    private String estado = "INICIAL";
    
    // Constructor privado para Singleton
    private SujetoEager() {
        System.out.println("[Eager] Constructor llamado - Instancia y recursos creados inmediatamente");
    }
    
    /**
     * Obtiene la instancia (Eager Initialization)
     * La instancia ya existe desde que se cargó la clase
     */
    public static SujetoEager getInstancia() {
        System.out.println("[Eager] Retornando instancia pre-creada");
        return INSTANCIA;
    }
    
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
        System.out.println("[Eager] Observador agregado: " + observador.getId());
    }
    
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
        System.out.println("[Eager] Observador eliminado: " + observador.getId());
    }
    
    public void notificarObservadores() {
        System.out.println("[Eager] Notificando a " + observadores.size() + " observadores...");
        for (Observador obs : observadores) {
            obs.actualizar(estado);
        }
    }
    
    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("[Eager] Estado cambiado a: " + nuevoEstado);
        notificarObservadores();
    }
    
    public String getEstado() {
        return estado;
    }
    
    public int getCantidadObservadores() {
        return observadores.size();
    }
}
