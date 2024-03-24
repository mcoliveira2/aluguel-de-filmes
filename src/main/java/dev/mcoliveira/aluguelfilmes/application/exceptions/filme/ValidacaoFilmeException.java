package dev.mcoliveira.aluguelfilmes.application.exceptions.filme;
public class ValidacaoFilmeException extends RuntimeException {
    public ValidacaoFilmeException(String message) {
        super(message);
    }
}