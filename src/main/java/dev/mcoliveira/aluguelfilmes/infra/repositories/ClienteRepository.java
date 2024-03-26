package dev.mcoliveira.aluguelfilmes.infra.repositories;

import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByIdAndDeletadoFalse(String id);
    Optional<Cliente> findByEmailAndDeletadoFalse(String email);
}
