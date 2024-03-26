package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import org.springframework.stereotype.Component;

import static dev.mcoliveira.aluguelfilmes.application.validators.MensagensDeErro.ERRO_FILME_ALUGADO_NAO_PODE_DELETAR;

@Component
public class DisponibilidadeFilmeValidator {

    public static void validar(Filme filme) {
        if (Boolean.FALSE.equals(filme.getDisponivel())) {
            throw new ValidacaoException(ERRO_FILME_ALUGADO_NAO_PODE_DELETAR);
        }
    }
}