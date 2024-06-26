package dev.mcoliveira.aluguelfilmes.application.usecases.cliente;

import dev.mcoliveira.aluguelfilmes.application.converters.ClienteConverter;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.implementations.BuscarClienteUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.implementations.SalvarClienteUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SalvarClienteUseCaseTest {

    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private BuscarClienteUseCaseImpl buscarClienteUseCase;
    @InjectMocks
    private SalvarClienteUseCaseImpl salvarClienteUseCase;

    @Test
    void salvarCliente_Successo() {
        ClienteRequestDTO clienteRequestDTO = ClienteRequestDTO
                .builder()
                .nome("Cliente")
                .email("cliente@email.com")
                .build();

        Cliente clienteSalvo = ClienteConverter.toEntity(clienteRequestDTO);
        clienteSalvo.setId("1");

        when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteSalvo);

        ClienteResponseDTO response = salvarClienteUseCase.executar(clienteRequestDTO);

        assertNotNull(response);
        assertEquals(clienteSalvo.getId(), response.getId());
        assertEquals(clienteRequestDTO.getNome(), response.getNome());
        assertEquals(clienteRequestDTO.getEmail(), response.getEmail());
    }
}