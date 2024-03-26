package dev.mcoliveira.aluguelfilmes.application.usecases.filme.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.FilmeNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.AlterarDisponibilidadeFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterarDisponibilidadeFilmeUseCaseImpl implements AlterarDisponibilidadeFilmeUseCase {

    private final FilmeRepository filmeRepository;

    @Autowired
    public AlterarDisponibilidadeFilmeUseCaseImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public void executar(String filmeId) {
        Filme filmeExistente = filmeRepository.findByIdAndDeletadoFalse(filmeId)
                .orElseThrow(FilmeNaoEncontradoException::new);
        filmeExistente.setDisponivel(!filmeExistente.getDisponivel());
        filmeRepository.save(filmeExistente);
    }
}