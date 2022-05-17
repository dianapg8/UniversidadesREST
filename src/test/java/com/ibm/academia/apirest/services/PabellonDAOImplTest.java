package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Pabellon;
import com.ibm.academia.apirest.repositories.PabellonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class PabellonDAOImplTest
{
    PabellonDAO pabellonDAO;
    PabellonRepository pabellonRepository;

    @BeforeEach
    void setUp() {
        pabellonRepository = mock(PabellonRepository.class);
        pabellonDAO = new PabellonDAOImpl(pabellonRepository);
    }

    @Test
    void findPabellonesByDireccionLocalidad() {
        when(pabellonRepository.findPabellonesByDireccionLocalidad("Pachuca"))
                .thenReturn(List.of(DatosDummy.pabellon01(),DatosDummy.pabellon02(),
                        DatosDummy.pabellon03()));
        List<Pabellon> pabellones = (List<Pabellon>) pabellonDAO.findPabellonesByDireccionLocalidad("Pachuca");
        assertThat(pabellones.size()).isEqualTo(3);
        verify(pabellonRepository).findPabellonesByDireccionLocalidad("Pachuca");
    }

    @Test
    void findPabellonesByNombre() {
        when(pabellonRepository.findPabellonesByNombre("PabellonDos"))
                .thenReturn(List.of(DatosDummy.pabellon02()));
        List<Pabellon> pabellones = (List<Pabellon>) pabellonDAO.findPabellonesByNombre("PabellonDos");
        assertThat(pabellones.size()).isGreaterThan(0);
        assertThat(pabellones.get(0)).isEqualTo(DatosDummy.pabellon02());
        verify(pabellonRepository).findPabellonesByNombre("PabellonDos");
    }
}
