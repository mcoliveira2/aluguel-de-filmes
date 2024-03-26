package dev.mcoliveira.aluguelfilmes.application.validators.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.BuscarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteExistenteValidatorTest {
    @Mock
    private BuscarClienteUseCase buscarClienteUseCase;

    @Test
    void validarClienteExistente_ClienteExistenteComIdDiferente_DeveLancarExcecao() {
        String clienteId = "1";
        String email = "cliente@email.com";

        ClienteResponseDTO clienteExistente = new ClienteResponseDTO();
        clienteExistente.setId("2");

        when(buscarClienteUseCase.executarPorEmail(anyString())).thenReturn(Optional.of(clienteExistente));

        assertThrows(ValidacaoException.class, () ->
                ClienteExistenteValidator.validar(email, clienteId, buscarClienteUseCase));
    }

    @Test
    void validarClienteExistente_CLienteNaoExistente_DevePassarSemExcecao() {
        String clienteId = "1";
        String email = "cliente@email.com";

        when(buscarClienteUseCase.executarPorEmail(anyString())).thenReturn(Optional.empty());

        assertDoesNotThrow(() -> ClienteExistenteValidator.validar(email, clienteId, buscarClienteUseCase));
    }

    @Test
    void validarClienteExistente_ClienteExistenteComMesmoId_DevePassarSemExcecao() {
        String clienteId = "1";
        String email = "cliente@email.com";

        ClienteResponseDTO clienteExistente = new ClienteResponseDTO();
        clienteExistente.setId("1");

        when(buscarClienteUseCase.executarPorEmail(anyString())).thenReturn(Optional.of(clienteExistente));

        assertDoesNotThrow(() -> ClienteExistenteValidator.validar(email, clienteId, buscarClienteUseCase));
    }
}