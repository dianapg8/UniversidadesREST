package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.models.entities.Persona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class EmpleadoRepositoryTest
{
    @Autowired
    private EmpleadoRepository repository;

    @BeforeEach
    void setUp()
    {
        repository.save(DatosDummy.empleado01());
        repository.save(DatosDummy.empleado02());
    }

    @AfterEach
    void tearDown()
    {
        repository.deleteAll();
    }

    @Test
    void findEmpleadoByTipoEmpleado()
    {
        List<Persona> empleadosMantenimiento = (List<Persona>) repository.findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
        assertThat(empleadosMantenimiento.size()).isEqualTo(1);
    }
}