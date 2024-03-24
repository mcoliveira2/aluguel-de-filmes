package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.converters.FilmeConverter;
import dev.mcoliveira.aluguelfilmes.application.mappers.FilmeMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.SalvarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.SalvarFilmeValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarFilmeUseCaseImpl implements SalvarFilmeUseCase {

    private final FilmeRepository filmeRepository;
    private final SalvarFilmeValidator salvarFilmeValidator;

    @Autowired
    public SalvarFilmeUseCaseImpl(FilmeRepository filmeRepository, SalvarFilmeValidator salvarFilmeValidator) {
        this.filmeRepository = filmeRepository;
        this.salvarFilmeValidator = salvarFilmeValidator;
    }

    @Override
    public FilmeResponseDTO executar(FilmeRequestDTO filmeRequestDTO) {
        salvarFilmeValidator.validar(filmeRequestDTO);
        Filme filme = FilmeConverter.toEntity(filmeRequestDTO);
        filme.setDisponivel(Boolean.TRUE);
        return FilmeMapper.toFilmeResponseDTO(filmeRepository.save(filme));
    }
}