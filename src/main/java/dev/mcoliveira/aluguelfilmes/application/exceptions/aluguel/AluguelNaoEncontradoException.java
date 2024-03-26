package dev.mcoliveira.aluguelfilmes.application.exceptions.aluguel;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;

public class AluguelNaoEncontradoException extends ValidacaoException {
    public AluguelNaoEncontradoException() {
        super("Aluguel não encontrado");
    }
}