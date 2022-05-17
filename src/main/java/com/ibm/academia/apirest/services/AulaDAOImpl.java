package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.enums.TipoPizarron;
import com.ibm.academia.apirest.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO {

    @Autowired
    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulasByTipoPizarron(TipoPizarron tipoPizarron) {
        return repository.findAulasByTipoPizarron(tipoPizarron);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulasByPabellonNombre(String nombre) {
        return repository.findAulasByPabellonNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aula> findAulaByNumeroAula(Integer numeroAula) {
        return repository.findAulaByNumeroAula(numeroAula);
    }

    @Override
    @Transactional
    public Aula actualizar(Aula aulaEncontrada, Aula aula) {
        Aula aulaActualizada = null;
        aulaEncontrada.setNumeroAula(aula.getNumeroAula());
        aulaEncontrada.setCantidadPupitres(aula.getCantidadPupitres());
        aulaActualizada = repository.save(aulaEncontrada);
        return aulaActualizada;
    }
}
