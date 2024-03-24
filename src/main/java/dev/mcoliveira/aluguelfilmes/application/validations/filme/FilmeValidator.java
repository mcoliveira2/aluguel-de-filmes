package dev.mcoliveira.aluguelfilmes.application.validations.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.ValidacaoFilmeException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.util.Objects.nonNull;

@Component
public class FilmeValidator {

    private static final int ANO_MINIMO = 1800;
    private static final int ANO_MAXIMO = LocalDate.now().getYear();

    public void validarAnoLancamento(Integer ano) {
        if (nonNull(ano) && (ano < ANO_MINIMO || ano > ANO_MAXIMO)) {
            throw new ValidacaoFilmeException("O 'ano de lançamento' deve estar entre " + ANO_MINIMO + " e " + ANO_MAXIMO);
        }
    }
}