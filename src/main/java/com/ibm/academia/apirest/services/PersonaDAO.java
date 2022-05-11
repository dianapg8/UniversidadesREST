package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>
{
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);

    Optional<Persona> buscarPorDni(String dni);

    Iterable<Persona> buscarPersonasPorApellido(String apelllido);
}
