package org.example.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

// Importa anotaciones de Spring
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Indica que esta clase es una clase de configuración de Spring
@Configuration
public class MongoConfig {

    // Inyecta el valor de la propiedad spring.data.mongodb.uri desde application.properties o application.yml
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    // Define un bean de tipo MongoClient para que Spring lo gestione
    @Bean
    public MongoClient mongoClient() {
        try {
            // Crea y devuelve el cliente de MongoDB usando la URI configurada
            return MongoClients.create(mongoUri);
        } catch (Exception e) {
            // Si ocurre un error, lanza una excepción indicando que falló la creación del cliente
            throw new RuntimeException("Failed to create MongoClient", e);
        }
    }

}
