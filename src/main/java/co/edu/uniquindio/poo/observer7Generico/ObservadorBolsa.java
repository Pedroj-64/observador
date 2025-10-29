package co.edu.uniquindio.poo.observer7Generico;

/**
 * Observador específico para datos de la bolsa
 */
public class ObservadorBolsa implements Observador<DatosBolsa> {
    private final String id;
    private final double umbralCambio;
    
    public ObservadorBolsa(String id, double umbralCambio) {
        this.id = id;
        this.umbralCambio = umbralCambio;
    }
    
    @Override
    public void actualizar(DatosBolsa dato) {
        System.out.println("  → " + id + " recibió: " + dato);
        
        if (Math.abs(dato.getCambio()) > umbralCambio) {
            String direccion = dato.getCambio() > 0 ? " ALZA" : " BAJA";
            System.out.println("    " + direccion + " SIGNIFICATIVA: " + 
                             String.format("%.2f%%", Math.abs(dato.getCambio())));
        }
        
        if (dato.getVolumen() > 1000000) {
            System.out.println(" Alto volumen de transacciones");
        }
    }
    
    @Override
    public String getId() {
        return id;
    }
}
