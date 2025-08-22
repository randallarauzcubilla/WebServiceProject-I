package com.example.webservice.controladores;


import com.example.webservice.entidades.RegistroComisiones;
import com.example.webservice.repository.RegistroComisionesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registro-comisiones")
public class RegistroComisionesController {

    private final RegistroComisionesRepository repository;

    public RegistroComisionesController(RegistroComisionesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<RegistroComisiones> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroComisiones> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RegistroComisiones create(@RequestBody RegistroComisiones registro) {
        return repository.save(registro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroComisiones> update(@PathVariable Integer id, @RequestBody RegistroComisiones updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setValorCobrado(updated.getValorCobrado());
                    existing.setComision(updated.getComision());
                    existing.setEntrada(updated.getEntrada());
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