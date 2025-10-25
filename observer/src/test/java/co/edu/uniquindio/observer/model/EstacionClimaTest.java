package co.edu.uniquindio.observer.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

/**
 * Pruebas unitarias para el patrón Observer
 * Verifica:
 * 1. Contrato de la interfaz Observer
 * 2. Invariantes del patrón
 * 3. Polimorfismo
 * 4. Composición
 */
public class EstacionClimaTest {
    
    private EstacionClima estacion;
    private PantallaTemperatura pantallaPrincipal;
    private PantallaTemperatura pantallaSecundaria;
    
    @BeforeEach
    void setUp() {
        estacion = new EstacionClima("Armenia");
        pantallaPrincipal = new PantallaTemperatura("Pantalla Principal");
        pantallaSecundaria = new PantallaTemperatura("Pantalla Secundaria");
    }
    
    @Nested
    @DisplayName("Pruebas del contrato de la interfaz Observer")
    class ContratoObserverTest {
        
        @Test
        @DisplayName("Un observador puede ser agregado una sola vez")
        void observadorAgregadoUnaVez() {
            estacion.agregarObservador(pantallaPrincipal);
            estacion.agregarObservador(pantallaPrincipal); // Intentar agregar el mismo observador
            assertEquals(1, estacion.getCantidadObservadores(), 
                "Un observador no debe ser agregado más de una vez");
        }
        
        @Test
        @DisplayName("No se puede agregar un observador nulo")
        void noPermiteObservadorNulo() {
            estacion.agregarObservador(null);
            assertEquals(0, estacion.getCantidadObservadores(), 
                "No se debe permitir agregar un observador nulo");
        }
        
        @Test
        @DisplayName("Eliminar un observador lo remueve de la lista")
        void eliminarObservador() {
            estacion.agregarObservador(pantallaPrincipal);
            estacion.eliminarObservador(pantallaPrincipal);
            assertEquals(0, estacion.getCantidadObservadores(), 
                "El observador debe ser eliminado correctamente");
        }
    }
    
    @Nested
    @DisplayName("Pruebas de invariantes del patrón")
    class InvariantesTest {
        
        @Test
        @DisplayName("La temperatura inicial es 0.0")
        void temperaturaInicial() {
            assertEquals(0.0, estacion.getTemperatura(), 
                "La temperatura inicial debe ser 0.0");
        }
        
        @Test
        @DisplayName("La ciudad no puede cambiar después de la creación")
        void ciudadInmutable() {
            String ciudadInicial = estacion.getCiudad();
            estacion.establecerTemperatura(25.0); // Operación que no debe afectar la ciudad
            assertEquals(ciudadInicial, estacion.getCiudad(), 
                "La ciudad no debe cambiar después de la creación");
        }
    }
    
    @Nested
    @DisplayName("Pruebas de polimorfismo")
    class PolimorfismoTest {
        
        @Test
        @DisplayName("Diferentes tipos de observadores pueden ser notificados")
        void diferentesTiposObservadores() {
            // Crear un observador anónimo con comportamiento diferente
            ObservadorTemperatura observadorPersonalizado = new ObservadorTemperatura() {
                private double ultimaTemperatura;
                
                @Override
                public void actualizar(double temperatura, String ciudad) {
                    this.ultimaTemperatura = temperatura;
                }
                
                public double getUltimaTemperatura() {
                    return ultimaTemperatura;
                }
            };
            
            estacion.agregarObservador(observadorPersonalizado);
            estacion.agregarObservador(pantallaPrincipal);
            
            double nuevaTemperatura = 25.0;
            estacion.establecerTemperatura(nuevaTemperatura);
            
            assertEquals(2, estacion.getCantidadObservadores(), 
                "Debe poder manejar diferentes tipos de observadores");
        }
    }
    
    @Nested
    @DisplayName("Pruebas de composición")
    class ComposicionTest {
        
        @Test
        @DisplayName("Los observadores pueden ser agregados y eliminados dinámicamente")
        void composicionDinamica() {
            estacion.agregarObservador(pantallaPrincipal);
            assertEquals(1, estacion.getCantidadObservadores());
            
            estacion.agregarObservador(pantallaSecundaria);
            assertEquals(2, estacion.getCantidadObservadores());
            
            estacion.eliminarObservador(pantallaPrincipal);
            assertEquals(1, estacion.getCantidadObservadores());
            
            estacion.eliminarObservador(pantallaSecundaria);
            assertEquals(0, estacion.getCantidadObservadores());
        }
        
        @Test
        @DisplayName("La estación notifica a todos sus observadores")
        void notificacionMultiplesObservadores() {
            // Crear observadores que cuentan notificaciones
            ContadorNotificaciones obs1 = new ContadorNotificaciones();
            ContadorNotificaciones obs2 = new ContadorNotificaciones();
            
            estacion.agregarObservador(obs1);
            estacion.agregarObservador(obs2);
            
            estacion.establecerTemperatura(30.0);
            
            assertEquals(1, obs1.getNotificaciones(), 
                "Primer observador debe recibir una notificación");
            assertEquals(1, obs2.getNotificaciones(), 
                "Segundo observador debe recibir una notificación");
        }
    }
    
    // Clase auxiliar para pruebas
    private class ContadorNotificaciones implements ObservadorTemperatura {
        private int notificaciones = 0;
        
        @Override
        public void actualizar(double temperatura, String ciudad) {
            notificaciones++;
        }
        
        public int getNotificaciones() {
            return notificaciones;
        }
    }
}