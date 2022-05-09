package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarreraDAOImpl implements CarreraDAO
{
    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Carrera> buscarPorId(Integer Id) {
        return carreraRepository.findById(Id);
    }

    @Override
    @Transactional
    public Carrera guardar(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> buscarTodos() {
        return carreraRepository.findAll();
    }

    @Override
    @Transactional
    public void eliminarPorId(Integer Id)
    {
        carreraRepository.deleteById(Id);

    }
}
