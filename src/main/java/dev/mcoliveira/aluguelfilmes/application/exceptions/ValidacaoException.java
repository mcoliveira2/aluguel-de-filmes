package dev.mcoliveira.aluguelfilmes.application.exceptions;
public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String message) {
        super(message);
    }
}