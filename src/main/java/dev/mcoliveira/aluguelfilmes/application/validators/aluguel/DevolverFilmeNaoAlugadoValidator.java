package dev.mcoliveira.aluguelfilmes.application.validators.aluguel;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.stereotype.Component;

import static dev.mcoliveira.aluguelfilmes.application.validators.MensagensDeErro.ERRO_FILME_NAO_ALUGADO;

@Component
public class DevolverFilmeNaoAlugadoValidator {

    public static void validar(String idDoFilme, BuscarFilmeUseCase buscarFilmeUseCase) {
        FilmeResponseDTO filme = buscarFilmeUseCase.executar(idDoFilme);
        if (Boolean.TRUE.equals(filme.getDisponivel())) {
            throw new ValidacaoException(ERRO_FILME_NAO_ALUGADO);
        }
    }
}