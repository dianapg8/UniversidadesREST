package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.CarreraDTO;
import com.ibm.academia.apirest.models.dto.ProfesorDTO;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.models.entities.Profesor;

import java.util.HashSet;
import java.util.Set;

public class ProfesorMapper
{
    public static ProfesorDTO mapperProfesor(Persona profesor)
    {
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setApellido(profesor.getApellido());
        Set<CarreraDTO> carrerasDTO = new HashSet<>();
        for(Carrera carrera : ((Profesor)profesor).getCarreras()){
            carrerasDTO.add(CarreraMapper.mapCarrera(carrera));
        }
        profesorDTO.setCarreraDTO(carrerasDTO);
        return profesorDTO;
    }
}