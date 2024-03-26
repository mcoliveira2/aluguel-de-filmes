package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FilmeExistenteValidatorTest {
    @Mock
    private BuscarFilmeUseCase buscarFilmeUseCase;

    @Test
    void validarFilmeExistente_FilmeExistenteComIdDiferente_DeveLancarExcecao() {
        String filmeId = "1";
        String titulo = "Filme Ação";
        Integer anoLancamento = 2022;

        FilmeResponseDTO filmeExistente = new FilmeResponseDTO();
        filmeExistente.setId("2");

        when(buscarFilmeUseCase.executarPorTituloEAnoLancamento(anyString(), anyInt()))
                .thenReturn(Optional.of(filmeExistente));

        assertThrows(ValidacaoException.class, () ->
                FilmeExistenteValidator.validar(titulo, anoLancamento, filmeId, buscarFilmeUseCase));
    }

    @Test
    void validarFilmeExistente_FilmeNaoExistente_DevePassarSemExcecao() {
        String filmeId = "1";
        String titulo = "Filme Ação";
        Integer anoLancamento = 2022;

        when(buscarFilmeUseCase.executarPorTituloEAnoLancamento(anyString(), anyInt()))
                .thenReturn(Optional.empty());

        assertDoesNotThrow(() -> FilmeExistenteValidator.validar(titulo, anoLancamento, filmeId, buscarFilmeUseCase));
    }

    @Test
    void validarFilmeExistente_FilmeExistenteComMesmoId_DevePassarSemExcecao() {
        String filmeId = "1";
        String titulo = "Filme Ação";
        Integer anoLancamento = 2022;

        FilmeResponseDTO filmeExistente = new FilmeResponseDTO();
        filmeExistente.setId("1");

        when(buscarFilmeUseCase.executarPorTituloEAnoLancamento(anyString(), anyInt()))
                .thenReturn(Optional.of(filmeExistente));

        assertDoesNotThrow(() -> FilmeExistenteValidator.validar(titulo, anoLancamento, filmeId, buscarFilmeUseCase));
    }
}