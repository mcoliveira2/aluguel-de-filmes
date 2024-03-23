package dev.mcoliveira.aluguelfilmes.application.converters;

import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class AluguelConverter {

    public Aluguel toEntity(AluguelRequestDTO dto) {
        return Aluguel.builder()
                .idDoFilme(dto.getIdDoFilme())
                .idDoCliente(dto.getIdDoCliente())
                .dataDoAluguel(dto.getDataDoAluguel())
                .dataDevolucaoPrevista(dto.getDataDevolucaoPrevista())
                .build();
    }
}