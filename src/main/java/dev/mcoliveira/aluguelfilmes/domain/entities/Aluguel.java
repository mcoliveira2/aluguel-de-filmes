package dev.mcoliveira.aluguelfilmes.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "alugueis")
@CompoundIndexes({@CompoundIndex(name = "filme_cliente_index", def = "{'idDoFilme': 1, 'idDoCliente': 1}")})
public class Aluguel {

    @Id
    private String id;
    private String idDoFilme;
    private String idDoCliente;
    private LocalDate dataDoAluguel;
    private LocalDate dataDaDevolucao;
}