package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BuscarFilmeUseCaseTest {

    @Mock
    private FilmeRepository filmeRepository;

//    @InjectMocks
//    private BuscarFilmeUseCaseImpl buscarFilmeUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buscarFilme_Sucesso() {
        String filmeId = "123";
        Filme filme = new Filme();
        filme.setId(filmeId);

        when(filmeRepository.findById(filmeId)).thenReturn(Optional.of(filme));

//        Optional<FilmeResponseDTO> result = buscarFilmeUseCase.executar(filmeId);
//
//        assertTrue(result.isPresent());
//        assertEquals(filmeId, result.get().getId());
//        verify(filmeRepository).findById(filmeId);
    }
}