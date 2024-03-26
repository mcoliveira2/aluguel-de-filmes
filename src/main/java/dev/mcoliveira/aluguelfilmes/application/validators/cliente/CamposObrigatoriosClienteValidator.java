package dev.mcoliveira.aluguelfilmes.application.validators.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class CamposObrigatoriosClienteValidator {

    private static final String ERRO_NOME_OBRIGATORIO = "O 'nome' do cliente é obrigatório.";
    private static final String ERRO_EMAIL_OBRIGATORIO = "O 'email' do cliente é obrigatório.";

    public static void validar(ClienteRequestDTO cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new ValidacaoException(ERRO_NOME_OBRIGATORIO);
        }
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            throw new ValidacaoException(ERRO_EMAIL_OBRIGATORIO);
        }
    }
}