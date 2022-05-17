package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Pabellon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PabellonRepositoryTest
{
    @Autowired
    private PabellonRepository pabellonRepository;

    @BeforeEach
    void setUp()
    {
        pabellonRepository.save(DatosDummy.pabellon01());
        pabellonRepository.save(DatosDummy.pabellon02());
        pabellonRepository.save(DatosDummy.pabellon03());
    }

    @AfterEach
    void tearDown()
    {
        pabellonRepository.deleteAll();

    }

    @Test
    void findPabellonesByDireccionLocalidad()
    {
        List<Pabellon> pabellones = (List<Pabellon>) pabellonRepository.findPabellonesByDireccionLocalidad("Jalapa");
        assertThat(pabellones.size()).isEqualTo(1);
    }

    @Test
    void findPabelloesnByNombre() {
        List<Pabellon> pabellones = (List<Pabellon>) pabellonRepository.findPabellonesByNombre("PabellonDos");
        assertThat(pabellones.size()).isEqualTo(1);
    }
}