package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;


import dev.mcoliveira.aluguelfilmes.application.converters.FilmeConverter;
import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.FilmeNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.mappers.FilmeMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.AtualizarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.AnoLancamentoFilmeValidator;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.FilmeExistenteValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarFilmeUseCaseImpl implements AtualizarFilmeUseCase {

    private final FilmeRepository filmeRepository;
    private final BuscarFilmeUseCase buscarFilmeUseCase;

    @Autowired
    public AtualizarFilmeUseCaseImpl(FilmeRepository filmeRepository, BuscarFilmeUseCase buscarFilmeUseCase) {
        this.filmeRepository = filmeRepository;
        this.buscarFilmeUseCase = buscarFilmeUseCase;
    }

    @Override
    public FilmeResponseDTO executar(String id, FilmeRequestDTO filmeRequestDTO) {
        AnoLancamentoFilmeValidator.validar(filmeRequestDTO.getAnoLancamento());
        Filme filmeExistente = filmeRepository.findById(id).orElseThrow(FilmeNaoEncontradoException::new);
        Filme filmeParaAtualizar = FilmeConverter.toEntityUpdate(filmeRequestDTO, filmeExistente);
        FilmeExistenteValidator.validar(
                filmeParaAtualizar.getTitulo(),
                filmeParaAtualizar.getAnoLancamento(),
                filmeParaAtualizar.getId(),
                buscarFilmeUseCase
        );
        return FilmeMapper.toFilmeResponseDTO(filmeRepository.save(filmeParaAtualizar));
    }
}