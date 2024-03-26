package dev.mcoliveira.aluguelfilmes.application.usecases.cliente.implementations;


import dev.mcoliveira.aluguelfilmes.application.converters.ClienteConverter;
import dev.mcoliveira.aluguelfilmes.application.exceptions.cliente.ClienteNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.mappers.ClienteMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.AtualizarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.BuscarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.cliente.ClienteExistenteValidator;
import dev.mcoliveira.aluguelfilmes.application.validators.cliente.EmailClienteValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarClienteUseCaseImpl implements AtualizarClienteUseCase {

    private final ClienteRepository clienteRepository;
    private final BuscarClienteUseCase buscarClienteUseCase;

    @Autowired
    public AtualizarClienteUseCaseImpl(ClienteRepository clienteRepository, BuscarClienteUseCase buscarClienteUseCase) {
        this.clienteRepository = clienteRepository;
        this.buscarClienteUseCase = buscarClienteUseCase;
    }

    @Override
    public ClienteResponseDTO executar(String id, ClienteRequestDTO clienteRequestDTO) {
        EmailClienteValidator.validar(clienteRequestDTO.getEmail());
        Cliente clienteExistente = clienteRepository.findByIdAndDeletadoFalse(id)
                .orElseThrow(ClienteNaoEncontradoException::new);
        Cliente clienteParaAtualizar = ClienteConverter.toEntityUpdate(clienteRequestDTO, clienteExistente);
        ClienteExistenteValidator.validar(
                clienteParaAtualizar.getEmail(),
                clienteParaAtualizar.getId(),
                buscarClienteUseCase
        );
        return ClienteMapper.toClienteResponseDTO(clienteRepository.save(clienteParaAtualizar));
    }
}