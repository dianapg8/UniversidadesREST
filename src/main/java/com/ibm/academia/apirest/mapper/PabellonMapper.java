package com.ibm.academia.apirest.mapper;

import com.ibm.academia.apirest.models.dto.PabellonDTO;
import com.ibm.academia.apirest.models.entities.Pabellon;

public class PabellonMapper
{
    public static PabellonDTO mapperPabellon(Pabellon pabellon)
    {
        PabellonDTO pabellonDTO = new PabellonDTO();
        pabellonDTO.setId(pabellon.getId());
        pabellonDTO.setNombre(pabellon.getNombre());

        return pabellonDTO;
    }
}
