package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations.BuscarFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations.DeletarFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeletarFilmeUseCaseTest {
    @Mock
    private FilmeRepository filmeRepository;
    @Mock
    private BuscarFilmeUseCaseImpl buscarFilmeUseCase;
    @InjectMocks
    private DeletarFilmeUseCaseImpl deletarFilmeUseCase;

    @Test
    public void deletarFilme_Sucesso() {
        String filmeId = "1";
        FilmeResponseDTO filme = FilmeResponseDTO.builder().id(filmeId).build();

        when(buscarFilmeUseCase.executar(filmeId)).thenReturn(filme);
        deletarFilmeUseCase.executar(filmeId);

        verify(filmeRepository).deleteById(filmeId);
    }
}