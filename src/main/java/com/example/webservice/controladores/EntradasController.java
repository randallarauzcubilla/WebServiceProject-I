package com.example.webservice.controladores;

import com.example.webservice.entidades.Entradas;
import com.example.webservice.repository.EntradasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradasController {

    private final EntradasRepository repository;

    public EntradasController(EntradasRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Entradas> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entradas> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entradas create(@RequestBody Entradas entrada) {
        return repository.save(entrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entradas> update(@PathVariable Integer id, @RequestBody Entradas updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setFechaCompra(updated.getFechaCompra());
                    existing.setFechaVisita(updated.getFechaVisita());
                    existing.setPrecioTotal(updated.getPrecioTotal());
                    existing.setCodigoQR(updated.getCodigoQR());
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