package org.example.service;

// Importa Gson para manejar JSON
import com.google.gson.Gson;
// Importa la clase Pais (modelo)
import org.codewith.practica2_mongodb.model.Pais;
// Importa el repositorio PaisRepository
import org.codewith.practica2_mongodb.repository.PaisRepository;
// Para leer archivos desde el classpath
import org.springframework.core.io.ClassPathResource;
// Anotación de Spring para marcar esta clase como un servicio
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

// Marca la clase como un servicio de Spring (gestiona la lógica de negocio)
@Service
public class PaisService {

    // Repositorio para interactuar con la base de datos de países
    private final PaisRepository paisRepo;

    // Constructor para inyectar el repositorio (inyección de dependencias)
    public PaisService(PaisRepository paisRepo) {
        this.paisRepo = paisRepo;
    }

    // Crear un nuevo país en la base de datos
    public void crearPais(Pais pais) {
        paisRepo.save(pais);
    }

    // Obtener todos los países de la base de datos
    public List<Pais> buscarPaises() {
        return paisRepo.findAll();
    }

    // Importar una lista de países desde un archivo JSON en resources
    public List<Pais> importarDesdeJSON(String ruta) throws IOException {
        // Se abre el archivo usando ClassPathResource (archivo dentro de resources)
        try (Reader reader = new InputStreamReader(new ClassPathResource(ruta).getInputStream())) {
            // Define el tipo de la lista de países para Gson
            Type listType = new com.google.gson.reflect.TypeToken<List<Pais>>() {}.getType();
            // Convierte el JSON en lista de objetos Pais
            List<Pais> list_pais = new Gson().fromJson(reader, listType);
            // Guarda todos los países en la base de datos y retorna la lista guardada
            return paisRepo.saveAll(list_pais);
        }
    }

    // Modificar la organización de un país específico
    public void modificarOrganizacionPais(String idPais, String nuevaOrganizacion) {
        // Busca el país por su ID
        Pais pais = paisRepo.findById(idPais).orElse(null);
        if (pais != null) {
            // Actualiza el campo organizacion
            pais.setOrganizacion(nuevaOrganizacion);
            // Guarda el país modificado (update en la base de datos)
            paisRepo.save(pais);
            System.out.println("País actualizado: " + pais.getNome());
        } else {
            // Mensaje si no se encontró el país
            System.out.println("No se encontró el país con ID: " + idPais);
        }
    }

    // Borrar todos los países de la base de datos
    public void borrarPasises() {
        paisRepo.deleteAll();
    }

    // Listar todos los países e imprimirlos por consola
    public List<Pais> listarPaises() {
        List<Pais> lista = paisRepo.findAll();
        System.out.println("--- Lista de Paises ---");
        for (Pais p : lista) {
            System.out.println(p);
        }
        return lista;
    }

}
