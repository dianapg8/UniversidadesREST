package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class GenericoDAOImpl <E,R extends CrudRepository<E, Integer>> implements GenericoDAO<E>
{
    protected final R repository;

    public GenericoDAOImpl(R repository)
    {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> buscarPorId(Integer Id) {
        return repository.findById(Id);
    }

    @Override
    @Transactional
    public E guardar(E entidad) {
        return repository.save(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> buscarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void eliminarPorId(Integer Id) {
        repository.deleteById(Id);
    }

}
