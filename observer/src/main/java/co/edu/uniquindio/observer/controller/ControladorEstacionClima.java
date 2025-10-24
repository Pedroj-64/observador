package co.edu.uniquindio.observer.controller;

import co.edu.uniquindio.observer.model.EstacionClima;
import co.edu.uniquindio.observer.model.PantallaTemperatura;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de capa de negocio (Business Logic Layer)
 * Aplica Facade Pattern para simplificar la interacción entre Vista y Modelo
 * Aplica Single Responsibility Principle - Coordina las operaciones del negocio
 */
public class ControladorEstacionClima {
    
    private static ControladorEstacionClima instancia;
    private EstacionClima estacionClima;
    private List<PantallaTemperatura> pantallas;
    
    /**
     * Constructor privado para Singleton
     */
    private ControladorEstacionClima() {
        this.estacionClima = new EstacionClima("Armenia, Quindío");
        this.pantallas = new ArrayList<>();
        inicializarPantallas();
    }
    
    /**
     * Obtiene la instancia única del controlador (Singleton Pattern)
     * @return Instancia única del controlador
     */
    public static ControladorEstacionClima obtenerInstancia() {
        if (instancia == null) {
            instancia = new ControladorEstacionClima();
        }
        return instancia;
    }
    
    /**
     * Inicializa las pantallas observadoras
     */
    private void inicializarPantallas() {
        PantallaTemperatura pantalla1 = new PantallaTemperatura("Pantalla Principal");
        PantallaTemperatura pantalla2 = new PantallaTemperatura("Pantalla Secundaria");
        PantallaTemperatura pantalla3 = new PantallaTemperatura("Pantalla Móvil");
        
        agregarPantalla(pantalla1);
        agregarPantalla(pantalla2);
        agregarPantalla(pantalla3);
    }
    
    /**
     * Agrega una pantalla como observadora de la estación
     * @param pantalla Pantalla a agregar
     */
    public void agregarPantalla(PantallaTemperatura pantalla) {
        if (!pantallas.contains(pantalla)) {
            pantallas.add(pantalla);
            estacionClima.agregarObservador(pantalla);
        }
    }
    
    /**
     * Elimina una pantalla de los observadores
     * @param pantalla Pantalla a eliminar
     */
    public void eliminarPantalla(PantallaTemperatura pantalla) {
        if (pantallas.remove(pantalla)) {
            estacionClima.eliminarObservador(pantalla);
        }
    }
    
    /**
     * Actualiza la temperatura en la estación (simula lectura del sensor)
     * @param temperatura Nueva temperatura a registrar
     */
    public void actualizarTemperatura(double temperatura) {
        estacionClima.establecerTemperatura(temperatura);
    }
    
    /**
     * Obtiene la temperatura actual
     * @return Temperatura actual
     */
    public double obtenerTemperaturaActual() {
        return estacionClima.getTemperatura();
    }
    
    /**
     * Obtiene el nombre de la ciudad
     * @return Nombre de la ciudad
     */
    public String obtenerCiudad() {
        return estacionClima.getCiudad();
    }
    
    /**
     * Obtiene todas las pantallas registradas
     * @return Lista de pantallas
     */
    public List<PantallaTemperatura> obtenerPantallas() {
        return new ArrayList<>(pantallas);
    }
    
    /**
     * Obtiene la cantidad de observadores activos
     * @return Cantidad de observadores
     */
    public int obtenerCantidadObservadores() {
        return estacionClima.getCantidadObservadores();
    }
}
