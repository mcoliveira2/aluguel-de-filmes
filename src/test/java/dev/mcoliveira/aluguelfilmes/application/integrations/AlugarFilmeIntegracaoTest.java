package dev.mcoliveira.aluguelfilmes.application.integrations;

import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.AlugarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.DevolverFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.SalvarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.SalvarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.domain.enums.Genero;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import dev.mcoliveira.aluguelfilmes.infra.repositories.ClienteRepository;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AlugarFilmeIntegracaoTest {

    @Autowired
    private SalvarFilmeUseCase salvarFilmeUseCase;
    @Autowired
    private BuscarFilmeUseCase buscarFilmeUseCase;
    @Autowired
    private SalvarClienteUseCase salvarClienteUseCase;
    @Autowired
    private AlugarFilmeUseCase alugarFilmeUseCase;
    @Autowired
    private DevolverFilmeUseCase devolverFilmeUseCase;
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @AfterEach
    public void limparBancoDeDados() {
        mongoTemplate.getDb().drop();
    }

    @Test
    public void testarSalvarFilmeSalvarClienteAlugarFilmeEDevolverFilme_Sucesso() {
        FilmeResponseDTO filmeResponseDTO = salvarFilme();
        ClienteResponseDTO clienteResponseDTO = salvarCliente();
        AluguelRequestDTO aluguelRequestDTO = alugarFilme(clienteResponseDTO, filmeResponseDTO);
        verificarSeFilmeEstaAlugado(filmeResponseDTO);
        devolverFilme(aluguelRequestDTO);
        verificarSeFilmeFoiDevolvido(filmeResponseDTO);
    }

    private void verificarSeFilmeFoiDevolvido(FilmeResponseDTO filmeResponseDTO) {
        FilmeResponseDTO filmeDevolvido = buscarFilmeUseCase.executar(filmeResponseDTO.getId());
        assertNotNull(filmeDevolvido);
        assertEquals(Boolean.TRUE, filmeDevolvido.getDisponivel());
    }

    private void devolverFilme(AluguelRequestDTO aluguelRequestDTO) {
        AluguelResponseDTO aluguelDevolvido = devolverFilmeUseCase.executar(aluguelRequestDTO);
        assertNotNull(aluguelDevolvido.getDataDaDevolucao());
    }

    private void verificarSeFilmeEstaAlugado(FilmeResponseDTO filmeResponseDTO) {
        FilmeResponseDTO filmeAlugado = buscarFilmeUseCase.executar(filmeResponseDTO.getId());
        assertNotNull(filmeAlugado);
        assertEquals(Boolean.FALSE, filmeAlugado.getDisponivel());
    }

    private AluguelRequestDTO alugarFilme(ClienteResponseDTO clienteResponseDTO, FilmeResponseDTO filmeResponseDTO) {
        AluguelRequestDTO aluguelRequestDTO = AluguelRequestDTO.builder()
                .idDoCliente(clienteResponseDTO.getId())
                .idDoFilme(filmeResponseDTO.getId())
                .build();
        AluguelResponseDTO aluguelResponseDTO = alugarFilmeUseCase.executar(aluguelRequestDTO);
        assertNotNull(aluguelResponseDTO.getDataDoAluguel());
        return aluguelRequestDTO;
    }

    private ClienteResponseDTO salvarCliente() {
        ClienteRequestDTO clienteRequestDTO = ClienteRequestDTO.builder()
                .nome("Cliente")
                .email("cliente@email.com")
                .build();
        ClienteResponseDTO clienteResponseDTO = salvarClienteUseCase.executar(clienteRequestDTO);
        assertNotNull(clienteResponseDTO.getId());
        return clienteResponseDTO;
    }

    private FilmeResponseDTO salvarFilme() {
        FilmeRequestDTO filmeRequestDTO = FilmeRequestDTO.builder()
                .titulo("Filme")
                .anoLancamento(2020)
                .genero(Genero.ACAO)
                .build();
        FilmeResponseDTO filmeResponseDTO = salvarFilmeUseCase.executar(filmeRequestDTO);
        assertNotNull(filmeResponseDTO.getId());
        return filmeResponseDTO;
    }
}