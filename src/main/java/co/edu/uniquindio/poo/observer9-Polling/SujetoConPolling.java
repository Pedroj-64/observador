package co.edu.uniquindio.poo.observer9;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Implementación de Observer con Polling
 * Los observadores se notifican periódicamente en intervalos definidos
 */
public class SujetoConPolling {
    private final List<Observador> observadores = new ArrayList<>();
    private String estado;
    private String estadoAnterior;
    
    // Configuración de polling
    private Timer timer;
    private int intervaloPollingSeg;
    private boolean pollingActivo = false;
    private int contadorPolls = 0;
    
    public SujetoConPolling(int intervaloPollingSeg) {
        this.intervaloPollingSeg = intervaloPollingSeg;
        System.out.println("[Polling] Sujeto creado con intervalo de " + 
                         intervaloPollingSeg + " segundos");
    }
    
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
        System.out.println("[Polling] Observador agregado: " + observador.getId());
    }
    
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
        System.out.println("[Polling] Observador eliminado: " + observador.getId());
    }
    
    /**
     * Inicia el polling automático
     */
    public void iniciarPolling() {
        if (pollingActivo) {
            System.out.println("[Polling] Ya está activo");
            return;
        }
        
        pollingActivo = true;
        timer = new Timer("PollingTimer", true);
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ejecutarPoll();
            }
        }, 0, intervaloPollingSeg * 1000L);
        
        System.out.println("[Polling] ✓ Iniciado - Verificando cada " + 
                         intervaloPollingSeg + " segundos");
    }
    
    /**
     * Detiene el polling
     */
    public void detenerPolling() {
        if (timer != null) {
            timer.cancel();
            pollingActivo = false;
            System.out.println("[Polling] ✗ Detenido");
        }
    }
    
    /**
     * Ejecuta un ciclo de polling
     */
    private void ejecutarPoll() {
        contadorPolls++;
        System.out.println("\n[Polling] >>> Poll #" + contadorPolls + 
                         " - Verificando cambios...");
        
        // Solo notifica si el estado cambió
        if (estado != null && !estado.equals(estadoAnterior)) {
            System.out.println("[Polling] ¡Estado cambió! Notificando a " + 
                             observadores.size() + " observadores");
            notificarObservadores();
            estadoAnterior = estado;
        } else {
            System.out.println("[Polling] Sin cambios - No se notifica");
        }
    }
    
    /**
     * Notifica a todos los observadores
     */
    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(estado);
        }
    }
    
    /**
     * Cambia el estado (será detectado en el próximo poll)
     */
    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("\n[Polling] Estado cambiado a: " + nuevoEstado + 
                         " (se notificará en el próximo poll)");
    }
    
    /**
     * Fuerza una notificación inmediata (sin esperar el poll)
     */
    public void notificarInmediato() {
        System.out.println("\n[Polling] ⚡ Notificación inmediata forzada");
        notificarObservadores();
        estadoAnterior = estado;
    }
    
    public void setIntervaloPolling(int segundos) {
        this.intervaloPollingSeg = segundos;
        if (pollingActivo) {
            System.out.println("[Polling] Reiniciando con nuevo intervalo: " + segundos + "s");
            detenerPolling();
            iniciarPolling();
        }
    }
    
    public boolean isPollingActivo() {
        return pollingActivo;
    }
    
    public int getContadorPolls() {
        return contadorPolls;
    }
}
