package co.edu.uniquindio.poo.observer7Generico;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación genérica del patrón Observer
 * Puede trabajar con cualquier tipo de dato
 * @param <T> Tipo de dato que maneja el sujeto
 */
public class SujetoGenerico<T> {
    private final List<Observador<T>> observadores = new ArrayList<>();
    private T estado;
    
    public void agregarObservador(Observador<T> observador) {
        observadores.add(observador);
        System.out.println("[Genérico] Observador agregado: " + observador.getId());
    }
    
    public void eliminarObservador(Observador<T> observador) {
        observadores.remove(observador);
        System.out.println("[Genérico] Observador eliminado: " + observador.getId());
    }
    
    public void notificarObservadores() {
        System.out.println("[Genérico] Notificando a " + observadores.size() + " observadores...");
        for (Observador<T> observador : observadores) {
            observador.actualizar(estado);
        }
    }
    
    public void setEstado(T nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("\n[Genérico] Estado cambiado: " + nuevoEstado);
        notificarObservadores();
    }
    
    public T getEstado() {
        return estado;
    }
    
    public int getCantidadObservadores() {
        return observadores.size();
    }
}
