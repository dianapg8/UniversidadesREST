package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.enums.TipoPizarron;
import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.repositories.AulaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class AulaDAOImplTest
{
    AulaDAO aulaDAO;
    AulaRepository aulaRepository;

    @BeforeEach
    void setUp() {
        aulaRepository = mock(AulaRepository.class);
        aulaDAO = new AulaDAOImpl(aulaRepository);
    }

    @Test
    void findAulasByTipoPizarron() {
        when(aulaRepository.findAulasByTipoPizarron(TipoPizarron.PIZARRA_TIZA))
                .thenReturn(List.of(DatosDummy.aula02()));

        List<Aula> aulasTiza = (List<Aula>) aulaDAO.findAulasByTipoPizarron(TipoPizarron.PIZARRA_TIZA);

        assertThat(aulasTiza.size()).isGreaterThan(0);
        assertThat(aulasTiza.get(0)).isEqualTo(DatosDummy.aula02());

        verify(aulaRepository).findAulasByTipoPizarron(TipoPizarron.PIZARRA_TIZA);
    }

    @Test
    void findAulasByPabellonNombre() {
        when(aulaRepository.findAulasByPabellonNombre("PabellonUno"))
                .thenReturn(List.of(DatosDummy.aula01()));

        List<Aula> aulaPabellon = (List<Aula>) aulaDAO.findAulasByPabellonNombre("PabellonUno");
        assertThat(aulaPabellon.get(0)).isEqualTo(DatosDummy.aula01());

        verify(aulaRepository).findAulasByPabellonNombre("PabellonUno");
    }
}
