package com.example.webservice.controladores;


import com.example.webservice.entidades.EntradaSalas;
import com.example.webservice.repository.EntradaSalasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrada-salas")
public class EntradaSalasController {

    private final EntradaSalasRepository repository;

    public EntradaSalasController(EntradaSalasRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EntradaSalas> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaSalas> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EntradaSalas create(@RequestBody EntradaSalas entradaSala) {
        return repository.save(entradaSala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaSalas> update(@PathVariable Integer id, @RequestBody EntradaSalas updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setPrecioSala(updated.getPrecioSala());
                    existing.setEntrada(updated.getEntrada());
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