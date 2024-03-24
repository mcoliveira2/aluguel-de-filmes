package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.mappers.FilmeMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarFilmeUseCaseImpl implements BuscarFilmeUseCase {

    private final FilmeRepository filmeRepository;

    @Autowired
    public BuscarFilmeUseCaseImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public FilmeResponseDTO executar(String id) {
        //TODO criar exceção
        return filmeRepository.findById(id)
                .map(FilmeMapper::toFilmeResponseDTO)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }
}