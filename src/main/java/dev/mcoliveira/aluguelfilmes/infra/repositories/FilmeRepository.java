package dev.mcoliveira.aluguelfilmes.infra.repositories;

import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends MongoRepository<Filme, String> {

    Optional<Filme> findByIdAndDeletadoFalse(String id);
    List<Filme> findByDisponivelTrueAndDeletadoFalse(Pageable pageable);
    Optional<Filme> findByTituloAndAnoLancamentoAndDeletadoFalse(String titulo, Integer anoLancamento);
}
