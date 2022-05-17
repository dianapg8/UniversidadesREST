package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.mapper.AlumnoMapper;
import com.ibm.academia.apirest.models.dto.AlumnoDTO;
import com.ibm.academia.apirest.models.entities.Alumno;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alumno")
public class AlumnoController
{
    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO alumnoDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    /**
     * Endpoint para crear un objeto Persona de tipo Alumno
     * @param alumno Objeto alumno con la informacion a crear
     * @return Retorna un objeto Persona de tipo alumno con codigo http status 201
     */
    @PostMapping
    public ResponseEntity<?> crearAlumno(@Valid @RequestBody Persona alumno, BindingResult result)
    {
        Persona alumnoGuardado = alumnoDAO.guardar(alumno);
        return new ResponseEntity<Persona>(alumnoGuardado, HttpStatus.CREATED);
    }

    /**
     * Endpoint para listar los alumnos
     * @return
     */
    @GetMapping("/alumnos/lista")
    public ResponseEntity<?> obtenerTodos()
    {
        List<Persona> alumnos = (List<Persona>) alumnoDAO.buscarTodos();

        if(alumnos.isEmpty())
            throw new NotFoundException("No existen alumnos");

        return new ResponseEntity<List<Persona>>(alumnos,HttpStatus.OK);
    }

    /**
     * Endpoint para buscar alumno
     * @param alumnoId
     * @return
     */
    @GetMapping("/alumnoId/{alumnoId}")
    public ResponseEntity<?> buscarAlumnoPorId(@PathVariable Integer alumnoId)
    {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("Alumno con Id %d no existe", alumnoId));

        return new ResponseEntity<Persona>(oAlumno.get(),HttpStatus.OK);
    }

    /**
     * Endpoint para actualizar la informacion de un Alumno
     * @param alumnoId
     * @param alumno
     * @return
     */
    @PutMapping("/upd/alumnoId/{alumnoId}")
    public ResponseEntity<?> actualizarAlummno(@PathVariable Integer alumnoId,@RequestBody Persona alumno)
    {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno con Id %d no existe " + alumnoId));

        Persona alumnoActualizado = ((AlumnoDAO)alumnoDAO).actualizar(oAlumno.get(),alumno);

        return new ResponseEntity<Persona>(alumnoActualizado,HttpStatus.OK);
    }

    @DeleteMapping("alumnoId/{alumnoId}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Integer alumnoId)
    {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno con Id %d no existe", alumnoId));

        alumnoDAO.eliminarPorId(oAlumno.get().getId());

        return new ResponseEntity<String>("Alumno Id: " + alumnoId + " se elimino satisfactoriamente", HttpStatus.ACCEPTED);

    }

    @PutMapping("/alumnoId/{alumnoId}/carreraId/{carreraId}")
    public ResponseEntity<?> asignarCarrera(@PathVariable Integer alumnoId,@PathVariable Integer carreraId)
    {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorId(alumnoId);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno con Id %d no existe",alumnoId));

        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
        if(!oCarrera.isPresent()){
            throw new NotFoundException(String.format("La carrera con Id %d no existe",carreraId));
        }
        Persona alumno = ((AlumnoDAO)alumnoDAO).asociarCarreraAlumno(oAlumno.get(),oCarrera.get());
        return new ResponseEntity<Persona>(alumno,HttpStatus.OK);
    }

    @GetMapping("/alumnos/dto")
    public ResponseEntity<?> obtenerAlumnosDto(){
        List<Persona> alumnos = (List<Persona>) alumnoDAO.buscarTodos();

        if(alumnos.isEmpty())
            throw new BadRequestException("No existen alumnos");

        List<AlumnoDTO> alumnosDto = alumnos
                .stream()
                .map(AlumnoMapper::mapperAlumno)
                .collect(Collectors.toList());

        return new ResponseEntity<List<AlumnoDTO>>(alumnosDto,HttpStatus.OK);


    }

}