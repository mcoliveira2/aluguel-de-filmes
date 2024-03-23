package dev.mcoliveira.aluguelfilmes.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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