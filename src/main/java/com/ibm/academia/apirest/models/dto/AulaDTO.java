package com.ibm.academia.apirest.models.dto;

import com.ibm.academia.apirest.enums.TipoPizarron;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AulaDTO {
    private Integer id;

    @Positive
    private Integer numeroAula;

    private TipoPizarron tipoPizarron;
}
