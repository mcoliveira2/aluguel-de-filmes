package dev.mcoliveira.aluguelfilmes.application.usecases.aluguel;

import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.implementations.DevolverFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.BuscarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.AlterarDisponibilidadeFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DevolverFilmeUseCaseTest {

    @Mock
    private AluguelRepository aluguelRepository;
    @Mock
    private BuscarFilmeUseCase buscarFilmeUseCase;
    @Mock
    private BuscarClienteUseCase buscarClienteUseCase;
    @Mock
    private AlterarDisponibilidadeFilmeUseCase alterarDisponibilidadeFilmeUseCase;
    @InjectMocks
    private DevolverFilmeUseCaseImpl devolverFilmeUseCase;

    @Test
    public void devolverFilme_Successo() {
        String idDoFilme = "1";
        String idDoCliente = "1";
        Aluguel aluguel = Aluguel
                .builder()
                .idDoCliente(idDoCliente)
                .idDoFilme(idDoFilme)
                .dataDoAluguel(LocalDate.now().minusDays(2))
                .dataDaDevolucao(LocalDate.now())
                .build();

        when(buscarFilmeUseCase.executar(idDoFilme)).thenReturn(FilmeResponseDTO.builder().id(idDoFilme).build());
        when(buscarClienteUseCase.executar(idDoCliente)).thenReturn(ClienteResponseDTO.builder().id(idDoFilme).build());
        when(aluguelRepository.findByIdDoClienteAndIdDoFilmeAndDataDaDevolucaoNull(any(), any()))
                .thenReturn(Optional.ofNullable(aluguel));
        when(aluguelRepository.save(any())).thenReturn(aluguel);

        AluguelResponseDTO response = devolverFilmeUseCase.executar(
                AluguelRequestDTO.builder()
                        .idDoFilme(idDoFilme)
                        .idDoCliente(idDoCliente)
                        .build());

        assertNotNull(response);
        assertEquals(idDoFilme, response.getIdDoFilme());
        assertEquals(idDoCliente, response.getIdDoCliente());
        assertEquals(aluguel.getDataDoAluguel(), response.getDataDoAluguel());
        assertEquals(aluguel.getDataDaDevolucao(), response.getDataDaDevolucao());
    }
}