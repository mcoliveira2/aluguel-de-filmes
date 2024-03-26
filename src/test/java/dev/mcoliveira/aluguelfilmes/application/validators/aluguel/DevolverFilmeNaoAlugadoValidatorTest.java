package dev.mcoliveira.aluguelfilmes.application.validators.aluguel;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DevolverFilmeNaoAlugadoValidatorTest {
    @Mock
    private BuscarFilmeUseCase buscarFilmeUseCase;

    @Test
    void validarDevolverFilme_FilmeDisponivel_DeveLancarExcecao() {
        String filmeId = "1";
        FilmeResponseDTO filme = FilmeResponseDTO.builder()
                .id(filmeId)
                .disponivel(true)
                .build();

        when(buscarFilmeUseCase.executar(filmeId)).thenReturn(filme);

        assertThrows(ValidacaoException.class, () -> DevolverFilmeNaoAlugadoValidator.validar(filmeId, buscarFilmeUseCase));
    }

    @Test
    void validarDevolverFilme_FilmeNaoDisponivel_NaoDeveLancarExcecao() {
        String filmeId = "1";
        FilmeResponseDTO filme = FilmeResponseDTO.builder()
                .id(filmeId)
                .disponivel(false)
                .build();

        when(buscarFilmeUseCase.executar(filmeId)).thenReturn(filme);

        assertDoesNotThrow(() -> DevolverFilmeNaoAlugadoValidator.validar(filmeId, buscarFilmeUseCase));
    }
}