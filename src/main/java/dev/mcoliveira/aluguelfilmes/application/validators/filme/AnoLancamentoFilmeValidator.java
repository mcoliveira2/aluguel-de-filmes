package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.util.Objects.nonNull;

@Component
public class AnoLancamentoFilmeValidator {

    private static final int ANO_MINIMO = 1800;
    private static final int ANO_MAXIMO = LocalDate.now().getYear();
    private static final String ERRO_ANO_LANCAMENTO_INVALIDO =
            "O 'ano de lançamento' do filme deve estar entre " + ANO_MINIMO + " e " + ANO_MAXIMO;

    public static void validar(Integer ano) {
        if (nonNull(ano) && (ano < ANO_MINIMO || ano > ANO_MAXIMO)) {
            throw new ValidacaoException(ERRO_ANO_LANCAMENTO_INVALIDO);
        }
    }
}