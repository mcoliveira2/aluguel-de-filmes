package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.usecases.filme.DeletarFilmeUseCase;
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
        //TODO criar exceção
        //TODO criar validação de não poder excluir filme que esta alugado (nao esta disponivel)
        Filme filme = filmeRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filmeRepository.delete(filme);
    }
}