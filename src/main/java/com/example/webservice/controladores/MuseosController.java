package com.example.webservice.controladores;

import com.example.webservice.entidades.Museos;
import com.example.webservice.repository.MuseosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/museos")
public class MuseosController {

    @Autowired
    private MuseosRepository museosRepo;

    @GetMapping
    public List<Museos> listar() {
        return museosRepo.findAll();
    }

    @PostMapping
    public Museos crear(@RequestBody Museos museo) {
        return museosRepo.save(museo);
    }

    @GetMapping("/{id}")
    public Museos obtenerPorId(@PathVariable Integer id) {
        return museosRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Museos actualizar(@PathVariable Integer id, @RequestBody Museos museoActualizado) {
        return museosRepo.findById(id).map(m -> {
            m.setNombre(museoActualizado.getNombre());
            m.setTipo(museoActualizado.getTipo());
            m.setUbicacion(museoActualizado.getUbicacion());
            m.setFechaFundacion(museoActualizado.getFechaFundacion());
            m.setDirector(museoActualizado.getDirector());
            m.setSitioWeb(museoActualizado.getSitioWeb());
            return museosRepo.save(m);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        museosRepo.deleteById(id);
    }
}
