package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.mappers.FilmeMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.ListarFilmesDisponiveisUseCase;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarFilmesDisponiveisUseCaseImpl implements ListarFilmesDisponiveisUseCase {

    private final FilmeRepository filmeRepository;

    @Autowired
    public ListarFilmesDisponiveisUseCaseImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public List<FilmeResponseDTO> executar(Pageable pageable) {
        List<Filme> filmesDisponiveis = filmeRepository.findByDisponivelTrue(pageable);
        return filmesDisponiveis.stream()
                .map(FilmeMapper::toFilmeResponseDTO)
                .collect(Collectors.toList());
    }
}