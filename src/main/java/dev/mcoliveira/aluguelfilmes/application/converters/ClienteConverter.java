package dev.mcoliveira.aluguelfilmes.application.converters;

import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {

    public Cliente toEntity(ClienteRequestDTO dto) {
        return Cliente.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .build();
    }
}