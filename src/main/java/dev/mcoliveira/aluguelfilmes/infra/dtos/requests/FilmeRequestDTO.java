package dev.mcoliveira.aluguelfilmes.infra.dtos.requests;

import dev.mcoliveira.aluguelfilmes.domain.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmeRequestDTO {
    private String id;
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private Genero genero;
    private boolean disponivel;
}