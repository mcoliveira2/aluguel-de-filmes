package dev.mcoliveira.aluguelfilmes.application.usecases.aluguel;

import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.implementations.BuscarAluguelUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarAluguelUseCaseTest {

    @Mock
    private AluguelRepository aluguelRepository;
    @InjectMocks
    private BuscarAluguelUseCaseImpl buscarAluguelUseCase;

    @Test
    public void buscarAluguel_Sucesso() {
        String clienteId = "1";
        String filmeId = "1";
        Aluguel aluguel = Aluguel
                .builder()
                .idDoCliente(clienteId)
                .idDoFilme(filmeId)
                .build();

        when(aluguelRepository.findByIdDoClienteAndIdDoFilme(clienteId, filmeId)).thenReturn(Optional.of(aluguel));
        AluguelResponseDTO result = buscarAluguelUseCase.executar(clienteId, filmeId);

        assertEquals(clienteId, result.getIdDoCliente());
        assertEquals(filmeId, result.getIdDoFilme());
        verify(aluguelRepository).findByIdDoClienteAndIdDoFilme(clienteId, filmeId);
    }
}