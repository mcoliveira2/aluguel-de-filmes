package dev.mcoliveira.aluguelfilmes.application.mappers;

import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class FilmeMapper {

    private FilmeMapper() {}

    public static FilmeResponseDTO toFilmeResponseDTO(Filme filme) {
        return FilmeResponseDTO.builder()
                .id(filme.getId())
                .titulo(filme.getTitulo())
                .diretor(filme.getDiretor())
                .anoLancamento(filme.getAnoLancamento())
                .genero(nonNull(filme.getGenero()) ? filme.getGenero().getDescricao() : null)
                .disponivel(filme.getDisponivel())
                .build();
    }
}