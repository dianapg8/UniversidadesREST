package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.AulaDTO;
import com.ibm.academia.apirest.models.entities.Aula;

public class AulaMapper
{
    public static AulaDTO mapperAula(Aula aula){
        return new AulaDTO(
                aula.getId(),
                aula.getNumeroAula(),
                aula.getTipoPizarron()
        );
    }
}
