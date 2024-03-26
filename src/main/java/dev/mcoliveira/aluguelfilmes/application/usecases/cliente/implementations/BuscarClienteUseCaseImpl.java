package dev.mcoliveira.aluguelfilmes.application.usecases.cliente.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.cliente.ClienteNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.mappers.ClienteMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.BuscarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarClienteUseCaseImpl implements BuscarClienteUseCase {

    private final ClienteRepository clienteRepository;

    @Autowired
    public BuscarClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponseDTO executar(String id) {
        return clienteRepository.findByIdAndDeletadoFalse(id)
                .map(ClienteMapper::toClienteResponseDTO)
                .orElseThrow(ClienteNaoEncontradoException::new);
    }

    @Override
    public Optional<ClienteResponseDTO> executarPorEmail(String email) {
        return clienteRepository.findByEmailAndDeletadoFalse(email)
                .map(ClienteMapper::toClienteResponseDTO);
    }
}