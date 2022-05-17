package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Empleado;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.repositories.EmpleadoRepository;
import com.ibm.academia.apirest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {

    @Autowired
    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleado") PersonaRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository) repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }

    @Override
    @Transactional
    public Persona actualizar(Persona empleadoEncontrado, Persona empleado) {
        Persona empleadoActualizado = null;
        empleadoEncontrado.setNombre(empleado.getNombre());
        empleadoEncontrado.setApellido(empleado.getApellido());
        empleadoEncontrado.setDireccion(empleado.getDireccion());
        ((Empleado)empleadoEncontrado).setSueldo(((Empleado)empleado).getSueldo());
        empleadoActualizado=repository.save(empleadoEncontrado);
        return empleadoActualizado;
    }
}
