package dev.mcoliveira.aluguelfilmes.application.validators.aluguel;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CamposObrigatoriosAluguelValidatorTest {

    @Test
    void validar_IdDoClienteNull_DeveLancarExcecao() {
        AluguelRequestDTO aluguelRequestDTO = new AluguelRequestDTO();
        aluguelRequestDTO.setIdDoFilme("1");

        assertThrows(ValidacaoException.class, () -> CamposObrigatoriosAluguelValidator.validar(aluguelRequestDTO));
    }

    @Test
    void validar_IdDoFilmeNull_DeveLancarExcecao() {
        AluguelRequestDTO aluguelRequestDTO = new AluguelRequestDTO();
        aluguelRequestDTO.setIdDoCliente("1");

        assertThrows(ValidacaoException.class, () -> CamposObrigatoriosAluguelValidator.validar(aluguelRequestDTO));
    }
}