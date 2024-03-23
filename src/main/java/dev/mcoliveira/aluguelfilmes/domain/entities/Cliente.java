package dev.mcoliveira.aluguelfilmes.domain.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id;
    private String email;
    private String nome;
    private String telefone;
}