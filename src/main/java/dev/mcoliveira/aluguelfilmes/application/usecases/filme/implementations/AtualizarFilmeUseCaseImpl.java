package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;


import dev.mcoliveira.aluguelfilmes.application.converters.FilmeConverter;
import dev.mcoliveira.aluguelfilmes.application.mappers.FilmeMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.AtualizarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarFilmeUseCaseImpl implements AtualizarFilmeUseCase {

    private final FilmeRepository filmeRepository;

    @Autowired
    public AtualizarFilmeUseCaseImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public FilmeResponseDTO executar(String id, FilmeRequestDTO filmeRequestDTO) {
        //TODO criar exceção
        Filme filmeExistente = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        Filme filmeAtualizado = FilmeConverter.toEntityUpdate(filmeRequestDTO, filmeExistente);
        return FilmeMapper.toFilmeResponseDTO(filmeRepository.save(filmeAtualizado));
    }
}