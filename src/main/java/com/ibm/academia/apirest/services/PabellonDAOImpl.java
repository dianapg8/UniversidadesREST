package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Pabellon;
import com.ibm.academia.apirest.repositories.PabellonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository>  implements PabellonDAO
{

    @Autowired
    public PabellonDAOImpl(PabellonRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad) {
        return repository.findPabellonesByDireccionLocalidad(localidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonesByNombre(String nombre) {
        return repository.findPabellonesByNombre(nombre);
    }

    @Override
    @Transactional
    public Pabellon actualizar(Pabellon pabellonEncontrado, Pabellon pabellon) {
        Pabellon pabellonActualizado = null;
        pabellonEncontrado.setNombre(pabellon.getNombre());
        pabellonEncontrado.setAulas(pabellon.getAulas());
        pabellonEncontrado.setDireccion(pabellon.getDireccion());
        pabellonActualizado=repository.save(pabellonEncontrado);

        return pabellonActualizado;
    }
}
