package dev.mcoliveira.aluguelfilmes.infra.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AluguelResponseDTO {
    private String id;
    private String idDoFilme;
    private String idDoCliente;
    private LocalDate dataDoAluguel;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucao;
}