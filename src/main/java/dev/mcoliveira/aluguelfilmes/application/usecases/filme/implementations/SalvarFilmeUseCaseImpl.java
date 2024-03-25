package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.converters.FilmeConverter;
import dev.mcoliveira.aluguelfilmes.application.mappers.FilmeMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.SalvarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.AnoLancamentoFilmeValidator;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.CamposObrigatoriosFilmeValidator;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.FilmeExistenteValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarFilmeUseCaseImpl implements SalvarFilmeUseCase {

    private final FilmeRepository filmeRepository;
    private final BuscarFilmeUseCase buscarFilmeUseCase;

    @Autowired
    public SalvarFilmeUseCaseImpl(FilmeRepository filmeRepository, BuscarFilmeUseCase buscarFilmeUseCase) {
        this.filmeRepository = filmeRepository;
        this.buscarFilmeUseCase = buscarFilmeUseCase;
    }

    @Override
    public FilmeResponseDTO executar(FilmeRequestDTO filmeRequestDTO) {
        validarFilmeAntesDeSalvar(filmeRequestDTO);
        Filme filme = FilmeConverter.toEntity(filmeRequestDTO);
        filme.setDisponivel(Boolean.TRUE);
        return FilmeMapper.toFilmeResponseDTO(filmeRepository.save(filme));
    }

    private void validarFilmeAntesDeSalvar(FilmeRequestDTO filmeRequestDTO) {
        CamposObrigatoriosFilmeValidator.validar(filmeRequestDTO);
        AnoLancamentoFilmeValidator.validar(filmeRequestDTO.getAnoLancamento());
        FilmeExistenteValidator.validar(
                filmeRequestDTO.getTitulo(),
                filmeRequestDTO.getAnoLancamento(),
                buscarFilmeUseCase);
    }
}