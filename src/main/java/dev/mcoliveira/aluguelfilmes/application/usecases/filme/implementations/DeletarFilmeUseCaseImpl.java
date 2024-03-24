package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.FilmeNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.DeletarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.DeletarFilmeValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarFilmeUseCaseImpl implements DeletarFilmeUseCase {

    private final FilmeRepository filmeRepository;

    private final DeletarFilmeValidator deletarFilmeValidator;


    @Autowired
    public DeletarFilmeUseCaseImpl(FilmeRepository filmeRepository, DeletarFilmeValidator deletarFilmeValidator) {
        this.filmeRepository = filmeRepository;
        this.deletarFilmeValidator = deletarFilmeValidator;
    }

    @Override
    public void executar(String filmeId) {
        deletarFilmeValidator.validarDisponibilidadeFilme(filmeId);
        Filme filme = filmeRepository.findById(filmeId).orElseThrow(FilmeNaoEncontradoException::new);
        filmeRepository.delete(filme);
    }
}