package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static dev.mcoliveira.aluguelfilmes.infra.exceptions.MensagensDeErro.ERRO_ANO_LANCAMENTO_INVALIDO;
import static java.util.Objects.nonNull;

@Component
public class AnoLancamentoFilmeValidator {

    private static final int ANO_MINIMO = 1800;
    private static final int ANO_MAXIMO = LocalDate.now().getYear();

    public static void validar(Integer ano) {
        if (nonNull(ano) && (ano < ANO_MINIMO || ano > ANO_MAXIMO)) {
            throw new ValidacaoException(String.format(ERRO_ANO_LANCAMENTO_INVALIDO, ANO_MINIMO, ANO_MAXIMO));
        }
    }
}