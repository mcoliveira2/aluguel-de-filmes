package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.FilmeNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.DeletarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.DisponibilidadeFilmeValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarFilmeUseCaseImpl implements DeletarFilmeUseCase {

    private final FilmeRepository filmeRepository;
    private final BuscarFilmeUseCase buscarFilmeUseCase;


    @Autowired
    public DeletarFilmeUseCaseImpl(FilmeRepository filmeRepository, BuscarFilmeUseCase buscarFilmeUseCase) {
        this.filmeRepository = filmeRepository;
        this.buscarFilmeUseCase = buscarFilmeUseCase;
    }

    @Override
    public void executar(String filmeId) {
        DisponibilidadeFilmeValidator.validar(filmeId, buscarFilmeUseCase);
        filmeRepository.deleteById(filmeId);
    }
}