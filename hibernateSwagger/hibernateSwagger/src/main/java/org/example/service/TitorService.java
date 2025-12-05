package org.example.service;

import org.example.model.Titor;
import org.example.repository.TitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitorService {

    private final TitorRepository titorRepository;

    public TitorService(TitorRepository titorRepository) {
        this.titorRepository = titorRepository;
    }

    public Titor crearOuActualizarTitor(Titor titor) {
        return titorRepository.save(titor);
    }

    public List<Titor> obterTodosTitores() {
        return titorRepository.findAll();
    }

    public Optional<Titor> obterPorId(Long id) {
        return titorRepository.findById(id);
    }

    public void eliminarTitor(Long id) {
        titorRepository.deleteById(id);
    }
}
