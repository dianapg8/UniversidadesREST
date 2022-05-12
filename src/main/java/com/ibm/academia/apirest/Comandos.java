package com.ibm.academia.apirest;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Comandos implements CommandLineRunner
{
    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    private PersonaDAO personaDAO;

    @Autowired
    private AlumnoDAO alumnoDAO;

    @Override
    public void run(String... args) throws Exception
    {
        /*Carrera sistemas = new Carrera(null, "ingenieria en sistemas", 65, 6);
        Carrera carreraGuardar = carreraDAO.guardar(sistemas);

        Carrera finanzas = new Carrera(null, "ingenieria en finanzas", 20, 3);
        carreraGuardar = carreraDAO.guardar(finanzas);

        System.out.println(carreraGuardar.toString());

        Carrera carrera = null;

        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(2);
        if(oCarrera.isPresent())
        {
            carrera = oCarrera.get();
            System.out.println(carrera.toString());
        }
        else
        {
            System.out.println("Carrera no encontrada");
        }

        carrera.setCantidadAnios(7);
        carrera.setCantidadMaterias(66);
        carreraDAO.guardar(carrera);

        List<Carrera> carreras = (List<Carrera>) carreraDAO.buscarTodos();
        carreras.forEach(System.out::println);

        System.out.println(carreraDAO.buscarPorId(7).orElse(new Carrera()).toString());

        carreraDAO.eliminarPorId(2);
        System.out.println(carreraDAO.buscarPorId(2).orElse(new Carrera()).toString());

        Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 60, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4);
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos", 33, 3);

        carreraDAO.guardar(ingSistemas);
        carreraDAO.guardar(ingIndustrial);
        carreraDAO.guardar(ingAlimentos);
        carreraDAO.guardar(ingElectronica);
        carreraDAO.guardar(licSistemas);
        carreraDAO.guardar(licTurismo);
        carreraDAO.guardar(licYoga);
        carreraDAO.guardar(licRecursos);

        Direccion direccion = new Direccion("calle 25", "12", "34783", "397", "4", "martin");
        Persona alumno = new Alumno(null, "Mario", "Lopez", "92846873", direccion);

        Persona personaGuardada = alumnoDAO.guardar(alumno);
        System.out.println(personaGuardada.toString());

        direccion = new Direccion("calle 77", "11", "848435", "405", "1", "tijuana");
        alumno = new Alumno(null, "Maria", "de las Nieves", "3856239", direccion);

        personaGuardada = alumnoDAO.guardar(alumno);
        System.out.println(personaGuardada.toString());

        Optional<Carrera> ingSistemas = carreraDAO.buscarPorId(3);

        Iterable<Persona> alumnos = personaDAO.buscarTodos();
        alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSistemas.get()));
        alumnos.forEach(alumno -> personaDAO.guardar(alumno));

        Optional<Carrera> ingSistemas = carreraDAO.buscarPorId(3);
        Iterable<Persona> alumnosCarrera = ((AlumnoDAO)personaDAO).buscarAlumnoPorNombreCarrera(ingSistemas.get().getNombre());
        alumnosCarrera.forEach(System.out::println);

        List<Carrera> carreras = (List<Carrera>)carreraDAO.findCarrerasByNombreContains("Sistemas");
        carreras.forEach(System.out::println);

        List<Carrera> carrerasIgnoreCase1 = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase("SISTEMAS");
        List<Carrera> carrerasIgnoreCase2 = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase("sistemas");

        carrerasIgnoreCase1.forEach(System.out::println);
        carrerasIgnoreCase2.forEach(System.out::println);

        List<Carrera> carreraPorAnio = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(3);
        carreraPorAnio.forEach(System.out::println);

        Optional<Persona> persona = personaDAO.buscarPorId(2);
        System.out.println(persona.toString());*/

    }
}
