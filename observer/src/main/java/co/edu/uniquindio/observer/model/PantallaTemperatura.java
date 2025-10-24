package co.edu.uniquindio.observer.model;

/**
 * Clase Concrete Observer del patrón Observer
 * Representa una pantalla que muestra la temperatura actual
 * Aplica Single Responsibility Principle (SRP) - Solo maneja la lógica de observación
 */
public class PantallaTemperatura implements ObservadorTemperatura {
    
    private String nombrePantalla;
    private double temperaturaActual;
    private String ciudadActual;
    
    /**
     * Constructor de la pantalla de temperatura
     * @param nombrePantalla Identificador único de la pantalla
     */
    public PantallaTemperatura(String nombrePantalla) {
        this.nombrePantalla = nombrePantalla;
    }
    
    @Override
    public void actualizar(double temperatura, String ciudad) {
        this.temperaturaActual = temperatura;
        this.ciudadActual = ciudad;
        mostrarInformacion();
    }
    
    /**
     * Muestra la información actualizada en consola (simulación)
     */
    private void mostrarInformacion() {
        System.out.println("  📺 [" + nombrePantalla + "] -> " + 
                         temperaturaActual + "°C en " + ciudadActual);
    }
    
    public String getNombrePantalla() {
        return nombrePantalla;
    }
    
    public double getTemperaturaActual() {
        return temperaturaActual;
    }
    
    public String getCiudadActual() {
        return ciudadActual;
    }
    
    /**
     * Obtiene la información formateada para mostrar en la UI
     * @return String con la información de temperatura
     */
    public String obtenerInformacionFormateada() {
        if (ciudadActual == null) {
            return nombrePantalla + ": Esperando datos...";
        }
        return nombrePantalla + ": " + temperaturaActual + "°C en " + ciudadActual;
    }
}
