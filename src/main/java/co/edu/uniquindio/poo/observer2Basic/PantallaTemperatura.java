package co.edu.uniquindio.poo.observer2Basic;

public class PantallaTemperatura implements Observador {

    @Override
    public void actualizar(float temperatura, float humedad, float presion) {
        System.out.println(" Temperatura actual: " + temperatura + "C");
    }
}

