package com.ibm.academia.apirest;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.services.CarreraDAO;
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

    @Override
    public void run(String... args) throws Exception
    {
        /*Carrera sistemas = new Carrera(null, "ingenieria en sistemas", 65, 6);
        Carrera carreraGuardar = carreraDAO.guardar(sistemas);

        Carrera finanzas = new Carrera(null, "ingenieria en finanzas", 20, 3);
        carreraGuardar = carreraDAO.guardar(finanzas);

        System.out.println(carreraGuardar.toString());*/

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

        /*List<Carrera> carreras = (List<Carrera>) carreraDAO.buscarTodos();
        carreras.forEach(System.out::println);*/

        System.out.println(carreraDAO.buscarPorId(7).orElse(new Carrera()).toString());

        carreraDAO.eliminarPorId(2);
        System.out.println(carreraDAO.buscarPorId(2).orElse(new Carrera()).toString());

    }
}
