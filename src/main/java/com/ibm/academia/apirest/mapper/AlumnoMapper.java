package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.AlumnoDTO;
import com.ibm.academia.apirest.models.entities.Alumno;
import com.ibm.academia.apirest.models.entities.Persona;

public class AlumnoMapper
{
    public static AlumnoDTO mapperAlumno(Persona alumno)
    {
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setId(alumno.getId());
        alumnoDTO.setNombre(alumno.getNombre());
        alumnoDTO.setApellido(alumno.getApellido());
        alumnoDTO.setCarrera(CarreraMapper.mapCarrera(((Alumno)alumno).getCarrera()));

        return alumnoDTO;

    }
}