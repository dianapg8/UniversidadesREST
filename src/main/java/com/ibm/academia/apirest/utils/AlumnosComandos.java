package com.ibm.academia.apirest.utils;

import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlumnosComandos implements CommandLineRunner
{
    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;

    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    private AlumnoDAO alumnoDAO;

    @Override
    public void run(String... args) throws Exception {

        /*Optional<Persona> alumno = alumnoDAO.buscarPorId(1);

        Optional<Persona> personaDni = personaDAO.buscarPorDni(alumno.get().getDni());
        System.out.println("DNI: " + personaDni);

        Iterable<Persona> personasApellido = personaDAO.buscarPersonasPorApellido(alumno.get().getApellido());
        System.out.println(personasApellido);*/

    }
}
