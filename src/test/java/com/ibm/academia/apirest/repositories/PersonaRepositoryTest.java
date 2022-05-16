package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Empleado;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class PersonaRepositoryTest
{
    @Autowired
    @Qualifier("repositorioAlumnos")
    private PersonaRepository alumnoRepository;

    @Autowired
    @Qualifier("empleadoRepository")
    private PersonaRepository empleadoRepository;

    @Autowired
    @Qualifier("profesorRepository")
    private PersonaRepository profesorRepository;


    @Test
    @DisplayName("Test: Buscar por nombre y apellido")
    void buscarPorNombreYApellido()
    {
        Persona personaEmpleado = empleadoRepository.save(DatosDummy.empleado01());

        Optional<Persona> expected = empleadoRepository.buscarPorNombreYApellido(DatosDummy.empleado01().getNombre(), DatosDummy.empleado01().getApellido());

        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(personaEmpleado);
    }

    @Test
    @DisplayName("Test: Buscar persona por DNI")
    void buscarPorDni()
    {
        Persona personaProfesor = profesorRepository.save(DatosDummy.profesor01());

        Optional<Persona> expected = profesorRepository.buscarPorDni(DatosDummy.profesor01().getDni());

        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(personaProfesor);
        assertThat(expected.get().getDni()).isEqualTo(personaProfesor.getDni());
    }

    @Test
    @DisplayName("Test: Buscar persona por apellido")
    void buscarPersonasPorApellido()
    {
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        DatosDummy.alumno01(),
                        DatosDummy.alumno02(),
                        DatosDummy.alumno03()
                )
        );

        String apellido = "Benitez";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonasPorApellido(apellido);

        assertThat(expected.size() == 2).isTrue();

    }
}
