package dev.mcoliveira.aluguelfilmes.application.validators.aluguel;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import org.springframework.stereotype.Component;

import static dev.mcoliveira.aluguelfilmes.infra.exceptions.MensagensDeErro.ERRO_CLINTE_ID_OBRIGATORIO;
import static dev.mcoliveira.aluguelfilmes.infra.exceptions.MensagensDeErro.ERRO_FILME_ID_OBRIGATORIO;
import static java.util.Objects.isNull;

@Component
public class CamposObrigatoriosAluguelValidator {

    public static void validar(AluguelRequestDTO aluguel) {
        if (isNull(aluguel.getIdDoFilme())) {
            throw new ValidacaoException(ERRO_FILME_ID_OBRIGATORIO);
        }
        if (isNull(aluguel.getIdDoCliente())) {
            throw new ValidacaoException(ERRO_CLINTE_ID_OBRIGATORIO);
        }
    }
}