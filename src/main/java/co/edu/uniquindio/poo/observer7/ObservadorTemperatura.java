package co.edu.uniquindio.poo.observer7;

/**
 * Observador específico para datos de temperatura
 */
public class ObservadorTemperatura implements Observador<DatosTemperatura> {
    private final String id;
    private final double umbralAlerta;
    
    public ObservadorTemperatura(String id, double umbralAlerta) {
        this.id = id;
        this.umbralAlerta = umbralAlerta;
    }
    
    @Override
    public void actualizar(DatosTemperatura dato) {
        System.out.println("  → " + id + " recibió: " + dato);
        
        if (dato.getTemperatura() > umbralAlerta) {
            System.out.println("    ⚠️  ALERTA: Temperatura excede " + umbralAlerta + "°C");
        }
        
        if (dato.getHumedad() > 80) {
            System.out.println("    💧 INFO: Alta humedad detectada");
        }
    }
    
    @Override
    public String getId() {
        return id;
    }
}
