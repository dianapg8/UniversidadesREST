package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Persona;

public interface AlumnoDAO extends PersonaDAO
{
    Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);
}
