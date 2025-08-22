package com.example.webservice.controladores;

import com.example.webservice.entidades.Colecciones;
import com.example.webservice.repository.ColeccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author Randall AC
 */
@RestController
@RequestMapping("/api/colecciones")
public class ColeccionesController {

    private final ColeccionesRepository coleccionesRepository;

    @Autowired
    public ColeccionesController(ColeccionesRepository coleccionesRepository) {
        this.coleccionesRepository = coleccionesRepository;
    }

    // GET: listar todas las colecciones
    @GetMapping
    public List<Colecciones> getAllColecciones() {
        return coleccionesRepository.findAll();
    }

    // POST: crear una nueva colección
    @PostMapping
    public Colecciones createColeccion(@RequestBody Colecciones coleccion) {
        return coleccionesRepository.save(coleccion);
    }

    // GET: obtener una colección por ID
    @GetMapping("/{id}")
    public Colecciones getColeccionById(@PathVariable Integer id) {
        return coleccionesRepository.findById(id).orElse(null);
    }

    // PUT: actualizar una colección
    @PutMapping("/{id}")
    public Colecciones updateColeccion(@PathVariable Integer id, @RequestBody Colecciones coleccionActualizada) {
        return coleccionesRepository.findById(id).map(coleccion -> {
            coleccion.setNombreColeccion(coleccionActualizada.getNombreColeccion());
            coleccion.setDescripcion(coleccionActualizada.getDescripcion());
            coleccion.setSiglo(coleccionActualizada.getSiglo());
            coleccion.setSala(coleccionActualizada.getSala());
            return coleccionesRepository.save(coleccion);
        }).orElse(null);
    }

    // DELETE: eliminar una colección
    @DeleteMapping("/{id}")
    public void deleteColeccion(@PathVariable Integer id) {
        coleccionesRepository.deleteById(id);
    }
}
