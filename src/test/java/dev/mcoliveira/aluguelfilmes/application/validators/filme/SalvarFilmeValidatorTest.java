package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.ValidacaoFilmeException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.domain.enums.Genero;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SalvarFilmeValidatorTest {

    @Mock
    private BuscarFilmeUseCase buscarFilmeUseCase;

    @InjectMocks
    private SalvarFilmeValidator salvarFilmeValidator;

    @Test
    void validar_TituloNull_DeveLancarExcecao() {
        FilmeRequestDTO filmeRequestDTO = new FilmeRequestDTO();
        filmeRequestDTO.setAnoLancamento(2022);
        filmeRequestDTO.setGenero(Genero.ACAO);

        assertThrows(ValidacaoFilmeException.class, () -> salvarFilmeValidator.validar(filmeRequestDTO));
    }

    @Test
    void validar_AnoLancamentoNull_DeveLancarExcecao() {
        FilmeRequestDTO filmeRequestDTO = new FilmeRequestDTO();
        filmeRequestDTO.setTitulo("Filme Ação");
        filmeRequestDTO.setGenero(Genero.ACAO);

        assertThrows(ValidacaoFilmeException.class, () -> salvarFilmeValidator.validar(filmeRequestDTO));
    }

    @Test
    void validar_GeneroNull_DeveLancarExcecao() {
        FilmeRequestDTO filmeRequestDTO = new FilmeRequestDTO();
        filmeRequestDTO.setTitulo("Filme Ação");
        filmeRequestDTO.setAnoLancamento(2022);

        assertThrows(ValidacaoFilmeException.class, () -> salvarFilmeValidator.validar(filmeRequestDTO));
    }

    @Test
    void validar_FilmeExistente_DeveLancarExcecao() {
        FilmeRequestDTO filmeRequestDTO = new FilmeRequestDTO();
        filmeRequestDTO.setTitulo("Filme Ação");
        filmeRequestDTO.setAnoLancamento(2022);
        filmeRequestDTO.setGenero(Genero.ACAO);

        when(buscarFilmeUseCase.executarPorTituloEAnoLancamento(anyString(), anyInt())).thenReturn(Optional.of(new FilmeResponseDTO()));

        assertThrows(ValidacaoFilmeException.class, () -> salvarFilmeValidator.validar(filmeRequestDTO));
    }
}