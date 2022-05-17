package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repositories.EmpleadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class EmpleadoDAOImplTest
{
    EmpleadoDAO empleadoDAO;
    EmpleadoRepository empleadoRepository;

    @BeforeEach
    void setUp() {
        empleadoRepository=mock(EmpleadoRepository.class);
        empleadoDAO = new EmpleadoDAOImpl(empleadoRepository);
    }

    @Test
    void findEmpleadoByTipoEmpleado() {
        when(empleadoRepository.findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO))
                .thenReturn(List.of(DatosDummy.empleado01(), DatosDummy.empleado02()));
        List<Persona> empleados = (List<Persona>) empleadoDAO.findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);

        assertThat(empleados.size()).isEqualTo(1);
        verify(empleadoRepository).findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);
    }
}
