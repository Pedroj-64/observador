package co.edu.uniquindio.poo.observer3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Implementación Thread-Safe del patrón Observer
 * Usa CopyOnWriteArrayList para operaciones concurrentes seguras
 */
public class SujetoThreadSafe {
    private final List<Observador> observadores;
    private String estado;
    
    public SujetoThreadSafe() {
        // CopyOnWriteArrayList es thread-safe para lectura/escritura concurrente
        this.observadores = new CopyOnWriteArrayList<>();
    }
    
    /**
     * Agrega un observador de forma thread-safe
     */
    public synchronized void agregarObservador(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
            System.out.println("[Thread-Safe] Observador agregado: " + observador.getNombre());
        }
    }
    
    /**
     * Elimina un observador de forma thread-safe
     */
    public synchronized void eliminarObservador(Observador observador) {
        if (observadores.remove(observador)) {
            System.out.println("[Thread-Safe] Observador eliminado: " + observador.getNombre());
        }
    }
    
    /**
     * Notifica a todos los observadores de forma thread-safe
     */
    public void notificarObservadores() {
        String estadoActual = getEstado();
        // Itera de forma segura incluso si la lista cambia durante la iteración
        observadores.forEach(observador -> {
            try {
                observador.actualizar(estadoActual);
            } catch (Exception e) {
                System.err.println("Error al notificar a " + observador.getNombre() + ": " + e.getMessage());
            }
        });
    }
    
    /**
     * Cambia el estado y notifica a los observadores
     */
    public synchronized void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("[Thread-Safe] Estado cambiado a: " + nuevoEstado);
        notificarObservadores();
    }
    
    public synchronized String getEstado() {
        return estado;
    }
    
    /**
     * Retorna una copia inmutable de los observadores
     */
    public List<Observador> getObservadores() {
        return Collections.unmodifiableList(new ArrayList<>(observadores));
    }
}
