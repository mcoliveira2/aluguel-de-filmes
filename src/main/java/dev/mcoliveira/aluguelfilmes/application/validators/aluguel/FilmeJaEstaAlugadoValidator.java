package dev.mcoliveira.aluguelfilmes.application.validators.aluguel;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class FilmeJaEstaAlugadoValidator {

    private static final String ERRO_FILME_JA_ESTA_ALUGADO = "O filme já está alugado.";

    public static void validar(String idDoFilme, BuscarFilmeUseCase buscarFilmeUseCase) {
        FilmeResponseDTO filme = buscarFilmeUseCase.executar(idDoFilme);
        if (Boolean.FALSE.equals(filme.getDisponivel())) {
            throw new ValidacaoException(ERRO_FILME_JA_ESTA_ALUGADO);
        }
    }
}