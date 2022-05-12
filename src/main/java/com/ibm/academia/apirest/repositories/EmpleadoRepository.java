package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioEmpleado")
public interface EmpleadoRepository extends PersonaRepository {

    @Query("select e from Empleado e where e.tipo = ?1")
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

}