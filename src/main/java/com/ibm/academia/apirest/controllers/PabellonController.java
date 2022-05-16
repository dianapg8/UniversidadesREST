package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.AulaDAO;
import com.ibm.academia.apirest.services.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pabellon")
public class PabellonController
{
    @Autowired
    private PabellonDAO pabellonDAO;

    @Autowired
    private AulaDAO aulaDAO;

    @PostMapping
    public ResponseEntity<?> crearPabellon(@Valid @RequestBody Pabellon pabellon, BindingResult result)
    {
        Pabellon pabellonGuardado = pabellonDAO.guardar(pabellon);
        return new ResponseEntity<Pabellon>(pabellonGuardado, HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> buscarTodos()
    {
        List<Pabellon> pabellones = (List<Pabellon>) pabellonDAO.buscarTodos();

        if(pabellones.isEmpty())
            throw new NotFoundException("No existen pabellones");

        return new ResponseEntity<List<Pabellon>>(pabellones, HttpStatus.OK);
    }

    @GetMapping("pabellonId/{pabellonId}")
    public ResponseEntity<?> buscarPabellonPorId(@PathVariable Integer pabellonId)
    {
        Optional<Pabellon> oPabellon = pabellonDAO.buscarPorId(pabellonId);

        if (!oPabellon.isPresent())
            throw new NotFoundException("No existe el pabellon con ID " + pabellonId);

        return new ResponseEntity<Pabellon>(oPabellon.get(), HttpStatus.OK);

    }

    @PutMapping("upd/pabellonId/{pabellonId}")
    public ResponseEntity<?> actualizarPabellon(@PathVariable Integer pabellonId, @RequestBody Pabellon pabellon)
    {
        Optional<Pabellon> oPabellon = pabellonDAO.buscarPorId(pabellonId);

        if (!oPabellon.isPresent())
            throw new NotFoundException("No existe el pabellon con el Id " + pabellonId);

        Pabellon pabellonActualizado = pabellonDAO.actualizar(oPabellon.get(), pabellon);

        return new ResponseEntity<Pabellon>(pabellonActualizado, HttpStatus.OK);
    }

    @DeleteMapping("pabellonId/{pabellonId}")
    public ResponseEntity<?> eliminarPabellon(@PathVariable Integer pabellonId)
    {
        Optional<Pabellon> oPabellon = pabellonDAO.buscarPorId(pabellonId);

        if (!oPabellon.isPresent())
            throw new NotFoundException("No existe el pabellon con el ID " + pabellonId);

        List<Aula> aulas = (List<Aula>) aulaDAO.findAulasByPabellonNombre(oPabellon.get().getNombre());
        aulas.forEach(aula -> aulaDAO.eliminarPorId(aula.getId()));

        pabellonDAO.eliminarPorId(oPabellon.get().getId());

        return new ResponseEntity<String>("Pabellon Id: " + pabellonId + " se elimino satisfactoriamente", HttpStatus.ACCEPTED);
    }

}
