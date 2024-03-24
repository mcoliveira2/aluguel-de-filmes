package dev.mcoliveira.aluguelfilmes.application.converters;

import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class FilmeConverter {

    public FilmeConverter() {}

    public static Filme toEntity(FilmeRequestDTO dto) {
        return Filme.builder()
                .titulo(dto.getTitulo())
                .diretor(dto.getDiretor())
                .anoLancamento(dto.getAnoLancamento())
                .genero(dto.getGenero())
                .build();
    }

    public static Filme toEntityUpdate(FilmeRequestDTO dto, Filme filme) {
        return Filme.builder()
                .id(filme.getId())
                .titulo(nonNull(dto.getTitulo()) ? dto.getTitulo() : filme.getTitulo())
                .diretor(nonNull(dto.getDiretor()) ? dto.getDiretor() : filme.getDiretor())
                .anoLancamento(nonNull(dto.getAnoLancamento()) ? dto.getAnoLancamento() : filme.getAnoLancamento())
                .genero(nonNull(dto.getGenero()) ? dto.getGenero() : filme.getGenero())
                .disponivel(filme.getDisponivel())
                .build();
    }
}