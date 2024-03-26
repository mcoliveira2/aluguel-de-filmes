package dev.mcoliveira.aluguelfilmes.application.exceptions.aluguel;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;

import static dev.mcoliveira.aluguelfilmes.application.validators.MensagensDeErro.ERRO_ALUGUEL_NAO_ENCONTRADO;

public class AluguelNaoEncontradoException extends ValidacaoException {
    public AluguelNaoEncontradoException() {
        super(ERRO_ALUGUEL_NAO_ENCONTRADO);
    }
}