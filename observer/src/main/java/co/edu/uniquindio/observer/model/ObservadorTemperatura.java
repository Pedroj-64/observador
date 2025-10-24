package co.edu.uniquindio.observer.model;

/**
 * Interfaz Observer del patrón Observer
 * Define el contrato para objetos que quieren ser notificados de cambios
 */
public interface ObservadorTemperatura {
    
    /**
     * Método llamado cuando el sujeto observable notifica un cambio
     * @param temperatura Nueva temperatura registrada
     * @param ciudad Ciudad donde se registró la temperatura
     */
    void actualizar(double temperatura, String ciudad);
}
