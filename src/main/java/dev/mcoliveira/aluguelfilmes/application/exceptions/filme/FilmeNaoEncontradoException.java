package dev.mcoliveira.aluguelfilmes.application.exceptions.filme;

public class FilmeNaoEncontradoException extends RuntimeException {
    public FilmeNaoEncontradoException() {
        super("Filme não encontrado");
    }
}