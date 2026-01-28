package org.example.repository;

import org.example.model.Presidente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PresidenteRepository extends MongoRepository<Presidente, String> {
}
