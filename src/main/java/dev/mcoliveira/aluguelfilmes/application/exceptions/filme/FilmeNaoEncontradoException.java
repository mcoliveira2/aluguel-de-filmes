package dev.mcoliveira.aluguelfilmes.application.exceptions.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;

import static dev.mcoliveira.aluguelfilmes.infra.exceptions.MensagensDeErro.ERRO_FILME_NAO_ENCONTRADO;

public class FilmeNaoEncontradoException extends ValidacaoException {
    public FilmeNaoEncontradoException() {
        super(ERRO_FILME_NAO_ENCONTRADO);
    }
}