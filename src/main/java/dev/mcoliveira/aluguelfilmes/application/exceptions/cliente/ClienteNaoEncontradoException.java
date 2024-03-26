package dev.mcoliveira.aluguelfilmes.application.exceptions.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;

public class ClienteNaoEncontradoException extends ValidacaoException {
    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado");
    }
}