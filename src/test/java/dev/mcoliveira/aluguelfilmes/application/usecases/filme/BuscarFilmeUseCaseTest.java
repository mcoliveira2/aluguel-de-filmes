package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations.BuscarFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarFilmeUseCaseTest {

    @Mock
    private FilmeRepository filmeRepository;
    @InjectMocks
    private BuscarFilmeUseCaseImpl buscarFilmeUseCase;

    @Test
    public void buscarFilme_Sucesso() {
        String filmeId = "123";
        Filme filme = Filme.builder().id("123").build();

        when(filmeRepository.findById(filmeId)).thenReturn(Optional.of(filme));
        FilmeResponseDTO result = buscarFilmeUseCase.executar(filmeId);

        assertEquals(filmeId, result.getId());
        verify(filmeRepository).findById(filmeId);
    }
}