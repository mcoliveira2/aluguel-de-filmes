package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import org.springframework.stereotype.Component;

import static dev.mcoliveira.aluguelfilmes.application.validators.MensagensDeErro.*;

@Component
public class CamposObrigatoriosFilmeValidator  {

    public static void validar(FilmeRequestDTO filme) {
        if (filme.getTitulo() == null || filme.getTitulo().isEmpty()) {
            throw new ValidacaoException(ERRO_TITULO_OBRIGATORIO);
        }
        if (filme.getAnoLancamento() == null) {
            throw new ValidacaoException(ERRO_ANO_LANCAMENTO_OBRIGATORIO);
        }
        if (filme.getGenero() == null) {
            throw new ValidacaoException(ERRO_GENERO_OBRIGATORIO);
        }
    }
}