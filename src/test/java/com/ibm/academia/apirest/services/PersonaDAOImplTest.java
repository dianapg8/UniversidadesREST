package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonaDAOImplTest
{
    PersonaRepository personaRepository;
    PersonaDAO personaDAO;

    @BeforeEach
    void setUp() {
        personaRepository = mock(PersonaRepository.class);
        personaDAO = new PersonaDAOImpl(personaRepository);
    }

    @Test
    void buscarPorNombreApellido() {
        when(personaRepository.buscarPorNombreYApellido("Lautero","Lopez"))
                .thenReturn(Optional.of(DatosDummy.profesor01()));

        Optional<Persona> persona = personaDAO.buscarPorNombreYApellido("Lautero","Lopez");

        assertTrue(persona.isPresent());
        assertThat(persona.get()).isEqualTo(DatosDummy.profesor01());
        verify(personaRepository).buscarPorNombreYApellido("Lautero","Lopez");
    }

    @Test
    void buscarPorDni() {
        when(personaRepository.buscarPorDni("96454"))
                .thenReturn(Optional.of(DatosDummy.profesor01()));

        Optional<Persona> persona = personaDAO.buscarPorDni("96454");

        assertTrue(persona.isPresent());
        assertThat(persona.get()).isEqualTo(DatosDummy.profesor01());
        verify(personaRepository).buscarPorDni("96454");
    }

    @Test
    void buscarPorApellido() {
        when(personaRepository.buscarPersonasPorApellido("Lopez")).thenReturn(List.of(DatosDummy.profesor01(),DatosDummy.profesor02()));
        List<Persona> personas = (List<Persona>) personaDAO.buscarPersonasPorApellido("Lopez");
        assertThat(personas.size()).isEqualTo(2);
        verify(personaRepository).buscarPersonasPorApellido("Lopez");

    }
}
