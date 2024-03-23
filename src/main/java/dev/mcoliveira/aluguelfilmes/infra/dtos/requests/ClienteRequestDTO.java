package dev.mcoliveira.aluguelfilmes.infra.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {
    private String id;
    private String nome;
    private String email;
    private String telefone;
}