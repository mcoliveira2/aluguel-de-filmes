package dev.mcoliveira.aluguelfilmes.application.usecases.cliente.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.cliente.ClienteNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.DeletarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarClienteUseCaseImpl implements DeletarClienteUseCase {

    private final ClienteRepository clienteRepository;

    @Autowired
    public DeletarClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void executar(String clienteId) {
        //TODO criar validação se o cliente possui filme alugado nao pode deletar
        clienteRepository.findById(clienteId).orElseThrow(ClienteNaoEncontradoException::new);
        clienteRepository.deleteById(clienteId);
    }
}