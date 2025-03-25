package prueba;


import prueba.webservice.VentaWebService;
import jakarta.xml.ws.Endpoint;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String url = "http://localhost:8080/ventas";

        try {
            Endpoint endpoint = Endpoint.publish(url, new VentaWebService());
            if (endpoint.isPublished()) {
                System.out.println(" Servicio web publicado correctamente en: " + url);
                System.out.println("Presiona ENTER para detener el servicio...");
                new Scanner(System.in).nextLine();  // Mantiene el servicio activo hasta que el usuario presione ENTER
                endpoint.stop();
                System.out.println(" Servicio detenido.");
            } else {
                System.err.println(" Error al publicar el servicio.");
            }
        } catch (Exception e) {
            System.err.println(" Error crítico al iniciar el servicio: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
