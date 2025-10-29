package co.edu.uniquindio.poo.observer9Polling;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Observador simple con timestamp
 */
public class ObservadorSimple implements Observador {
    private final String id;
    private int actualizacionesRecibidas = 0;
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    public ObservadorSimple(String id) {
        this.id = id;
    }
    
    @Override
    public void actualizar(String dato) {
        actualizacionesRecibidas++;
        String hora = LocalTime.now().format(FORMATO_HORA);
        System.out.println("  → [" + hora + "] " + id + 
                         " recibió actualización #" + actualizacionesRecibidas + 
                         ": " + dato);
    }
    
    @Override
    public String getId() {
        return id;
    }
    
    public int getActualizacionesRecibidas() {
        return actualizacionesRecibidas;
    }
}
