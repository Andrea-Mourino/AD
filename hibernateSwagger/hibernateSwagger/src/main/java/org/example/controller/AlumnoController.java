package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Alumno;
import org.example.repository.AlumnoRepository;
import org.example.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AlumnoController.MAPPING)
public class AlumnoController {

    public static final String MAPPING = "/api";

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private AlumnoService alumnoService;


    @PostMapping
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.crearOActualizarAlumno(alumno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obterAlumno(@PathVariable Long id) {
        return alumnoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Alumno> modificarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        Optional<Alumno> op = alumnoService.obtenerPorId(id);

        if (op.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Alumno existente = op.get();
        existente.setNome(alumno.getNome());
        existente.setApelidos(alumno.getApelidos());
        existente.setTitor(alumno.getTitor());

        return ResponseEntity.ok(alumnoService.crearOActualizarAlumno(existente));
    }

    @Operation(summary = "Eliminar un alumno")
    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {
        if (alumnoRepository.existsById(id)) {
            alumnoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}