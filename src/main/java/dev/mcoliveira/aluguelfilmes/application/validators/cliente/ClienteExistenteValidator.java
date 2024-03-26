package dev.mcoliveira.aluguelfilmes.application.validators.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.BuscarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteExistenteValidator {

    private static final String ERRO_CLIENTE_EXISTENTE = "Já existe um cliente para este email.";

    public static void validar(String email, String clienteId, BuscarClienteUseCase buscarClienteUseCase) {
        Optional<ClienteResponseDTO> clienteExistente = buscarClienteUseCase.executarPorEmail(email);
        if (clienteExistente.isPresent() && !clienteExistente.get().getId().equals(clienteId)) {
            throw new ValidacaoException(ERRO_CLIENTE_EXISTENTE);
        }
    }

    public static void validar(String email, BuscarClienteUseCase buscarClienteUseCase) {
        Optional<ClienteResponseDTO> clienteExistente = buscarClienteUseCase.executarPorEmail(email);
        if (clienteExistente.isPresent()) {
            throw new ValidacaoException(ERRO_CLIENTE_EXISTENTE);
        }
    }
}