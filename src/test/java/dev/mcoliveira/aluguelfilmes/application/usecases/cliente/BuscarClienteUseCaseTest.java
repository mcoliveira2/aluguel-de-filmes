package dev.mcoliveira.aluguelfilmes.application.usecases.cliente;

import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BuscarClienteUseCaseTest {

    @Mock
    private ClienteRepository clienteRepository;
//    @InjectMocks
//    private BuscarClienteUseCaseImpl buscarClienteUseCase;

    @Test
    public void buscarCliente_Sucesso() {
        String clienteId = "123";
        Cliente cliente = Cliente
                .builder()
                .id("123")
                .build();

//        when(clienteRepository.findById(clienteId)).thenReturn(Optional.of(cliente));
//        ClienteResponseDTO result = buscarClienteUseCase.executar(clienteId);
//
//        assertEquals(clienteId, result.getId());
//        verify(clienteRepository).findById(clienteId);
    }

    @Test
    public void buscarClientePeloEmail_Sucesso() {
        Cliente cliente = Cliente
                .builder()
                .id("123")
                .nome("Cliente")
                .email("email@email.com")
                .build();

//        when(clienteRepository.findByEmail(anyString())).thenReturn(Optional.of(cliente));
//        Optional<ClienteResponseDTO> result =
//                buscarClienteUseCase.executarPorEmail(cliente.getNome());
//
//        assertEquals(cliente.getId(), result.get().getId());
//        verify(clienteRepository).findByEmail(cliente.getNome());
    }
}