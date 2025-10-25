package co.edu.uniquindio.poo.observer5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Estrategia de notificación por lotes
 * Acumula mensajes y los envía en batch
 */
public class NotificacionPorLotes implements EstrategiaNotificacion {
    private final Map<Observador, List<String>> mensajesPendientes = new HashMap<>();
    private final int tamanioLote;
    
    public NotificacionPorLotes(int tamanioLote) {
        this.tamanioLote = tamanioLote;
    }
    
    @Override
    public void notificar(Observador observador, String mensaje) {
        mensajesPendientes.putIfAbsent(observador, new ArrayList<>());
        List<String> mensajes = mensajesPendientes.get(observador);
        mensajes.add(mensaje);
        
        System.out.println("[Por Lotes] Mensaje agregado para " + observador.getNombre() + 
                         " (" + mensajes.size() + "/" + tamanioLote + ")");
        
        if (mensajes.size() >= tamanioLote) {
            enviarLote(observador, mensajes);
            mensajes.clear();
        }
    }
    
    private void enviarLote(Observador observador, List<String> mensajes) {
        System.out.println("[Por Lotes] Enviando lote de " + mensajes.size() + 
                         " mensajes a " + observador.getNombre());
        String mensajeCombinado = String.join(", ", mensajes);
        observador.actualizar("LOTE: [" + mensajeCombinado + "]");
    }
    
    public void enviarPendientes() {
        System.out.println("[Por Lotes] Enviando mensajes pendientes...");
        mensajesPendientes.forEach((obs, mensajes) -> {
            if (!mensajes.isEmpty()) {
                enviarLote(obs, mensajes);
                mensajes.clear();
            }
        });
    }
    
    @Override
    public String getNombre() {
        return "Notificación por Lotes (tamaño: " + tamanioLote + ")";
    }
}
