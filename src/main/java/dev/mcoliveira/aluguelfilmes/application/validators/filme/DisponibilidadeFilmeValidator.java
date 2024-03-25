package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class DisponibilidadeFilmeValidator {

    private static final String ERRO_FILME_ALUGADO_NAO_PODE_DELETAR =
            "O filme está atualmente alugado e não pode ser excluído.";

    public static void validar(String filmeId, BuscarFilmeUseCase buscarFilmeUseCase) {
        FilmeResponseDTO filme = buscarFilmeUseCase.executar(filmeId);
        if (Boolean.FALSE.equals(filme.getDisponivel())) {
            throw new ValidacaoException(ERRO_FILME_ALUGADO_NAO_PODE_DELETAR);
        }
    }
}