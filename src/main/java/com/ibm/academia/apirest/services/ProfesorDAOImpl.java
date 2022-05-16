package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.repositories.PersonaRepository;
import com.ibm.academia.apirest.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {

    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesor") PersonaRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findProfesoresByCarrera(String nombre) {
        return ((ProfesorRepository) repository).findProfesoresByCarrera(nombre);
    }

    @Override
    @Transactional
    public Persona actualizar(Persona profesorEncontrado, Profesor profesor) {
        Persona profesorActualizado = null;
        profesorEncontrado.setNombre(profesor.getNombre());
        profesorEncontrado.setApellido(profesor.getApellido());
        profesorEncontrado.setDireccion(profesor.getDireccion());
        ((Profesor)profesorEncontrado).setSueldo(profesor.getSueldo());
        profesorActualizado=repository.save(profesorEncontrado);
        return profesorActualizado;
    }
}
