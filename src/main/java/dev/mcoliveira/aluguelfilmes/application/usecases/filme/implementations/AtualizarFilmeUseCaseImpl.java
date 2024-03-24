package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;


import dev.mcoliveira.aluguelfilmes.application.converters.FilmeConverter;
import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.FilmeNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.mappers.FilmeMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.AtualizarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.AtualizarFilmeValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarFilmeUseCaseImpl implements AtualizarFilmeUseCase {

    private final FilmeRepository filmeRepository;
    private final AtualizarFilmeValidator atualizarFilmeValidator;

    @Autowired
    public AtualizarFilmeUseCaseImpl(FilmeRepository filmeRepository, AtualizarFilmeValidator atualizarFilmeValidator) {
        this.filmeRepository = filmeRepository;
        this.atualizarFilmeValidator = atualizarFilmeValidator;
    }

    @Override
    public FilmeResponseDTO executar(String id, FilmeRequestDTO filmeRequestDTO) {
        atualizarFilmeValidator.validarAnoLancamento(filmeRequestDTO.getAnoLancamento());
        Filme filmeExistente = filmeRepository.findById(id).orElseThrow(FilmeNaoEncontradoException::new);
        Filme filmeParaAtualizar = FilmeConverter.toEntityUpdate(filmeRequestDTO, filmeExistente);
        atualizarFilmeValidator.validarFilmeExistente(
                filmeParaAtualizar.getTitulo(), filmeParaAtualizar.getAnoLancamento(), filmeParaAtualizar.getId());
        return FilmeMapper.toFilmeResponseDTO(filmeRepository.save(filmeParaAtualizar));
    }
}