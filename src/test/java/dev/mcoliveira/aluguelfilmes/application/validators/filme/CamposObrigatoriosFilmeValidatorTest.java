package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.domain.enums.Genero;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CamposObrigatoriosFilmeValidatorTest {
    @Test
    void validar_TituloNull_DeveLancarExcecao() {
        FilmeRequestDTO filmeRequestDTO = new FilmeRequestDTO();
        filmeRequestDTO.setAnoLancamento(2022);
        filmeRequestDTO.setGenero(Genero.ACAO);

        assertThrows(ValidacaoException.class, () -> CamposObrigatoriosFilmeValidator.validar(filmeRequestDTO));
    }

    @Test
    void validar_AnoLancamentoNull_DeveLancarExcecao() {
        FilmeRequestDTO filmeRequestDTO = new FilmeRequestDTO();
        filmeRequestDTO.setTitulo("Filme Ação");
        filmeRequestDTO.setGenero(Genero.ACAO);

        assertThrows(ValidacaoException.class, () -> CamposObrigatoriosFilmeValidator.validar(filmeRequestDTO));
    }

    @Test
    void validar_GeneroNull_DeveLancarExcecao() {
        FilmeRequestDTO filmeRequestDTO = new FilmeRequestDTO();
        filmeRequestDTO.setTitulo("Filme Ação");
        filmeRequestDTO.setAnoLancamento(2022);

        assertThrows(ValidacaoException.class, () -> CamposObrigatoriosFilmeValidator.validar(filmeRequestDTO));
    }
}