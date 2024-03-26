package dev.mcoliveira.aluguelfilmes.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "alugueis")
public class Aluguel {

    private String idDoFilme;
    private String idDoCliente;
    private LocalDate dataDoAluguel;
    private LocalDate dataDaDevolucao;
    @Version
    private Long versao;
}