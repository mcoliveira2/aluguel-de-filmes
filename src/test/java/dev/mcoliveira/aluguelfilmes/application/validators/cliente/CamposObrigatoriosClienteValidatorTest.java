package dev.mcoliveira.aluguelfilmes.application.validators.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CamposObrigatoriosClienteValidatorTest {

    @Test
    void validar_NomeNull_DeveLancarExcecao() {
        ClienteRequestDTO clienteRequestDTO = new ClienteRequestDTO();
        clienteRequestDTO.setEmail("cliente@email.com");

        assertThrows(ValidacaoException.class, () -> CamposObrigatoriosClienteValidator.validar(clienteRequestDTO));
    }

    @Test
    void validar_EmailNull_DeveLancarExcecao() {
        ClienteRequestDTO clienteRequestDTO = new ClienteRequestDTO();
        clienteRequestDTO.setNome("Cliente");

        assertThrows(ValidacaoException.class, () -> CamposObrigatoriosClienteValidator.validar(clienteRequestDTO));
    }
}