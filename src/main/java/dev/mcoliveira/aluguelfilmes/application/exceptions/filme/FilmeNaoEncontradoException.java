package dev.mcoliveira.aluguelfilmes.application.exceptions.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;

public class FilmeNaoEncontradoException extends ValidacaoException {
    public FilmeNaoEncontradoException() {
        super("Filme não encontrado");
    }
}