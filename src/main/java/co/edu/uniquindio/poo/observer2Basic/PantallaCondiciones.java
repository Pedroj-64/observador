package co.edu.uniquindio.poo.observer2Basic;

public class PantallaCondiciones implements Observador {

    @Override
    public void actualizar(float temperatura, float humedad, float presion) {
        System.out.println(" Condiciones actuales: " + temperatura + "C, " + humedad + "% de humedad, " + presion + " hPa");
    }
}

