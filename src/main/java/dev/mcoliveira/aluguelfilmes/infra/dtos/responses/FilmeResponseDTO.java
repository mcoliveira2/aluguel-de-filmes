package dev.mcoliveira.aluguelfilmes.infra.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmeResponseDTO {
    private String id;
    private String titulo;
    private String diretor;
    private Integer anoLancamento;
    private String genero;
    private Boolean disponivel;
}