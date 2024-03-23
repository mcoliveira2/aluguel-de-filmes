package dev.mcoliveira.aluguelfilmes.domain.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@Document(collection = "alugueis")
public class Aluguel {

    @Id
    private String id;
    private String idDoFilme;
    private String idDoCliente;
    private LocalDate dataDoAluguel;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucao;
}