package org.example;

// Importa los servicios de Pais y Presidente
import org.codewith.practica2_mongodb.service.PaisService;
import org.codewith.practica2_mongodb.service.PresidenteService;

// Importa anotaciones de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

// Marca la clase como un servicio de Spring
@Service
public class Secuencia {

    // Inyecta el servicio de Presidentes automáticamente
    @Autowired
    private PresidenteService presidenteService;

    // Inyecta el servicio de Países automáticamente
    @Autowired
    private PaisService paisService;

    // Método que ejecuta toda la secuencia de la aplicación
    public void ejecutar()  {

        // Borra todos los países y presidentes antes de empezar
        paisService.borrarPasises();
        presidenteService.borrarPresidentes();

        System.out.println("--- Importar datos desde JSON ---");
        try {
            // Importa presidentes y países desde archivos JSON en resources
            presidenteService.importarDesdeJSON("presidentes.json");
            paisService.importarDesdeJSON("paises.json");
        } catch (IOException e) {
            // Si falla la lectura de JSON, lanza excepción
            throw new RuntimeException(e);
        }

        System.out.println("--- Mostrar datos ---");
        // Lista e imprime todos los presidentes y países importados
        presidenteService.listarPresidentes();
        paisService.listarPaises();

        System.out.println("--- Modificar datos ---");
        // Modifica la organización de un país específico
        paisService.modificarOrganizacionPais("pais3", "ASDESA");

        System.out.println("--- Mostrar datos modificados ---");
        // Muestra los países después de la modificación
        paisService.listarPaises();

        System.out.println("--- Eliminar datos ---");
        // Borra todos los datos de la base de datos
        paisService.borrarPasises();
        presidenteService.borrarPresidentes();

        System.out.println("--- Mostrar datos despues de eliminar todo---");
        // Lista los datos para verificar que la base quedó vacía
        presidenteService.listarPresidentes();
        paisService.listarPaises();
    }
}
