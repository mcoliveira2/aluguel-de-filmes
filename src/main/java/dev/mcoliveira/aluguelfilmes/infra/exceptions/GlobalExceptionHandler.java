package dev.mcoliveira.aluguelfilmes.infra.exceptions;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ErroResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidacaoException.class)
    public ErroResponseDTO validacaoExceptionHandler(ValidacaoException exception) {
        logException(exception);
        return ErroResponseDTO.builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .mensagem(exception.getMessage())
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ErroResponseDTO exceptionHandler(RuntimeException exception) {
        logException(exception);
        return ErroResponseDTO.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensagem("Ocorreu um erro inesperado no servidor. Detalhes do erro: " + exception.getMessage())
                .build();
    }

    private void logException(Exception exception) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.error("Ocorreu um erro no servidor:", exception);
    }
}