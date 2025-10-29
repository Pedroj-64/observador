package co.edu.uniquindio.poo.observer8;

/**
 * Observador que cuenta las actualizaciones recibidas
 */
public class ObservadorConContador implements Observador {
    private final String id;
    private int contadorActualizaciones = 0;
    private String ultimoEstado;
    
    public ObservadorConContador(String id) {
        this.id = id;
    }
    
    @Override
    public void actualizar(String dato) {
        contadorActualizaciones++;
        ultimoEstado = dato;
        System.out.println("  → " + id + " recibió actualización #" + 
                         contadorActualizaciones + ": " + dato);
    }
    
    @Override
    public String getId() {
        return id;
    }
    
    public int getContadorActualizaciones() {
        return contadorActualizaciones;
    }
    
    public String getUltimoEstado() {
        return ultimoEstado;
    }
}
