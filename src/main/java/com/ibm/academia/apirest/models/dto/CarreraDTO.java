package com.ibm.academia.apirest.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO
{
    private Integer id;

    @NotNull(message = "El nombre no debe ser nulo")
    @NotEmpty(message = "El nombre no debe estar vacio")
    @Size(min = 5, max = 80)
    private String nombre;

    @Positive(message = "Cantidad de materias debe ser mayor a cero")
    private Integer cantidadMaterias;

    @Positive(message = "Cantidad de años debe ser mayor a cero")
    private Integer cantidadAnios;
}
