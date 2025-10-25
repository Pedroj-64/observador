package co.edu.uniquindio.poo.observer5;

/**
 * Estrategia de notificación condicional
 * Solo notifica si el observador está activo
 */
public class NotificacionCondicional implements EstrategiaNotificacion {
    
    @Override
    public void notificar(Observador observador, String mensaje) {
        if (observador.estaActivo()) {
            System.out.println("[Condicional] Observador activo - Notificando a " + 
                             observador.getNombre());
            observador.actualizar(mensaje);
        } else {
            System.out.println("[Condicional] Observador inactivo - Saltando a " + 
                             observador.getNombre());
        }
    }
    
    @Override
    public String getNombre() {
        return "Notificación Condicional";
    }
}
