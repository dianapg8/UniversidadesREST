package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.exceptions.badRequestException;
import com.ibm.academia.apirest.services.CarreraDAO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrera")
public class CarreraController
{
    @Autowired
    private CarreraDAO carreraDAO;

    @GetMapping("/lista/carreras")
    public List<Carrera> buscarTodas()
    {
        List<Carrera> carreras = (List<Carrera>) carreraDAO.buscarTodos();
        if(carreras.isEmpty())
            throw new badRequestException("No existen carreras");
        return carreras;
    }

    @GetMapping("/id/{carreraId}")
    public Carrera buscarCarreraPorId(@PathVariable Integer carreraId)
    {
        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
        if(!oCarrera.isPresent())
            throw new badRequestException(String.format("La carrera con id: %d no existe", carreraId));
        return oCarrera.get();
    }

    @PostMapping
    public ResponseEntity<?> guardarCarrera(@RequestBody Carrera carrera)
    {
        if(carrera.getCantidadAnios()<0)
            throw new badRequestException("El campo cantidad de años debe ser mayor a cero");

        if(carrera.getCantidadMaterias()<0)
            throw new badRequestException("El campo cantidad de materias debe ser mayor a cero");

        Carrera carreraGuardada = carreraDAO.guardar(carrera);
        return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
    }

}
