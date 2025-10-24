package co.edu.uniquindio.observer.viewcontroller;

import co.edu.uniquindio.observer.controller.ControladorEstacionClima;
import co.edu.uniquindio.observer.model.PantallaTemperatura;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.List;

/**
 * Controlador de Vista JavaFX (View Controller)
 * Maneja la interacción entre la interfaz gráfica y el controlador de negocio
 * Aplica Dependency Inversion Principle - Depende de abstracciones (controlador de negocio)
 */
public class ControladorVistaEstacion {
    
    @FXML
    private Label labelCiudad;
    
    @FXML
    private Label labelTemperaturaActual;
    
    @FXML
    private Label labelCantidadObservadores;
    
    @FXML
    private TextField campoNuevaTemperatura;
    
    @FXML
    private Button botonActualizarTemperatura;
    
    @FXML
    private TextArea areaEstadoPantallas;
    
    private ControladorEstacionClima controladorNegocio;
    
    /**
     * Método de inicialización de JavaFX
     */
    @FXML
    public void initialize() {
        controladorNegocio = ControladorEstacionClima.obtenerInstancia();
        actualizarVista();
    }
    
    /**
     * Maneja el evento de actualizar temperatura
     */
    @FXML
    private void manejarActualizarTemperatura() {
        try {
            String textoTemperatura = campoNuevaTemperatura.getText().trim();
            
            if (textoTemperatura.isEmpty()) {
                mostrarAlerta("Error", "Por favor ingrese una temperatura", AlertType.WARNING);
                return;
            }
            
            double nuevaTemperatura = Double.parseDouble(textoTemperatura);
            
            if (nuevaTemperatura < -50 || nuevaTemperatura > 60) {
                mostrarAlerta("Error", "Temperatura fuera de rango (-50°C a 60°C)", AlertType.WARNING);
                return;
            }
            
            // Actualizar temperatura a través del controlador de negocio
            controladorNegocio.actualizarTemperatura(nuevaTemperatura);
            
            // Actualizar la vista
            actualizarVista();
            
            // Limpiar campo
            campoNuevaTemperatura.clear();
            
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor ingrese un número válido", AlertType.ERROR);
        }
    }
    
    /**
     * Actualiza todos los elementos de la vista
     */
    private void actualizarVista() {
        // Actualizar labels
        labelCiudad.setText("📍 " + controladorNegocio.obtenerCiudad());
        labelTemperaturaActual.setText(String.format("%.1f°C", 
                                       controladorNegocio.obtenerTemperaturaActual()));
        labelCantidadObservadores.setText(String.valueOf(
                                          controladorNegocio.obtenerCantidadObservadores()));
        
        // Actualizar área de pantallas
        actualizarEstadoPantallas();
    }
    
    /**
     * Actualiza el área de texto con el estado de todas las pantallas
     */
    private void actualizarEstadoPantallas() {
        StringBuilder estado = new StringBuilder();
        estado.append("═══════════════════════════════════════\n");
        estado.append("    ESTADO DE PANTALLAS OBSERVADORAS\n");
        estado.append("═══════════════════════════════════════\n\n");
        
        List<PantallaTemperatura> pantallas = controladorNegocio.obtenerPantallas();
        
        for (int i = 0; i < pantallas.size(); i++) {
            PantallaTemperatura pantalla = pantallas.get(i);
            estado.append("📺 ").append(i + 1).append(". ");
            estado.append(pantalla.obtenerInformacionFormateada());
            estado.append("\n");
        }
        
        if (pantallas.isEmpty()) {
            estado.append("   No hay pantallas observadoras\n");
        }
        
        estado.append("\n═══════════════════════════════════════");
        areaEstadoPantallas.setText(estado.toString());
    }
    
    /**
     * Muestra una alerta al usuario
     */
    private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
