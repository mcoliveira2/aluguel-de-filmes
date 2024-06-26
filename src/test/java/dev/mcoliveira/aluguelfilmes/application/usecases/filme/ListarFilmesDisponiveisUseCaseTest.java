package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations.ListarFilmesDisponiveisUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.domain.enums.Genero;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@ExtendWith(MockitoExtension.class)
public class ListarFilmesDisponiveisUseCaseTest {

    @Mock
    private FilmeRepository filmeRepository;
    @InjectMocks
    private ListarFilmesDisponiveisUseCaseImpl listarFilmesDisponiveisUseCase;

    @Test
    public void listarFilmesDisponiveis_Sucesso() {
        List<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme("1", "Filme 1", "Diretor 1", 2021, Genero.ACAO, true, false));
        filmes.add(new Filme("2", "Filme 2", "Diretor 2", 2022, Genero.COMEDIA, true, false));
        filmes.add(new Filme("3", "Filme 3", "Diretor 3", 2023, Genero.DRAMA, true, false));
        Pageable pageable = PageRequest.of(0, 10, Sort.by("titulo").ascending());


        when(filmeRepository.findByDisponivelTrueAndDeletadoFalse(any(Pageable.class))).thenReturn(filmes);
        List<FilmeResponseDTO> result = listarFilmesDisponiveisUseCase.executar(pageable);

        assertEquals(filmes.size(), result.size());
    }
}