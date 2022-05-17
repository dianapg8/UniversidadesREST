package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.repositories.CarreraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class CarreraDAOImplTest
{
    CarreraDAO carreraDAO;
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp()
    {
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepository);
    }

    @Test
    @DisplayName("Test: Buscar carrera por nombre")
    void findCarrerasByNombreContains()
    {
        String nombre = "Ingenieria";
        when(carreraRepository.findCarrerasByNombreContains(nombre)).thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

        verify(carreraRepository).findCarrerasByNombreContains(nombre);

    }

    @Test
    @DisplayName("Test: Buscar carreras por nombre ignore case")
    void findCarrerasByNombreContainsIgnoreCase()
    {
        String nombre = "ingenieria";
        when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);

    }

    @Test
    @DisplayName("Test: Buscar carreras despues de N años")
    void findCarrerasByCantidadAniosAfter()
    {
        int cantidad = 4;
        when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

        verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);

    }
}
