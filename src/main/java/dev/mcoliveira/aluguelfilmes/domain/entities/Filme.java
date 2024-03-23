package dev.mcoliveira.aluguelfilmes.domain.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "filmes")
public class Filme {

    @Id
    private String id;
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private String genero;
    private boolean disponivel;
}