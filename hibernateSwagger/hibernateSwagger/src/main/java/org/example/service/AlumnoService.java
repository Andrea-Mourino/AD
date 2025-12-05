package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Alumno;
import org.example.model.Titor;
import org.example.repository.AlumnoRepository;
import org.example.repository.TitorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final TitorRepository titorRepository;

    public AlumnoService(AlumnoRepository alumnoRepository, TitorRepository titorRepository) {
        this.alumnoRepository = alumnoRepository;
        this.titorRepository = titorRepository;
    }

    @Transactional
    public Alumno crearOActualizarAlumno(Alumno alumno) {
        Long idTitor = alumno.getTitor().getId_titor();
        Titor titor = titorRepository.findById(idTitor)
                .orElseThrow(() -> new RuntimeException("O titor non existe"));
        alumno.setTitor(titor);
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> obtenerPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    public void eliminarAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}
