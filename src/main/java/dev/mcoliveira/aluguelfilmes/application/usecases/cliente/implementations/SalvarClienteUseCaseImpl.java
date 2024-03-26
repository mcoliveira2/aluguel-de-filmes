package dev.mcoliveira.aluguelfilmes.application.usecases.cliente.implementations;

import dev.mcoliveira.aluguelfilmes.application.converters.ClienteConverter;
import dev.mcoliveira.aluguelfilmes.application.mappers.ClienteMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.BuscarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.SalvarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.cliente.CamposObrigatoriosClienteValidator;
import dev.mcoliveira.aluguelfilmes.application.validators.cliente.ClienteExistenteValidator;
import dev.mcoliveira.aluguelfilmes.application.validators.cliente.EmailClienteValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarClienteUseCaseImpl implements SalvarClienteUseCase {

    private final ClienteRepository clienteRepository;
    private final BuscarClienteUseCase buscarClienteUseCase;

    @Autowired
    public SalvarClienteUseCaseImpl(ClienteRepository clienteRepository, BuscarClienteUseCase buscarClienteUseCase) {
        this.clienteRepository = clienteRepository;
        this.buscarClienteUseCase = buscarClienteUseCase;
    }

    @Override
    public ClienteResponseDTO executar(ClienteRequestDTO clienteRequestDTO) {
        validarClienteAntesDeSalvar(clienteRequestDTO);
        Cliente cliente = ClienteConverter.toEntity(clienteRequestDTO);
        return ClienteMapper.toClienteResponseDTO(clienteRepository.save(cliente));
    }

    private void validarClienteAntesDeSalvar(ClienteRequestDTO clienteRequestDTO) {
        CamposObrigatoriosClienteValidator.validar(clienteRequestDTO);
        EmailClienteValidator.validar(clienteRequestDTO.getEmail());
        ClienteExistenteValidator.validar(clienteRequestDTO.getEmail(), buscarClienteUseCase);
    }
}