package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations.AtualizarFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations.BuscarFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AtualizarFilmeUseCaseTest {

    @Mock
    private FilmeRepository filmeRepository;
    @Mock
    private BuscarFilmeUseCaseImpl buscarFilmeUseCase;
    @InjectMocks
    private AtualizarFilmeUseCaseImpl atualizarFilmeUseCase;

    @Test
    void atualizarFilme_Successo() {
        String filmeId = "1";
        FilmeRequestDTO filmeRequestDTO = FilmeRequestDTO
                .builder()
                .titulo("Novo Título")
                .anoLancamento(2021)
                .build();
        Filme filmeExistente = Filme
                .builder()
                .id(filmeId)
                .titulo("Título Antigo")
                .anoLancamento(2022)
                .build();

        when(filmeRepository.findByIdAndDeletadoFalse(filmeId)).thenReturn(Optional.of(filmeExistente));
        when(filmeRepository.save(any(Filme.class))).thenAnswer(invocation -> invocation.<Filme>getArgument(0));
        FilmeResponseDTO responseDTO = atualizarFilmeUseCase.executar(filmeId, filmeRequestDTO);

        assertEquals(filmeId, responseDTO.getId());
        assertEquals(filmeRequestDTO.getTitulo(), responseDTO.getTitulo());
        assertEquals(filmeRequestDTO.getAnoLancamento(), responseDTO.getAnoLancamento());
    }
}