package org.example.repository;

// Importa la clase Pais que representa los documentos de la colección
import org.codewith.practica2_mongodb.model.Pais;

// Importa la interfaz de Spring Data MongoDB para repositorios
import org.springframework.data.mongodb.repository.MongoRepository;

// Define un repositorio para la entidad Pais
// Extiende MongoRepository para obtener métodos CRUD y de consulta automáticamente
// <Pais, String> indica que trabaja con objetos Pais y que su ID es de tipo String
public interface PaisRepository extends MongoRepository<Pais, String> {
    // No es necesario definir métodos básicos, MongoRepository ya proporciona:
    // save(), findById(), findAll(), deleteById(), etc.
}
