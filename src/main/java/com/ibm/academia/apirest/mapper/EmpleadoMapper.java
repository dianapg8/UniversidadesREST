package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.EmpleadoDTO;
import com.ibm.academia.apirest.models.entities.Empleado;
import com.ibm.academia.apirest.models.entities.Persona;

public class EmpleadoMapper
{
    public static EmpleadoDTO mapperEmpleado(Persona empleado)
    {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setId(empleado.getId());
        empleadoDTO.setNombre(empleado.getNombre());
        empleadoDTO.setApellido(empleado.getApellido());
        empleadoDTO.setTipoEmpleado(((Empleado)empleado).getTipoEmpleado());

        return empleadoDTO;

    }
}