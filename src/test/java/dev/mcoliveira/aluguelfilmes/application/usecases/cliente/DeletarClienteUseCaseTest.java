package dev.mcoliveira.aluguelfilmes.application.usecases.cliente;

import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.implementations.DeletarClienteUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeletarClienteUseCaseTest {
    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private AluguelRepository aluguelRepository;
    @InjectMocks
    private DeletarClienteUseCaseImpl deletarClienteUseCase;

    @Test
    public void deletarCliente_Sucesso() {
        String clienteId = "1";
        Cliente cliente = Cliente
                .builder()
                .id(clienteId)
                .build();

        when(aluguelRepository.findByIdDoClienteAndDataDaDevolucaoNull(clienteId))
                .thenReturn(false);
        when(clienteRepository.findByIdAndDeletadoFalse(clienteId)).thenReturn(Optional.ofNullable(cliente));
        deletarClienteUseCase.executar(clienteId);

        verify(clienteRepository).save(cliente);
    }
}