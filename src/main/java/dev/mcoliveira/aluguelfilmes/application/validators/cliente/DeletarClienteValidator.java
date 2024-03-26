package dev.mcoliveira.aluguelfilmes.application.validators.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import org.springframework.stereotype.Component;

import static dev.mcoliveira.aluguelfilmes.application.validators.MensagensDeErro.ERRO_DELETAR_CLIENT_COM_FILME_ALUGADOR;

@Component
public class DeletarClienteValidator {

    public static void validar(String idDoCliente,  AluguelRepository aluguelRepository) {
        if (aluguelRepository.findByIdDoClienteAndDataDaDevolucaoNull(idDoCliente)) {
            throw new ValidacaoException(ERRO_DELETAR_CLIENT_COM_FILME_ALUGADOR);
        }
    }
}