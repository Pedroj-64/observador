package co.edu.uniquindio.observer.model.oldModel;

/**
 * Versión de la estación meteorológica sin usar el patrón Observer
 * Esta implementación muestra las desventajas de no usar el patrón:
 * 1. Alto acoplamiento - La estación necesita conocer todas las pantallas
 * 2. Difícil mantenimiento - Agregar nueva pantalla requiere modificar esta clase
 * 3. Violación del principio Open/Closed - Se debe modificar la clase para extensiones
 * 4. Código menos flexible y más propenso a errores
 */
public class EstacionClimaSinObserver {
    
    private PantallaTemperaturaSinObserver pantallaPrincipal;
    private PantallaTemperaturaSinObserver pantallaSecundaria;
    private PantallaTemperaturaSinObserver pantallaMovil;
    private double temperatura;
    private String ciudad;
    
    /**
     * Constructor que requiere todas las pantallas al inicio
     * Desventaja: Las pantallas deben existir al crear la estación
     */
    public EstacionClimaSinObserver(String ciudad, 
                                  PantallaTemperaturaSinObserver pantallaPrincipal,
                                  PantallaTemperaturaSinObserver pantallaSecundaria,
                                  PantallaTemperaturaSinObserver pantallaMovil) {
        this.ciudad = ciudad;
        this.temperatura = 0.0;
        this.pantallaPrincipal = pantallaPrincipal;
        this.pantallaSecundaria = pantallaSecundaria;
        this.pantallaMovil = pantallaMovil;
    }
    
    /**
     * Actualiza la temperatura y debe actualizar manualmente cada pantalla
     * Desventajas:
     * - Código duplicado para cada pantalla
     * - Si se agrega una nueva pantalla, hay que modificar este método
     * - Alto acoplamiento con las clases de pantalla
     */
    public void establecerTemperatura(double nuevaTemperatura) {
        System.out.println("\nNueva temperatura registrada: " + nuevaTemperatura + "°C en " + ciudad);
        this.temperatura = nuevaTemperatura;
        
        // Actualización manual de cada pantalla
        if (pantallaPrincipal != null) {
            pantallaPrincipal.mostrarTemperatura(temperatura, ciudad);
        }
        if (pantallaSecundaria != null) {
            pantallaSecundaria.mostrarTemperatura(temperatura, ciudad);
        }
        if (pantallaMovil != null) {
            pantallaMovil.mostrarTemperatura(temperatura, ciudad);
        }
    }
    
    /**
     * Métodos para cambiar pantallas individualmente
     * Desventaja: Se necesita un método por cada tipo de pantalla
     */
    public void cambiarPantallaPrincipal(PantallaTemperaturaSinObserver nuevaPantalla) {
        this.pantallaPrincipal = nuevaPantalla;
    }
    
    public void cambiarPantallaSecundaria(PantallaTemperaturaSinObserver nuevaPantalla) {
        this.pantallaSecundaria = nuevaPantalla;
    }
    
    public void cambiarPantallaMovil(PantallaTemperaturaSinObserver nuevaPantalla) {
        this.pantallaMovil = nuevaPantalla;
    }
    
    public double getTemperatura() {
        return temperatura;
    }
    
    public String getCiudad() {
        return ciudad;
    }
}