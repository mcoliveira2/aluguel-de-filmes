package dev.mcoliveira.aluguelfilmes.application.usecases.cliente;

import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeletarClienteUseCaseTest {
    @Mock
    private ClienteRepository clienteRepository;
//    @Mock
//    private BuscarClienteUseCaseImpl buscarClienteUseCase;
//    @InjectMocks
//    private DeletarClienteUseCaseImpl deletarClienteUseCase;

    @Test
    public void deletarCliente_Sucesso() {
        String clienteId = "1";
        ClienteResponseDTO cliente = ClienteResponseDTO
                .builder()
                .id(clienteId)
                .build();

//        when(buscarClienteUseCase.executar(clienteId)).thenReturn(cliente);
//        deletarClienteUseCase.executar(clienteId);
//
//        verify(clienteRepository).deleteById(clienteId);
    }
}