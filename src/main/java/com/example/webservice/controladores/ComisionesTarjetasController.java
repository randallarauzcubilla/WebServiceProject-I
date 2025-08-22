package com.example.webservice.controladores;


import com.example.webservice.repository.ComisionesTarjetasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comisiones-tarjetas")
public class ComisionesTarjetasController {

    private final ComisionesTarjetasRepository repository;

    public ComisionesTarjetasController(ComisionesTarjetasRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ComisionesTarjetas> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComisionesTarjetas> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ComisionesTarjetas create(@RequestBody ComisionesTarjetas comision) {
        return repository.save(comision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComisionesTarjetas> update(@PathVariable Integer id, @RequestBody ComisionesTarjetas updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTipoTarjeta(updated.getTipoTarjeta());
                    existing.setPorcentajeComision(updated.getPorcentajeComision());
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