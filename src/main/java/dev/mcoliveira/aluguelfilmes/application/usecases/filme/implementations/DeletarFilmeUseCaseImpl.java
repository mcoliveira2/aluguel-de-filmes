package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.FilmeNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.DeletarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.filme.DisponibilidadeFilmeValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarFilmeUseCaseImpl implements DeletarFilmeUseCase {

    private final FilmeRepository filmeRepository;


    @Autowired
    public DeletarFilmeUseCaseImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public void executar(String filmeId) {
        Filme filme = filmeRepository.findByIdAndDeletadoFalse(filmeId).orElseThrow(FilmeNaoEncontradoException::new);
        DisponibilidadeFilmeValidator.validar(filme);
        filme.setDeletado(true);
        filmeRepository.save(filme);
    }
}