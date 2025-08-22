package com.example.webservice.controladores;

import com.example.webservice.entidades.Salas;
import com.example.webservice.repository.SalasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalasController {

    private final SalasRepository salasRepository;

    @Autowired
    public SalasController(SalasRepository salasRepository) {
        this.salasRepository = salasRepository;
    }

    // GET: listar todas las salas
    @GetMapping
    public List<Salas> getAllSalas() {
        return salasRepository.findAll();
    }

    // POST: crear una nueva sala
    @PostMapping
    public Salas createSala(@RequestBody Salas sala) {
        return salasRepository.save(sala);
    }

    // GET: obtener una sala por ID
    @GetMapping("/{id}")
    public Salas getSalaById(@PathVariable Integer id) {
        return salasRepository.findById(id).orElse(null);
    }

    // PUT: actualizar una sala
    @PutMapping("/{id}")
    public Salas updateSala(@PathVariable Integer id, @RequestBody Salas salaActualizada) {
        return salasRepository.findById(id).map(sala -> {
            sala.setNombre(salaActualizada.getNombre());
            sala.setDescripcion(salaActualizada.getDescripcion());
            sala.setTematica(salaActualizada.getTematica());
            sala.setMuseo(salaActualizada.getMuseo());
            return salasRepository.save(sala);
        }).orElse(null);
    }

    // DELETE: eliminar una sala
    @DeleteMapping("/{id}")
    public void deleteSala(@PathVariable Integer id) {
        salasRepository.deleteById(id);
    }
}
