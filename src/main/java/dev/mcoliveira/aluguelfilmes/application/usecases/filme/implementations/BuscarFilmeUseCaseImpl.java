package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.FilmeNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.mappers.FilmeMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarFilmeUseCaseImpl implements BuscarFilmeUseCase {

    private final FilmeRepository filmeRepository;

    @Autowired
    public BuscarFilmeUseCaseImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public FilmeResponseDTO executar(String id) {
        return filmeRepository.findById(id)
                .map(FilmeMapper::toFilmeResponseDTO)
                .orElseThrow(FilmeNaoEncontradoException::new);
    }

    @Override
    public Optional<FilmeResponseDTO> executarPorTituloEAnoLancamento(String titulo, Integer anoLancamento) {
        return filmeRepository.findByTituloAndAnoLancamento(titulo, anoLancamento)
                .map(FilmeMapper::toFilmeResponseDTO);
    }
}