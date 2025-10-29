package co.edu.uniquindio.poo.observer9Polling;

/**
 * Demostración de Observer con Polling
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN OBSERVER CON POLLING ===\n");
        
        // Crear sujeto con polling cada 2 segundos
        SujetoConPolling sensor = new SujetoConPolling(2);
        
        ObservadorSimple display = new ObservadorSimple("Display Principal");
        ObservadorSimple logger = new ObservadorSimple("Sistema de Logs");
        ObservadorSimple alerta = new ObservadorSimple("Sistema de Alertas");
        
        sensor.agregarObservador(display);
        sensor.agregarObservador(logger);
        sensor.agregarObservador(alerta);
        
        // ====== DEMOSTRACIÓN DE POLLING ======
        System.out.println("\n" + "═".repeat(60));
        System.out.println("PRUEBA 1: Polling Automático");
        System.out.println("═".repeat(60));
        
        sensor.iniciarPolling();
        
        try {
            // Cambio 1
            Thread.sleep(1000);
            sensor.setEstado("Temperatura: 25°C");
            
            // Esperar el poll
            Thread.sleep(3000);
            
            // Cambio 2
            sensor.setEstado("Temperatura: 28°C");
            
            // Esperar el poll
            Thread.sleep(3000);
            
            // Cambio 3 (sin cambio real)
            sensor.setEstado("Temperatura: 28°C"); // Mismo valor
            
            // Esperar el poll
            Thread.sleep(3000);
            
            // Cambio 4
            sensor.setEstado("Temperatura: 30°C");
            
            Thread.sleep(3000);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        sensor.detenerPolling();
        
        // ====== NOTIFICACIÓN INMEDIATA ======
        System.out.println("\n" + "═".repeat(60));
        System.out.println("PRUEBA 2: Notificación Inmediata (sin esperar poll)");
        System.out.println("═".repeat(60));
        
        sensor.setEstado("ALERTA: Temperatura crítica 35°C");
        sensor.notificarInmediato(); // Fuerza notificación sin esperar
        
        // ====== CAMBIO DE INTERVALO ======
        System.out.println("\n" + "═".repeat(60));
        System.out.println("PRUEBA 3: Cambio de Intervalo de Polling");
        System.out.println("═".repeat(60));
        
        sensor.setIntervaloPolling(1); // Cambiar a 1 segundo
        sensor.iniciarPolling();
        
        try {
            Thread.sleep(1500);
            sensor.setEstado("Temperatura: 22°C");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        sensor.detenerPolling();
        
        // ====== ESTADÍSTICAS ======
        System.out.println("\n" + "═".repeat(60));
        System.out.println("ESTADÍSTICAS FINALES");
        System.out.println("═".repeat(60));
        System.out.println("Total de polls ejecutados: " + sensor.getContadorPolls());
        System.out.println("Display recibió: " + display.getActualizacionesRecibidas() + " notificaciones");
        System.out.println("Logger recibió: " + logger.getActualizacionesRecibidas() + " notificaciones");
        System.out.println("Alertas recibió: " + alerta.getActualizacionesRecibidas() + " notificaciones");
        
        // ====== COMPARACIÓN: PUSH vs PULL (POLLING) ======
        System.out.println("\n" + "═".repeat(60));
        System.out.println("PUSH (Observer tradicional) vs PULL (Polling)");
        System.out.println("═".repeat(60));
        System.out.println("\nPUSH (Notificación Inmediata):");
        System.out.println("  ✓ Respuesta inmediata a cambios");
        System.out.println("  ✓ Menor latencia");
        System.out.println("  ✗ Mayor acoplamiento");
        System.out.println("  ✗ Puede sobrecargar si hay muchos cambios");
        
        System.out.println("\nPULL (Polling):");
        System.out.println("  ✓ Menor acoplamiento");
        System.out.println("  ✓ Control sobre frecuencia de actualización");
        System.out.println("  ✓ Evita sobrecarga con cambios frecuentes");
        System.out.println("  ✗ Mayor latencia");
        System.out.println("  ✗ Puede desperdiciar recursos verificando sin cambios");
        System.out.println("═".repeat(60));
    }
}
