package dev.mcoliveira.aluguelfilmes.infra.repositories;

import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilmeRepository extends MongoRepository<Filme, String> {

    List<Filme> findByDisponivelTrue();
}
