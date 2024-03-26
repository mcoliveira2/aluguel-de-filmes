package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class DisponibilidadeFilmeValidatorTest {

    @Test
    void validarDisponibilidadeFilme_FilmeNaoAlugado_DevePassarSemExcecao() {
        Filme filme = new Filme();
        filme.setDisponivel(true);

        assertDoesNotThrow(() -> DisponibilidadeFilmeValidator.validar(filme));
    }

    @Test
    void validarDisponibilidadeFilme_FilmeAlugado_DeveLancarExcecao() {
        Filme filme = new Filme();
        filme.setDisponivel(false);

        assertThrows(ValidacaoException.class, () -> DisponibilidadeFilmeValidator.validar(filme));
    }
}