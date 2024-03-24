package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DeletarFilmeUseCaseTest {
    @Mock
    private FilmeRepository filmeRepository;

//    @InjectMocks
//    private DeletarFilmeUseCaseImpl deletarFilmeUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deletarFilme_Sucesso() {
        String filmeId = "1";

        when(filmeRepository.existsById(filmeId)).thenReturn(true);
        doNothing().when(filmeRepository).deleteById(filmeId);

//        boolean result = deletarFilmeUseCase.executar(filmeId);
//
//        verify(filmeRepository).existsById(filmeId);
//        verify(filmeRepository).deleteById(filmeId);
    }
}