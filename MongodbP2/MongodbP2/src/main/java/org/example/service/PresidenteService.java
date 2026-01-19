package org.example.service;

// Importa Gson para manejo de JSON
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// Importa la clase Presidente (modelo)
import org.codewith.practica2_mongodb.model.Presidente;
// Importa el repositorio para interactuar con la colección de presidentes
import org.codewith.practica2_mongodb.repository.PresidenteRepository;

// Para leer archivos desde resources
import org.springframework.core.io.ClassPathResource;
// Marca la clase como un servicio de Spring
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

// Marca la clase como servicio de Spring
@Service
public class PresidenteService {

    // Repositorio para interactuar con la base de datos de presidentes
    private final PresidenteRepository presidenteRepo;

    // Constructor para inyectar el repositorio (inyección de dependencias)
    public PresidenteService(PresidenteRepository presidenteRepo) {
        this.presidenteRepo = presidenteRepo;
    }

    // Crear un nuevo presidente en la base de datos
    public void crearPresidente(Presidente presidente) {
        presidenteRepo.save(presidente);
    }

    // Importar presidentes desde un archivo JSON en resources
    public List<Presidente> importarDesdeJSON(String ruta) throws IOException {
        // Se abre el archivo usando ClassPathResource
        try (Reader reader = new InputStreamReader(new ClassPathResource(ruta).getInputStream())) {
            // Define el tipo de lista para Gson (ArrayList de Presidentes)
            Type listType = new TypeToken<ArrayList<Presidente>>() {}.getType();
            // Convierte el JSON en lista de objetos Presidente
            List<Presidente> list_presidente = new Gson().fromJson(reader, listType);
            // Guarda todos los presidentes en la base de datos y retorna la lista guardada
            return presidenteRepo.saveAll(list_presidente);
        }
    }

    // Obtener todos los presidentes de la base de datos
    public List<Presidente> buscarPresidentes() {
        return presidenteRepo.findAll();
    }

    // Listar todos los presidentes e imprimirlos por consola
    public List<Presidente> listarPresidentes() {
        List<Presidente> lista = presidenteRepo.findAll();
        System.out.println("--- Lista de Presidentes ---");
        for (Presidente p : lista) {
            System.out.println(p);
        }
        return lista;
    }

    // Borrar todos los presidentes de la base de datos
    public void borrarPresidentes() {
        presidenteRepo.deleteAll();
    }

}
