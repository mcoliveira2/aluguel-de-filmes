package dev.mcoliveira.aluguelfilmes.application.usecases.aluguel;

import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DevolverFilmeUseCaseTest {

    @Mock
    private AluguelRepository aluguelRepository;
    @Mock
    private FilmeRepository filmeRepository;
    @Mock
    private ClienteRepository clienteRepository;
//    @InjectMocks
//    private AlugarFilmeUseCase alugarFilmeUseCase;

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

//        when(filmeRepository.existsById(idDoFilme)).thenReturn(true);
//        when(clienteRepository.existsById(idDoCliente)).thenReturn(true);
//        when(aluguelRepository.save(any())).thenReturn(aluguel);
//
//        AluguelResponseDTO response = devolverFilmeUseCase.executar(idDoFilme, idDoCliente);
//
//        verify(filmeRepository.findById(idDoFilme));
//        verify(clienteRepository.findById(idDoCliente));
//        assertNotNull(response);
//        assertEquals(idDoFilme, response.getIdDoFilme());
//        assertEquals(idDoCliente, response.getIdDoCliente());
//        assertEquals(aluguel.getDataDoAluguel(), response.getDataDoAluguel());
//        assertEquals(aluguel.getDataDaDevolucao(), response.getDataDaDevolucao());
    }
}