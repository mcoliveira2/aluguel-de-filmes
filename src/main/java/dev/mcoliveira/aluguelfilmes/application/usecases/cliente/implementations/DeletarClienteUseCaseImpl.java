package dev.mcoliveira.aluguelfilmes.application.usecases.cliente.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.cliente.ClienteNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.DeletarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.cliente.DeletarClienteValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarClienteUseCaseImpl implements DeletarClienteUseCase {

    private final ClienteRepository clienteRepository;
    private final AluguelRepository aluguelRepository;

    @Autowired
    public DeletarClienteUseCaseImpl(ClienteRepository clienteRepository, AluguelRepository aluguelRepository) {
        this.clienteRepository = clienteRepository;
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public void executar(String clienteId) {
        DeletarClienteValidator.validar(clienteId, aluguelRepository);
        Cliente cliente = clienteRepository.findByIdAndDeletadoFalse(clienteId)
                .orElseThrow(ClienteNaoEncontradoException::new);
        cliente.setDeletado(true);
        clienteRepository.save(cliente);
    }
}