package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.ValidacaoFilmeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class FilmeValidatorTest {

    private final FilmeValidator filmeValidator = new FilmeValidator();

    @Test
    void validarAnoLancamento_AnoDentroDoIntervalo_NaoDeveLancarExcecao() {
        assertDoesNotThrow(() -> filmeValidator.validarAnoLancamento(LocalDate.now().getYear()));
    }

    @Test
    void validarAnoLancamento_AnoMenorQueLimite_DeveLancarExcecao() {
        assertThrows(ValidacaoFilmeException.class, () -> filmeValidator.validarAnoLancamento(1700));
    }

    @Test
    void validarAnoLancamento_AnoMaiorQueLimite_DeveLancarExcecao() {
        assertThrows(ValidacaoFilmeException.class, () -> filmeValidator.validarAnoLancamento(3000));
    }

    @Test
    void validarAnoLancamento_AnoNulo_NaoDeveLancarExcecao() {
        assertDoesNotThrow(() -> filmeValidator.validarAnoLancamento(null));
    }
}
