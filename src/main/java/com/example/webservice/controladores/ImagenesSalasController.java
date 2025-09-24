package com.example.webservice.controladores;

import com.example.webservice.entidades.ImagenesSalas;
import com.example.webservice.repository.ImagenesSalasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagenes-salas")
public class ImagenesSalasController {

    private final ImagenesSalasRepository repository;

    public ImagenesSalasController(ImagenesSalasRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ImagenesSalas> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenesSalas> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ImagenesSalas create(@RequestBody ImagenesSalas imagen) {
        return repository.save(imagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenesSalas> update(@PathVariable Integer id, @RequestBody ImagenesSalas updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setUrlImagen(updated.getUrlImagen());
                    existing.setDescripcion(updated.getDescripcion());
                    existing.setTipo(updated.getTipo());
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