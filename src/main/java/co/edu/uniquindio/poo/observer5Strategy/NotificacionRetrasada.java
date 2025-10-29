package co.edu.uniquindio.poo.observer5Strategy;

/**
 * Estrategia de notificación con retraso
 */
public class NotificacionRetrasada implements EstrategiaNotificacion {
    private final int milisegundos;
    
    public NotificacionRetrasada(int milisegundos) {
        this.milisegundos = milisegundos;
    }
    
    @Override
    public void notificar(Observador observador, String mensaje) {
        System.out.println("[Retrasada] Esperando " + milisegundos + "ms antes de notificar a " + 
                         observador.getNombre());
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        observador.actualizar(mensaje);
    }
    
    @Override
    public String getNombre() {
        return "Notificación Retrasada (" + milisegundos + "ms)";
    }
}
