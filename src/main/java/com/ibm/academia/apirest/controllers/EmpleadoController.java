package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Empleado;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.EmpleadoDAO;
import com.ibm.academia.apirest.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController
{
    @Autowired
    @Qualifier("empleadoDAOImpl")
    private PersonaDAO empleadoDAO;

    @PostMapping
    public ResponseEntity<?> crearEmpleado(@Valid @RequestBody Persona empleado, BindingResult result)
    {
        Persona empleadoGuardado = empleadoDAO.guardar(empleado);
        return new ResponseEntity<Persona>(empleadoGuardado, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> buscarTodos()
    {
        List<Persona> empleados = (List<Persona>) empleadoDAO.buscarTodos();

        if(empleados.isEmpty())
            throw new NotFoundException("No existen empleados");

        return new ResponseEntity<List<Persona>>(empleados,HttpStatus.OK);
    }

    @GetMapping("empleadoId/{empleadoId}")
    public ResponseEntity<?> buscarEmpleadoPorId(@PathVariable Integer empleadoId)
    {
        Optional<Persona> oEmpleado = empleadoDAO.buscarPorId(empleadoId);

        if(!oEmpleado.isPresent())
            throw new NotFoundException("No existe el empleado con el ID " + empleadoId);

        return new ResponseEntity<Persona>(oEmpleado.get(),HttpStatus.OK);
    }

    @PutMapping("/upd/empleadoId/{empleadoId}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable Integer empleadoId,@RequestBody Empleado empleado)
    {
        Optional<Persona> oEmpleado = empleadoDAO.buscarPorId(empleadoId);

        if(!oEmpleado.isPresent())
            throw new NotFoundException("No existe el empleado con el ID " + empleadoId);

        Persona empleadoActualizado =  ((EmpleadoDAO)empleadoDAO).actualizar(oEmpleado.get(), empleado);
        return new ResponseEntity<Persona>(empleadoActualizado,HttpStatus.OK);
    }


    @DeleteMapping("empleadoId/{empleadoId}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Integer empleadoId)
    {
        Optional<Persona> oEmpleado = empleadoDAO.buscarPorId(empleadoId);

        if(!oEmpleado.isPresent())
            throw new NotFoundException("No existe el empleado con el ID " + empleadoId);

        empleadoDAO.eliminarPorId(oEmpleado.get().getId());

        return new ResponseEntity<String>("Empleado Id: " + empleadoId + " se elimino satisfactoriamente", HttpStatus.ACCEPTED);
    }
}
