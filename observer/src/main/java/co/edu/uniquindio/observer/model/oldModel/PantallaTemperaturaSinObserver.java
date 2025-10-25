package co.edu.uniquindio.observer.model.oldModel;

/**
 * Versión de la pantalla de temperatura sin usar el patrón Observer
 * Desventajas de esta implementación:
 * 1. Acoplamiento directo con EstacionClimaSinObserver
 * 2. No hay una interfaz común para diferentes tipos de pantallas
 * 3. Cada pantalla debe ser registrada manualmente en la estación
 */
public class PantallaTemperaturaSinObserver {
    
    private String nombre;
    
    public PantallaTemperaturaSinObserver(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método que debe ser llamado manualmente por la estación
     * Desventaja: La estación debe conocer los detalles de implementación de la pantalla
     */
    public void mostrarTemperatura(double temperatura, String ciudad) {
        System.out.println("  → [" + nombre + "] -> " + temperatura + "°C en " + ciudad);
    }
    
    public String getNombre() {
        return nombre;
    }
}