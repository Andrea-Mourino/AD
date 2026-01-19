package org.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Indica que esta clase es de configuración en Spring
@Configuration
public class OpenApiConfig {

    // Inyecta la versión de la aplicación desde application.properties o application.yml
    @Value("${app.version}")
    private String version;

    // Inyecta el nombre de la aplicación; si no existe, usa "nome" por defecto
    @Value("${spring.application.name:nome}")
    private String appName;

    // URL para acceder a la interfaz Swagger UI
    // http://localhost:8080/swagger-ui/swagger-ui/index.html
    @Bean
    public OpenAPI customOpenAPI() {

        // Configura y devuelve el objeto OpenAPI con la información básica de la API
        return new OpenAPI()
                .info(new Info().title(appName)               // Título de la API
                        .description("API service in Swagger framework") // Descripción
                        .version(version)                    // Versión de la API
                );
    }
}
