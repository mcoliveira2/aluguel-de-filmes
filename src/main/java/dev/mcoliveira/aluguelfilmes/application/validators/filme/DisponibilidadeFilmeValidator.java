package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import org.springframework.stereotype.Component;

@Component
public class DisponibilidadeFilmeValidator {

    private static final String ERRO_FILME_ALUGADO_NAO_PODE_DELETAR =
            "O filme está atualmente alugado e não pode ser excluído.";

    public static void validar(Filme filme) {
        if (Boolean.FALSE.equals(filme.getDisponivel())) {
            throw new ValidacaoException(ERRO_FILME_ALUGADO_NAO_PODE_DELETAR);
        }
    }
}