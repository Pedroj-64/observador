package co.edu.uniquindio.poo.observer5;

/**
 * Estrategia de notificación inmediata
 */
public class NotificacionInmediata implements EstrategiaNotificacion {
    
    @Override
    public void notificar(Observador observador, String mensaje) {
        System.out.println("[Inmediata] Notificando a " + observador.getNombre());
        observador.actualizar(mensaje);
    }
    
    @Override
    public String getNombre() {
        return "Notificación Inmediata";
    }
}
