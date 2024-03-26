package dev.mcoliveira.aluguelfilmes.application.exceptions.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;

import static dev.mcoliveira.aluguelfilmes.application.validators.MensagensDeErro.ERRO_CLIENTE_NAO_ENCONTRADO;

public class ClienteNaoEncontradoException extends ValidacaoException {
    public ClienteNaoEncontradoException() {
        super(ERRO_CLIENTE_NAO_ENCONTRADO);
    }
}