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
    private String titulo;
    private String diretor;
    private Integer anoLancamento;
    private Genero genero;
}