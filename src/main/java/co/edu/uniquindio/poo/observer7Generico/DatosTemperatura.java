package co.edu.uniquindio.poo.observer7Generico;

/**
 * Clase que representa datos de temperatura
 */
public class DatosTemperatura {
    private final double temperatura;
    private final double humedad;
    private final double presion;
    private final long timestamp;
    
    public DatosTemperatura(double temperatura, double humedad, double presion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = presion;
        this.timestamp = System.currentTimeMillis();
    }
    
    public double getTemperatura() {
        return temperatura;
    }
    
    public double getHumedad() {
        return humedad;
    }
    
    public double getPresion() {
        return presion;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return String.format("Temp: %.1f°C, Humedad: %.1f%%, Presión: %.1f hPa", 
                           temperatura, humedad, presion);
    }
}
