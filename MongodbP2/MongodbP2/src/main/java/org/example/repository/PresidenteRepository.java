package org.example.repository;

// Importa la clase Presidente que representa los documentos de la colección
import org.codewith.practica2_mongodb.model.Presidente;

// Importa la interfaz de Spring Data MongoDB para repositorios
import org.springframework.data.mongodb.repository.MongoRepository;

// Define un repositorio para la entidad Presidente
// Extiende MongoRepository para obtener métodos CRUD y de consulta automáticamente
// <Presidente, String> indica que trabaja con objetos Presidente y que su ID es de tipo String
public interface PresidenteRepository extends MongoRepository<Presidente, String> {
    // No es necesario definir métodos básicos, MongoRepository ya proporciona:
    // save(), findById(), findAll(), deleteById(), etc.
}
