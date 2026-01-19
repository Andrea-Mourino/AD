package org.example;

// Importa PostConstruct para ejecutar código después de que Spring inicialice los beans
import jakarta.annotation.PostConstruct;

// Importa clases de Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Marca la clase como la aplicación principal de Spring Boot
@SpringBootApplication
public class Practica2Mongodb {

    // Bean que contiene la secuencia de ejecución principal de la aplicación
    private final org.codewith.practica2_mongodb.Secuencia secuencia;

    // Constructor para inyectar la secuencia (inyección de dependencias)
    public Practica2Mongodb(org.codewith.practica2_mongodb.Secuencia secuencia) {
        this.secuencia = secuencia;
    }

    // Método que se ejecuta automáticamente después de que Spring inicializa todos los beans
    @PostConstruct
    public void ejecutarSolucion() {
        // Llama al método ejecutar() de la secuencia para iniciar la lógica de la aplicación
        secuencia.ejecutar();

        // System.exit(200); // Comentado para no detener el proceso durante pruebas
    }

    // Método principal que arranca la aplicación Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(Practica2Mongodb.class, args);
    }

}
