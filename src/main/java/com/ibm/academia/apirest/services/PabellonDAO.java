package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.models.entities.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon> {
    Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad);
    Iterable<Pabellon> findPabellonesByNombre(String nombre);
    Pabellon actualizar(Pabellon pabellonEncontrado, Pabellon pabellon);
}
