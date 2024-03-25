package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class CamposObrigatoriosFilmeValidator  {

    private static final String ERRO_TITULO_OBRIGATORIO = "O 'título' do filme é obrigatório.";
    private static final String ERRO_ANO_LANCAMENTO_OBRIGATORIO = "O 'ano de lançamento' do filme é obrigatório.";
    private static final String ERRO_GENERO_OBRIGATORIO = "O 'gênero' do filme é obrigatório.";

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