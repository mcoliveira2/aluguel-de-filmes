package dev.mcoliveira.aluguelfilmes.domain.entities;

import dev.mcoliveira.aluguelfilmes.domain.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "filmes")
@CompoundIndexes({@CompoundIndex(name = "titulo_ano_lancamento_index", def = "{'titulo': 1, 'anoLancamento': 1}")})
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