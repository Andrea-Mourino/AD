package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Alumno;
import org.example.service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @Operation(summary = "Crear un alumno")
    @PostMapping
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.crearOActualizarAlumno(alumno));
    }

    @Operation(summary = "Obter un alumno polo seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obterAlumno(@PathVariable Long id) {
        return alumnoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Modificar un alumno")
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {
        if (alumnoService.obtenerPorId(id).isPresent()) {
            alumnoService.eliminarAlumno(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
