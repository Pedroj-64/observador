package co.edu.uniquindio.poo.observer2;

public class Principal {
    public static void main(String[] args) {
        // Crear la estación meteorológica (sujeto)
        EstacionMetereologica estacion = new EstacionMetereologica();

        // Crear observadores
        Observador pantallaTemp = new PantallaTemperatura();
        Observador pantallaCond = new PantallaCondiciones();
        Observador appMovil = new AplicacionMovilClima();

        // Agregar los observadores a la estación
        estacion.agregarObservador(pantallaTemp);
        estacion.agregarObservador(pantallaCond);
        estacion.agregarObservador(appMovil);

        // Simular cambios en el clima
        estacion.setDatosClima(25.3f, 60.5f, 1013.1f);
        estacion.setDatosClima(27.8f, 55.2f, 1012.8f);

        // Quitar una pantalla
        estacion.eliminarObservador(pantallaTemp);

        // Nuevo cambio de clima
        estacion.setDatosClima(29.0f, 50.0f, 1010.0f);
    }
}

