package dev.mcoliveira.aluguelfilmes.infra.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErroResponseDTO {
    private Integer codigo;
    private String mensagem;
}