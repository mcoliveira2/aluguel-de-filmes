package dev.mcoliveira.aluguelfilmes.application.converters;

import dev.mcoliveira.aluguelfilmes.domain.entities.Cliente;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
@NoArgsConstructor
public class ClienteConverter {

    public static Cliente toEntity(ClienteRequestDTO dto) {
        return Cliente.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .build();
    }

    public static Cliente toEntityUpdate(ClienteRequestDTO dto, Cliente cliente) {
        return Cliente.builder()
                .id(cliente.getId())
                .nome(nonNull(dto.getNome()) ? dto.getNome() : cliente.getNome())
                .email(nonNull(dto.getEmail()) ? dto.getEmail() : cliente.getEmail())
                .build();
    }
}