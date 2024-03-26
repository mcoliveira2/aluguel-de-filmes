package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations.AlterarDisponibilidadeFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.domain.enums.Genero;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlterarDisponibilidadeFilmeUseCaseTest {

    @Mock
    private FilmeRepository filmeRepository;
    @InjectMocks
    private AlterarDisponibilidadeFilmeUseCaseImpl alterarDisponibilidadeFilmeUseCase;

    @Test
    void alterarDisponibilidadeFilme_Successo() {
        String filmeId = "1";
        Filme filmeExistente = Filme
                .builder()
                .id(filmeId)
                .titulo("Título")
                .anoLancamento(2022)
                .genero(Genero.ACAO)
                .disponivel(Boolean.TRUE)
                .build();

        when(filmeRepository.findByIdAndDeletadoFalse(filmeId)).thenReturn(Optional.of(filmeExistente));
        alterarDisponibilidadeFilmeUseCase.executar(filmeId);

        assertEquals(filmeExistente.getDisponivel(), Boolean.FALSE);
    }
}