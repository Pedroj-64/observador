package co.edu.uniquindio.poo.observer5Strategy;

/**
 * Patrón Strategy para composición con Observer
 * Define diferentes estrategias de notificación
 */
public interface EstrategiaNotificacion {
    void notificar(Observador observador, String mensaje);
    String getNombre();
}
