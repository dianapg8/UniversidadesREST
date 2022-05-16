package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aula")
public class AulaController
{
    @Autowired
    private AulaDAO aulaDAO;

    @PostMapping
    public ResponseEntity<?> crearAula(@Valid @RequestBody Aula aula, BindingResult result)
    {
        Aula aulaGuardada = aulaDAO.guardar(aula);
        return new ResponseEntity<Aula>(aulaGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> buscarTodos()
    {
        List<Aula> aulas = (List<Aula>) aulaDAO.buscarTodos();

        if (aulas.isEmpty())
            throw new NotFoundException("No existen aulas");

        return new ResponseEntity<List<Aula>>(aulas, HttpStatus.OK);

    }

    @GetMapping("aulaId/{aulaId}")
    public ResponseEntity<?> buscarAulaPorId(@PathVariable Integer aulaId)
    {
        Optional<Aula> oAula = aulaDAO.buscarPorId(aulaId);

        if (!oAula.isPresent())
            throw new NotFoundException("No existe el aula con ID " + aulaId);

        return new ResponseEntity<Aula>(oAula.get(), HttpStatus.OK);

    }

    @PutMapping("/upd/aulaId/{aulaId}")
    public ResponseEntity<?> actualizarAula(@PathVariable Integer aulaId, @RequestBody Aula aula)
    {
        Optional<Aula> oAula = aulaDAO.buscarPorId(aulaId);

        if (!oAula.isPresent())
            throw new NotFoundException("No existe el aula con ID " + aulaId);

        Aula aulaActualizada = aulaDAO.actualizar(oAula.get(), aula);

        return new ResponseEntity<Aula>(aulaActualizada, HttpStatus.CREATED);

    }

    @DeleteMapping("/aulaId/{aulaId}")
    public ResponseEntity<?> eliminarAula(@PathVariable Integer aulaId)
    {
        Optional<Aula> oAula = aulaDAO.buscarPorId(aulaId);

        if (!oAula.isPresent())
            throw new NotFoundException("No existe el aula con ID " + aulaId);

        aulaDAO.eliminarPorId(oAula.get().getId());

        return new ResponseEntity<String>("Aula Id: " + aulaId + " se elimino satisfactoriamente", HttpStatus.ACCEPTED);
    }
}