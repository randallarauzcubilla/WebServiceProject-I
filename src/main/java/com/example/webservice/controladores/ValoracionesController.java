package com.example.webservice.controladores;

import com.example.webservice.entidades.Valoraciones;
import com.example.webservice.repository.ValoracionesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valoraciones")
public class ValoracionesController {

    private final ValoracionesRepository repository;

    public ValoracionesController(ValoracionesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Valoraciones> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Valoraciones> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Valoraciones create(@RequestBody Valoraciones valoracion) {
        return repository.save(valoracion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Valoraciones> update(@PathVariable Integer id, @RequestBody Valoraciones updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setEstrellas(updated.getEstrellas());
                    existing.setObservacion(updated.getObservacion());
                    existing.setSala(updated.getSala());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}