package dev.mcoliveira.aluguelfilmes.infra.repositories;

import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends MongoRepository<Filme, String> {

    List<Filme> findByDisponivelTrue(Pageable pageable);
    Optional<Filme> findByTituloAndAnoLancamento(String titulo, Integer anoLancamento);
}
