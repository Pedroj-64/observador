package co.edu.uniquindio.poo.observer3ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demostración de Observer Thread-Safe con múltiples hilos
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN OBSERVER THREAD-SAFE ===\n");
        
        SujetoThreadSafe sujeto = new SujetoThreadSafe();
        
        // Crear observadores
        ObservadorConcreto obs1 = new ObservadorConcreto("Observador-1");
        ObservadorConcreto obs2 = new ObservadorConcreto("Observador-2");
        ObservadorConcreto obs3 = new ObservadorConcreto("Observador-3");
        
        // Agregar observadores
        sujeto.agregarObservador(obs1);
        sujeto.agregarObservador(obs2);
        sujeto.agregarObservador(obs3);
        
        // Crear pool de hilos para simular concurrencia
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        System.out.println("\n--- Probando notificaciones concurrentes ---");
        
        // Múltiples hilos cambiando el estado simultáneamente
        for (int i = 1; i <= 5; i++) {
            final int numero = i;
            executor.submit(() -> {
                sujeto.setEstado("Estado " + numero);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        // Agregar y eliminar observadores concurrentemente
        executor.submit(() -> {
            ObservadorConcreto obs4 = new ObservadorConcreto("Observador-4");
            sujeto.agregarObservador(obs4);
        });
        
        executor.submit(() -> {
            try {
                Thread.sleep(200);
                sujeto.eliminarObservador(obs2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Apagar el executor y esperar que termine
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n--- Estado final ---");
        System.out.println("Observadores registrados: " + sujeto.getObservadores().size());
        sujeto.getObservadores().forEach(obs -> 
            System.out.println("  - " + obs.getNombre())
        );
    }
}
