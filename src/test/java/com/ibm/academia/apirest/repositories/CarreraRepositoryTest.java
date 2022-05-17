package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Carrera;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CarreraRepositoryTest
{
    @Autowired
    private CarreraRepository carreraRepository;

    @BeforeEach
    void setUp()
    {
        carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());
    }

    @AfterEach
    void tearDown()
    {
        carreraRepository.deleteAll();
    }

    @Test
    void findCarrerasByNombreContains()
    {
        Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContains("Sistemas");

        assertThat(((List<Carrera>) expected).size() == 2).isTrue();
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase()
    {
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("sistemas");

        assertThat(expected.size() == 2).isTrue();
    }

    @Test
    void findCarrerasByCantidadAniosAfter()
    {
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(4);

        assertThat(expected.size() == 2).isTrue();
    }
}
