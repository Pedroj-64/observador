package co.edu.uniquindio.poo.observer7Generico;

/**
 * Clase que representa datos de la bolsa de valores
 */
public class DatosBolsa {
    private final String simbolo;
    private final double precio;
    private final double cambio;
    private final long volumen;
    
    public DatosBolsa(String simbolo, double precio, double cambio, long volumen) {
        this.simbolo = simbolo;
        this.precio = precio;
        this.cambio = cambio;
        this.volumen = volumen;
    }
    
    public String getSimbolo() {
        return simbolo;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public double getCambio() {
        return cambio;
    }
    
    public long getVolumen() {
        return volumen;
    }
    
    @Override
    public String toString() {
        return String.format("%s: $%.2f (%+.2f%%) Vol: %,d", 
                           simbolo, precio, cambio, volumen);
    }
}
