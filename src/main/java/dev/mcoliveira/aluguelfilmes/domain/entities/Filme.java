package dev.mcoliveira.aluguelfilmes.domain.entities;

import dev.mcoliveira.aluguelfilmes.domain.enums.Genero;
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
    private Integer anoLancamento;
    private Genero genero;
    private Boolean disponivel;
    private Boolean deletado;
}