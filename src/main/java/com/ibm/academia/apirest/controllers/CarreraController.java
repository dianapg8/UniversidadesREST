package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
            throw new BadRequestException("No existen carreras");
        return carreras;
    }

    @GetMapping("/id/{carreraId}")
    public Carrera buscarCarreraPorId(@PathVariable Integer carreraId)
    {
        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
        if(!oCarrera.isPresent())
            throw new BadRequestException(String.format("La carrera con id: %d no existe", carreraId));
        return oCarrera.get();
    }

    @PostMapping
    public ResponseEntity<?> guardarCarrera(@Valid @RequestBody Carrera carrera, BindingResult result)
    {
        Map<String, Object> validaciones = new HashMap<String, Object>();
        if(result.hasErrors())
        {
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista de errores: ", listaErrores);
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Carrera carreraGuardada = carreraDAO.guardar(carrera);
        return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
    }

    /**
     * Endpoint para actualizar un objeto de tipo carrera
     * @param carreraId Parametro para buscar la carrera
     * @param carrera Objeto con la informacion a modificar
     * @return Retorna un objeto de tipo carrera con la informacion actualizada
     * @NotFoundException En caso de que falle actualizando el objeto carrera
     * @author Diana Laura Paredes Gómez
     */
    @PutMapping("/upd/carreraId/{carreraId}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer carreraId, @RequestBody Carrera carrera)
    {
        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);

        if(!oCarrera.isPresent())
            throw new NotFoundException("La carrera con ese ID no existe");

        Carrera carreraActualizada = carreraDAO.actualizar(oCarrera.get(), carrera);

        return new ResponseEntity<Carrera>(carreraActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/carreraId/{carreraId}")
    public ResponseEntity<?> eliminarCarrera(@PathVariable Integer carreraId)
    {
        Map<String, Object> respuesta = new HashMap<String, Object>();

        Optional<Carrera> carrera = carreraDAO.buscarPorId(carreraId);

        if(!carrera.isPresent())
            throw new NotFoundException(String.format("La carrera con Id: %d no existe", carreraId));

        carreraDAO.eliminarPorId(carreraId);
        respuesta.put("OK", "Carrera ID: " + carreraId + " eliminada exitosamente");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }

}
