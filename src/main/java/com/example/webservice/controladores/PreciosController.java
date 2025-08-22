package com.example.webservice.controladores;

import com.example.webservice.entidades.Precios;
import com.example.webservice.repository.PreciosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/precios")
public class PreciosController {

    private final PreciosRepository preciosRepository;

    public PreciosController(PreciosRepository preciosRepository) {
        this.preciosRepository = preciosRepository;
    }

    @GetMapping
    public List<Precios> listarTodos() {
        return preciosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Precios> obtenerPorId(@PathVariable Integer id) {
        return preciosRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Precios crear(@RequestBody Precios precios) {
        return preciosRepository.save(precios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Precios> actualizar(@PathVariable Integer id, @RequestBody Precios preciosActualizado) {
        return preciosRepository.findById(id)
                .map(preciosExistente -> {
                    preciosExistente.setPrecioLunesSabado(preciosActualizado.getPrecioLunesSabado());
                    preciosExistente.setPrecioDomingo(preciosActualizado.getPrecioDomingo());
                    preciosExistente.setSala(preciosActualizado.getSala());
                    return ResponseEntity.ok(preciosRepository.save(preciosExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (preciosRepository.existsById(id)) {
            preciosRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}