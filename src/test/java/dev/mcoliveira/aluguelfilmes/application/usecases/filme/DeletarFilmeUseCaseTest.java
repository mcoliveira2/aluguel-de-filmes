package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations.DeletarFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.application.validations.filme.AtualizarFilmeValidator;
import dev.mcoliveira.aluguelfilmes.application.validations.filme.DeletarFilmeValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeletarFilmeUseCaseTest {
    @Mock
    private FilmeRepository filmeRepository;
    @Mock
    private DeletarFilmeValidator deletarFilmeValidator;
    @InjectMocks
    private DeletarFilmeUseCaseImpl deletarFilmeUseCase;

    @Test
    public void deletarFilme_Sucesso() {
        String filmeId = "1";
        Filme filme = Filme.builder().id(filmeId).build();

        when(filmeRepository.findById(filmeId)).thenReturn(Optional.ofNullable(filme));
        deletarFilmeUseCase.executar(filmeId);

        verify(filmeRepository).findById(filmeId);
        verify(filmeRepository).delete(filme);
    }
}