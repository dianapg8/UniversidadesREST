package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.repositories.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class AlumnoDAOImplTest
{
    @MockBean
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AlumnoDAO alumnoDAO;

    @Test
    void buscarAlumnoPorNombreCarrera()
    {
        alumnoDAO.buscarAlumnoPorNombreCarrera(anyString());
        verify(alumnoRepository).buscarAlumnoPorNombreCarrera(anyString());

    }
}
