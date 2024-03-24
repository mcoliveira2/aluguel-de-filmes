package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.application.converters.FilmeConverter;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations.SalvarFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.domain.enums.Genero;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SalvarFilmeUseCaseTest {

    @Mock
    private FilmeRepository filmeRepository;

    @InjectMocks
    private SalvarFilmeUseCaseImpl salvarFilmeUseCase;

    @Test
    void salvarFilme_Successo() {
        FilmeRequestDTO filmeRequestDTO = FilmeRequestDTO
                .builder()
                .titulo("Título filme")
                .anoLancamento(1990)
                .genero(Genero.ACAO)
                .diretor("Diretor")
                .build();

        Filme filmeSalvo = FilmeConverter.toEntity(filmeRequestDTO);
        filmeSalvo.setId("1");

        when(filmeRepository.save(any(Filme.class))).thenReturn(filmeSalvo);

        FilmeResponseDTO response = salvarFilmeUseCase.executar(filmeRequestDTO);

        assertNotNull(response);
        assertEquals(filmeSalvo.getId(), response.getId());
        assertEquals(filmeRequestDTO.getTitulo(), response.getTitulo());
        assertEquals(filmeRequestDTO.getAnoLancamento(), response.getAnoLancamento());
    }
}