package co.edu.uniquindio.poo.observer7;

/**
 * Demostración de Observer genérico con diferentes tipos de datos
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN OBSERVER GENÉRICO ===\n");
        
        // ====== EJEMPLO 1: OBSERVADOR DE TEMPERATURA ======
        System.out.println("┌" + "─".repeat(58) + "┐");
        System.out.println("│ EJEMPLO 1: Estación Meteorológica (DatosTemperatura)    │");
        System.out.println("└" + "─".repeat(58) + "┘\n");
        
        SujetoGenerico<DatosTemperatura> estacionMeteo = new SujetoGenerico<>();
        
        ObservadorTemperatura display1 = new ObservadorTemperatura("Display Principal", 30.0);
        ObservadorTemperatura display2 = new ObservadorTemperatura("Display Secundario", 35.0);
        ObservadorGenerico<DatosTemperatura> logger = new ObservadorGenerico<>("Logger Temperatura");
        
        estacionMeteo.agregarObservador(display1);
        estacionMeteo.agregarObservador(display2);
        estacionMeteo.agregarObservador(logger);
        
        estacionMeteo.setEstado(new DatosTemperatura(28.5, 65.0, 1013.2));
        estacionMeteo.setEstado(new DatosTemperatura(32.0, 85.0, 1011.5));
        
        // ====== EJEMPLO 2: OBSERVADOR DE BOLSA ======
        System.out.println("\n┌" + "─".repeat(58) + "┐");
        System.out.println("│ EJEMPLO 2: Mercado de Valores (DatosBolsa)              │");
        System.out.println("└" + "─".repeat(58) + "┘\n");
        
        SujetoGenerico<DatosBolsa> mercado = new SujetoGenerico<>();
        
        ObservadorBolsa trader1 = new ObservadorBolsa("Trader Pro", 5.0);
        ObservadorBolsa trader2 = new ObservadorBolsa("Trader Conservative", 2.0);
        ObservadorGenerico<DatosBolsa> analytics = new ObservadorGenerico<>("Analytics System");
        
        mercado.agregarObservador(trader1);
        mercado.agregarObservador(trader2);
        mercado.agregarObservador(analytics);
        
        mercado.setEstado(new DatosBolsa("AAPL", 175.50, 1.2, 850000));
        mercado.setEstado(new DatosBolsa("GOOGL", 140.25, -6.5, 1500000));
        
        // ====== EJEMPLO 3: OBSERVADOR DE STRINGS ======
        System.out.println("\n┌" + "─".repeat(58) + "┐");
        System.out.println("│ EJEMPLO 3: Sistema de Mensajes (String)                 │");
        System.out.println("└" + "─".repeat(58) + "┘\n");
        
        SujetoGenerico<String> chat = new SujetoGenerico<>();
        
        ObservadorGenerico<String> usuario1 = new ObservadorGenerico<>("Usuario-1");
        ObservadorGenerico<String> usuario2 = new ObservadorGenerico<>("Usuario-2");
        
        chat.agregarObservador(usuario1);
        chat.agregarObservador(usuario2);
        
        chat.setEstado("¡Hola a todos!");
        chat.setEstado("Reunión en 10 minutos");
        
        // ====== EJEMPLO 4: OBSERVADOR DE ENTEROS ======
        System.out.println("\n┌" + "─".repeat(58) + "┐");
        System.out.println("│ EJEMPLO 4: Contador de Eventos (Integer)                │");
        System.out.println("└" + "─".repeat(58) + "┘\n");
        
        SujetoGenerico<Integer> contador = new SujetoGenerico<>();
        
        Observador<Integer> monitor = new Observador<Integer>() {
            @Override
            public void actualizar(Integer dato) {
                System.out.println("  → Contador: " + dato + 
                                 (dato > 100 ? " ⚠️  Límite superado!" : ""));
            }
            
            @Override
            public String getId() {
                return "Monitor de Contador";
            }
        };
        
        contador.agregarObservador(monitor);
        contador.setEstado(50);
        contador.setEstado(100);
        contador.setEstado(150);
        
        // ====== RESUMEN ======
        System.out.println("\n" + "=".repeat(60));
        System.out.println("VENTAJAS DEL OBSERVER GENÉRICO:");
        System.out.println("✓ Type safety en tiempo de compilación");
        System.out.println("✓ Reutilizable para cualquier tipo de dato");
        System.out.println("✓ Reduce duplicación de código");
        System.out.println("✓ Más flexible y mantenible");
        System.out.println("✓ Compatible con tipos primitivos y objetos complejos");
        System.out.println("=".repeat(60));
    }
}
