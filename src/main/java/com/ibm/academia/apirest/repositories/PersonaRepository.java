package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer>
{
    @Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);

    @Query("select p from Persona p where p.dni = ?1")
    Optional<Persona> buscarPorDni(String dni);

    @Query("select p from Persona p where p.apellido = ?1")
    Iterable<Persona> buscarPersonasPorApellido(String apellido);

    @Query(value = "select * from universidad.personas where id = ?1", nativeQuery = true)
    public Persona buscarAlumnoPorId(Integer Id);

}
