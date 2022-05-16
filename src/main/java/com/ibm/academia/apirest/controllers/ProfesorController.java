package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.PersonaDAO;
import com.ibm.academia.apirest.services.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesor")
public class ProfesorController
{
    @Autowired
    @Qualifier("profesorDAOImpl")
    private PersonaDAO profesorDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    @PostMapping
    public ResponseEntity<?> crearProfesor(@Valid @RequestBody Persona profesor, BindingResult result)
    {
        Persona profesorGuardado = profesorDAO.guardar(profesor);
        return new ResponseEntity<Persona>(profesorGuardado, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> buscarTodos()
    {
        List<Persona> profesores = (List<Persona>) profesorDAO.buscarTodos();

        if(profesores.isEmpty())
            throw new NotFoundException("No existen profesores");

        return new ResponseEntity<List<Persona>>(profesores,HttpStatus.OK);
    }

    @GetMapping("/profesorId/{profesorId}")
    public ResponseEntity<?> buscarProfesorPorId(@PathVariable Integer profesorId)
    {
        Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);

        if(!oProfesor.isPresent())
            throw new NotFoundException("No existe el profesor con el ID " + profesorId);

        return new ResponseEntity<Persona>(oProfesor.get(),HttpStatus.OK);

    }

    @PutMapping("/upd/profesorId/{profesorId}")
    public ResponseEntity<?> actualizarProfesor(@PathVariable Integer profesorId,@RequestBody Profesor profesor)
    {
        Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);

        if(!oProfesor.isPresent())
            throw new NotFoundException("No existe el profesor con el ID " + profesorId);

        Persona profesorActualizado = ((ProfesorDAO)profesorDAO).actualizar(oProfesor.get(),profesor);

        return new ResponseEntity<Persona>(profesorActualizado,HttpStatus.OK);
    }


    @DeleteMapping("profesorId/{profesorId}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Integer profesorId)
    {
        Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);

        if(!oProfesor.isPresent())
            throw new NotFoundException("No existe el profesor con el ID " + profesorId);

        profesorDAO.eliminarPorId(oProfesor.get().getId());
        return new ResponseEntity<String>("Profesor Id: " + profesorId + " se elimino satisfactoriamente", HttpStatus.ACCEPTED);

    }


}