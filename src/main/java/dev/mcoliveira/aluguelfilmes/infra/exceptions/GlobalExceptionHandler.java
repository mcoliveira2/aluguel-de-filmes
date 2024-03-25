package dev.mcoliveira.aluguelfilmes.infra.exceptions;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ErroResponseDTO;
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
    public ErroResponseDTO validacaoExceptionHandler(ValidacaoException excecao) {
        return ErroResponseDTO.builder()
                .codigo(HttpStatus.BAD_REQUEST.value())
                .mensagem(excecao.getMessage())
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ErroResponseDTO exceptionHandler(RuntimeException exception) {
        return ErroResponseDTO.builder()
                .codigo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .mensagem("Ocorreu um erro inesperado no servidor. Detalhes do erro: " + exception.getMessage())
                .build();
    }
}