package dev.mcoliveira.aluguelfilmes.infra.repositories;

import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AluguelRepository extends MongoRepository<Aluguel, String> {

    @Query(value = "{'idDoCliente' : ?0, 'dataDaDevolucao' : null}", exists = true)
    Boolean findByIdDoClienteAndDataDaDevolucaoNull(String idDoCliente);
}
