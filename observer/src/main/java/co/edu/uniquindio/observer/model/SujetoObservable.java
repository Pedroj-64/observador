package co.edu.uniquindio.observer.model;

/**
 * Interfaz Subject del patrón Observer
 * Define el contrato para objetos observables que mantienen una lista de observadores
 */
public interface SujetoObservable {
    
    /**
     * Agrega un observador a la lista de suscriptores
     * @param observador Observador a agregar
     */
    void agregarObservador(ObservadorTemperatura observador);
    
    /**
     * Elimina un observador de la lista de suscriptores
     * @param observador Observador a eliminar
     */
    void eliminarObservador(ObservadorTemperatura observador);
    
    /**
     * Notifica a todos los observadores registrados sobre un cambio
     */
    void notificarObservadores();
}
