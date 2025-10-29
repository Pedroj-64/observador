package co.edu.uniquindio.poo.observer1Basic;

public class Principal {
    public static void main(String[] args) {
        // Creamos el canal
        CanalYoutube canal = new CanalYoutube();

        // Creamos los suscriptores
        Suscriptor s1 = new Suscriptor("Ana");
        Suscriptor s2 = new Suscriptor("Carlos");
        Suscriptor s3 = new Suscriptor("Luisa");

        // Los agregamos al canal
        canal.agregar(s1);
        canal.agregar(s2);
        canal.agregar(s3);

        // Subimos un video nuevo
        canal.subirVideo("Aprende Java paso a paso");

        // Carlos se desuscribe
        canal.eliminar(s2);

        // Subimos otro video
        canal.subirVideo("Patrón Observer explicado fácil");
    }
}
