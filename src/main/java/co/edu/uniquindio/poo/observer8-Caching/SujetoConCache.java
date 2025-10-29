package co.edu.uniquindio.poo.observer8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementación de Observer con Caching
 * Cachea las notificaciones para evitar notificaciones duplicadas
 */
public class SujetoConCache {
    private final List<Observador> observadores = new ArrayList<>();
    private String estado;
    
    // Cache: almacena el último estado enviado a cada observador
    private final Map<Observador, String> cacheNotificaciones = new HashMap<>();
    
    // Configuración del cache
    private boolean cacheHabilitado = true;
    private int contadorNotificacionesEvitadas = 0;
    
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
        System.out.println("[Cache] Observador agregado: " + observador.getId());
    }
    
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
        cacheNotificaciones.remove(observador);
        System.out.println("[Cache] Observador eliminado: " + observador.getId());
    }
    
    /**
     * Notifica solo si el estado ha cambiado para ese observador
     */
    public void notificarObservadores() {
        System.out.println("[Cache] Iniciando notificación...");
        int notificadas = 0;
        
        for (Observador observador : observadores) {
            if (debeNotificar(observador, estado)) {
                observador.actualizar(estado);
                cacheNotificaciones.put(observador, estado);
                notificadas++;
            } else {
                System.out.println("  ⚡ Cache Hit - Saltando notificación a " + 
                                 observador.getId() + " (mismo estado)");
                contadorNotificacionesEvitadas++;
            }
        }
        
        System.out.println("[Cache] Notificaciones enviadas: " + notificadas + 
                         ", evitadas: " + (observadores.size() - notificadas));
    }
    
    /**
     * Determina si debe notificar basándose en el cache
     */
    private boolean debeNotificar(Observador observador, String nuevoEstado) {
        if (!cacheHabilitado) {
            return true;
        }
        
        String estadoCacheado = cacheNotificaciones.get(observador);
        
        // Si no hay cache o el estado es diferente, notificar
        return estadoCacheado == null || !estadoCacheado.equals(nuevoEstado);
    }
    
    public void setEstado(String nuevoEstado) {
        System.out.println("\n>> Estado establecido a: " + nuevoEstado);
        this.estado = nuevoEstado;
        notificarObservadores();
    }
    
    /**
     * Limpia el cache forzando notificación en el siguiente cambio
     */
    public void limpiarCache() {
        cacheNotificaciones.clear();
        contadorNotificacionesEvitadas = 0;
        System.out.println("[Cache] Cache limpiado - Próximas notificaciones serán enviadas");
    }
    
    public void habilitarCache(boolean habilitar) {
        this.cacheHabilitado = habilitar;
        System.out.println("[Cache] Cache " + (habilitar ? "habilitado" : "deshabilitado"));
    }
    
    public int getNotificacionesEvitadas() {
        return contadorNotificacionesEvitadas;
    }
    
    public int getTamanoCache() {
        return cacheNotificaciones.size();
    }
}
