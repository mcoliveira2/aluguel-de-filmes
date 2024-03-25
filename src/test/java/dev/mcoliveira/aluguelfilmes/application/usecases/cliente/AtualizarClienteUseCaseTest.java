package dev.mcoliveira.aluguelfilmes.application.usecases.cliente;

import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AtualizarClienteUseCaseTest {

    @Mock
    private ClienteRepository clienteRepository;
//    @Mock
//    private BuscarClienteUseCaseImpl buscarClienteUseCase;
//    @InjectMocks
//    private AtualizarClienteUseCaseImpl atualizarClienteUseCase;

    @Test
    void atualizarCliente_Successo() {
        String clienteId = "1";
        ClienteRequestDTO clienteRequestDTO = ClienteRequestDTO
                .builder()
                .nome("Novo Cliente")
                .email("novoemail@email.com")
                .build();
        Cliente clienteExistente = Cliente
                .builder()
                .id(clienteId)
                .nome("Nome Antigo")
                .email("antigoemail@email.com")
                .build();

//        when(clienteRepository.findById(clienteId)).thenReturn(Optional.of(clienteExistente));
//        when(clienteRepository.save(any(Cliente.class))).thenAnswer(invocation -> invocation.<Cliente>getArgument(0));
//        ClienteResponseDTO responseDTO = atualizarClienteUseCase.executar(clienteId, clienteRequestDTO);
//
//        assertEquals(clienteId, responseDTO.getId());
//        assertEquals(clienteRequestDTO.getNome(), responseDTO.getNome());
//        assertEquals(clienteRequestDTO.getEmail(), responseDTO.getEmail());
    }
}