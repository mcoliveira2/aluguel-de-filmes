package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AnoLancamentoFilmeValidatorTest {

    @Test
    void validarAnoLancamento_AnoDentroDoIntervalo_NaoDeveLancarExcecao() {
        assertDoesNotThrow(() -> AnoLancamentoFilmeValidator.validar(LocalDate.now().getYear()));
    }

    @Test
    void validarAnoLancamento_AnoMenorQueLimite_DeveLancarExcecao() {
        assertThrows(ValidacaoException.class, () -> AnoLancamentoFilmeValidator.validar(1700));
    }

    @Test
    void validarAnoLancamento_AnoMaiorQueLimite_DeveLancarExcecao() {
        assertThrows(ValidacaoException.class, () -> AnoLancamentoFilmeValidator.validar(3000));
    }

    @Test
    void validarAnoLancamento_AnoNulo_NaoDeveLancarExcecao() {
        assertDoesNotThrow(() -> AnoLancamentoFilmeValidator.validar(null));
    }
}
