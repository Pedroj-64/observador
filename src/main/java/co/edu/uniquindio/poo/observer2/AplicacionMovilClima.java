package co.edu.uniquindio.poo.observer2;

public class AplicacionMovilClima implements Observador {

    @Override
    public void actualizar(float temperatura, float humedad, float presion) {
        System.out.println("aplicacion movil - Nueva lectura del clima: " + temperatura + "C, " + humedad + "% de humedad, " + presion + " hPa");
    }
}

