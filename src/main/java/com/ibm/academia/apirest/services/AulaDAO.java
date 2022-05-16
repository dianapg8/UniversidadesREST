package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.TipoPizarron;

import java.util.Optional;

public interface AulaDAO extends GenericoDAO<Aula>
{
    Iterable<Aula> findAulasByTipoPizarron(TipoPizarron tipoPizarron);
    Iterable<Aula> findAulasByPabellonNombre(String nombre);
    Optional<Aula> findAulaByNumeroAula(Integer numeroAula);
    Aula actualizar(Aula aulaEncontrada, Aula aula);
}
