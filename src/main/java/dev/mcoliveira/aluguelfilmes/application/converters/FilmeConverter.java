package dev.mcoliveira.aluguelfilmes.application.converters;

import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class FilmeConverter {

    public Filme toEntity(FilmeRequestDTO dto) {
        return Filme.builder()
                .titulo(dto.getTitulo())
                .diretor(dto.getDiretor())
                .anoLancamento(dto.getAnoLancamento())
                .genero(dto.getGenero())
                .build();
    }
}