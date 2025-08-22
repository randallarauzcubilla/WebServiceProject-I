package com.example.webservice.controladores;

import com.example.webservice.entidades.Especies;
import com.example.webservice.repository.EspeciesRepository;
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
@RequestMapping("/api/especies")
public class EspeciesController {

    @Autowired
    private EspeciesRepository especiesRepository;

    @GetMapping
    public List<Especies> listarTodas() {
        return especiesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especies> obtenerPorId(@PathVariable Integer id) {
        Optional<Especies> especie = especiesRepository.findById(id);
        return especie.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Especies crearEspecie(@RequestBody Especies especie) {
        return especiesRepository.save(especie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especies> actualizarEspecie(@PathVariable Integer id, @RequestBody Especies especieActualizada) {
        Optional<Especies> especieExistente = especiesRepository.findById(id);
        if (especieExistente.isPresent()) {
            Especies especie = especieExistente.get();
            especie.setNombreCientificoDeEspecie(especieActualizada.getNombreCientificoDeEspecie());
            especie.setNombreComunDeEspecie(especieActualizada.getNombreComunDeEspecie());
            especie.setFechaExtincion(especieActualizada.getFechaExtincion());
            especie.setEpoca(especieActualizada.getEpoca());
            especie.setPeso(especieActualizada.getPeso());
            especie.setTamanio(especieActualizada.getTamanio());
            especie.setColeccion(especieActualizada.getColeccion());
            return ResponseEntity.ok(especiesRepository.save(especie));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEspecie(@PathVariable Integer id) {
        if (especiesRepository.existsById(id)) {
            especiesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}