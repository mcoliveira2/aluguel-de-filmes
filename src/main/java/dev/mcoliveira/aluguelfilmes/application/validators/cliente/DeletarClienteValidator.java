package dev.mcoliveira.aluguelfilmes.application.validators.cliente;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import org.springframework.stereotype.Component;

@Component
public class DeletarClienteValidator {
    private static final String ERRO_DELETAR_CLIENT_COM_FILME_ALUGADOR =
            "O cliente não pode ser deletado, pois possui filme alugado";

    public static void validar(String idDoCliente,  AluguelRepository aluguelRepository) {
        if (aluguelRepository.findByIdDoClienteAndDataDaDevolucaoNull(idDoCliente)) {
            throw new ValidacaoException(ERRO_DELETAR_CLIENT_COM_FILME_ALUGADOR);
        }
    }
}