package dev.mcoliveira.aluguelfilmes.application.validators.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import org.springframework.stereotype.Component;

import static dev.mcoliveira.aluguelfilmes.infra.exceptions.MensagensDeErro.ERRO_EMAIL_OBRIGATORIO;
import static dev.mcoliveira.aluguelfilmes.infra.exceptions.MensagensDeErro.ERRO_NOME_OBRIGATORIO;

@Component
public class CamposObrigatoriosClienteValidator {

    public static void validar(ClienteRequestDTO cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new ValidacaoException(ERRO_NOME_OBRIGATORIO);
        }
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            throw new ValidacaoException(ERRO_EMAIL_OBRIGATORIO);
        }
    }
}