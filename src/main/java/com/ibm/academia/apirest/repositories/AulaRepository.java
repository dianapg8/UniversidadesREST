package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.enums.TipoPizarron;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {

    Iterable<Aula> findAulasByTipoPizarron(TipoPizarron tipoPizarron);

    Iterable<Aula> findAulasByPabellonNombre(String nombre);

    Optional<Aula> findAulaByNumeroAula(Integer numeroAula);

}
