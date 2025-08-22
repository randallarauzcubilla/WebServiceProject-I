package com.example.webservice.controladores;

import com.example.webservice.entidades.Tematicas;
import com.example.webservice.repository.TematicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Randall AC
 */
@RestController
@RequestMapping("/api/tematicas")
public class TematicasController {

    @Autowired
    private TematicasRepository tematicasRepository;

    @GetMapping
    public List<Tematicas> getAllTematicas() {
        return tematicasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tematicas> getTematicaById(@PathVariable Long id) {
        Optional<Tematicas> tematica = tematicasRepository.findById(id);
        return tematica.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tematicas createTematica(@RequestBody Tematicas tematica) {
        return tematicasRepository.save(tematica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tematicas> updateTematica(@PathVariable Long id, @RequestBody Tematicas detalles) {
        return tematicasRepository.findById(id).map(t -> {
            t.setNombre(detalles.getNombre());
            t.setCaracteristicas(detalles.getCaracteristicas());
            t.setEpoca(detalles.getEpoca());
            t.setSala(detalles.getSala());
            return ResponseEntity.ok(tematicasRepository.save(t));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTematica(@PathVariable Long id) {
        return tematicasRepository.findById(id).map(t -> {
            tematicasRepository.delete(t);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}