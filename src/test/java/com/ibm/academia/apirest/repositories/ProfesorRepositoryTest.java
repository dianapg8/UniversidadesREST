package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.models.entities.Profesor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ProfesorRepositoryTest
{
    @Autowired
    private ProfesorRepository repository;

    @Autowired
    private CarreraRepository carreraRepository;

    @BeforeEach
    void setUp()
    {
        repository.save(DatosDummy.profesor01());
        repository.save(DatosDummy.profesor02());
        repository.save(DatosDummy.profesor03());
    }

    @AfterEach
    void tearDown()
    {
        repository.deleteAll();
    }

    @Test
    void findProfesoresByCarrera()
    {
        Optional<Persona> profesor = repository.findById(2);

        if (profesor.isEmpty())
        {
            throw new EntityNotFoundException("No se encontró el profesor con ese Id ");
        }

        Profesor profesorEncontrado = (Profesor) profesor.get();
        Set<Carrera> carreras = new HashSet<>();

        Carrera carreraGuardada = carreraRepository.save(DatosDummy.carrera01());
        carreras.add(carreraGuardada);
        profesorEncontrado.setCarreras(carreras);
        repository.save(profesorEncontrado);

        List<Persona> profesoresPorCarrera = (List<Persona>) repository.findProfesoresByCarrera("Ingenieria en Sistemas");
        assertThat(profesoresPorCarrera.size()).isGreaterThan(0);
    }
}