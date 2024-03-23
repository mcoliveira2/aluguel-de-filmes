package dev.mcoliveira.aluguelfilmes.infra.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmeRequestDTO {
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private String genero;
    private boolean disponivel;
}