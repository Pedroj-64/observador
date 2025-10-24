package co.edu.uniquindio.observer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Concrete Subject del patrón Observer
 * Representa una estación meteorológica que notifica cambios de temperatura
 * Aplica Single Responsibility Principle (SRP) - Solo maneja la lógica del observable
 */
public class EstacionClima implements SujetoObservable {
    
    private List<ObservadorTemperatura> observadores;
    private double temperatura;
    private String ciudad;
    
    /**
     * Constructor de la estación de clima
     * @param ciudad Nombre de la ciudad donde está ubicada la estación
     */
    public EstacionClima(String ciudad) {
        this.observadores = new ArrayList<>();
        this.ciudad = ciudad;
        this.temperatura = 0.0;
    }
    
    @Override
    public void agregarObservador(ObservadorTemperatura observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
            System.out.println("✓ Nuevo observador agregado. Total: " + observadores.size());
        }
    }
    
    @Override
    public void eliminarObservador(ObservadorTemperatura observador) {
        if (observadores.remove(observador)) {
            System.out.println("✓ Observador eliminado. Total: " + observadores.size());
        }
    }
    
    @Override
    public void notificarObservadores() {
        System.out.println("📢 Notificando a " + observadores.size() + " observadores...");
        for (ObservadorTemperatura observador : observadores) {
            observador.actualizar(temperatura, ciudad);
        }
    }
    
    /**
     * Actualiza la temperatura y notifica a los observadores
     * @param nuevaTemperatura Nueva temperatura registrada
     */
    public void establecerTemperatura(double nuevaTemperatura) {
        System.out.println("\n🌡️ Nueva temperatura registrada: " + nuevaTemperatura + "°C en " + ciudad);
        this.temperatura = nuevaTemperatura;
        notificarObservadores();
    }
    
    public double getTemperatura() {
        return temperatura;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public int getCantidadObservadores() {
        return observadores.size();
    }
}
