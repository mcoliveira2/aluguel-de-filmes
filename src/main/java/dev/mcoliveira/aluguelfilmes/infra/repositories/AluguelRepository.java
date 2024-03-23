package dev.mcoliveira.aluguelfilmes.infra.repositories;

import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AluguelRepository extends MongoRepository<Aluguel, String> {
}
