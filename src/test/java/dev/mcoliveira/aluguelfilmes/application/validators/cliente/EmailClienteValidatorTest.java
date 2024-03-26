package dev.mcoliveira.aluguelfilmes.application.validators.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class EmailClienteValidatorTest {

    @Test
    void validarEmail_EmailInvalido_DeveLancarExcecao() {
        assertThrows(ValidacaoException.class, () -> EmailClienteValidator.validar("emailinvalido.com"));
        assertThrows(ValidacaoException.class, () -> EmailClienteValidator.validar("emailinvalido@com"));
        assertThrows(ValidacaoException.class, () -> EmailClienteValidator.validar("emailinvalido.com"));
        assertThrows(ValidacaoException.class, () -> EmailClienteValidator.validar("emailinvalido@.com"));
    }

    @Test
    void validarEmail_EmailValido_NaoDeveLancarExcecao() {
        assertDoesNotThrow(() -> EmailClienteValidator.validar("emailvalido@email.com"));
    }
}
