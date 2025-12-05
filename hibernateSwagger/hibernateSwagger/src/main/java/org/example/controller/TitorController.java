package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.model.Titor;
import org.example.service.TitorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titores")
public class TitorController {

    private final TitorService titorService;

    public TitorController(TitorService titorService) {
        this.titorService = titorService;
    }

    @Operation(summary = "Crear un titor")
    @PostMapping
    public ResponseEntity<Titor> crearTitor(@RequestBody Titor titor) {
        return ResponseEntity.ok(titorService.crearOuActualizarTitor(titor));
    }

    @Operation(summary = "Modificar un titor")
    @PutMapping("/{id}")
    public ResponseEntity<Titor> modificarTitor(@PathVariable Long id, @RequestBody Titor titor) {
        return titorService.obterPorId(id)
                .map(t -> {
                    t.setNome(titor.getNome());
                    t.setApelidos(titor.getApelidos());
                    return ResponseEntity.ok(titorService.crearOuActualizarTitor(t));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Obter un titor e os seus alumnos")
    @GetMapping("/{id}")
    public ResponseEntity<Titor> obterTitor(@PathVariable Long id) {
        return titorService.obterPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Obter todos os titores")
    @GetMapping
    public List<Titor> obterTodos() {
        return titorService.obterTodosTitores();
    }

    @Operation(summary = "Eliminar un titor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTitor(@PathVariable Long id) {
        try {
            titorService.eliminarTitor(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(409).build(); // Ten alumnos asociados
        }
    }
}
