package dev.mcoliveira.aluguelfilmes.application.mappers;

import dev.mcoliveira.aluguelfilmes.domain.entities.Filme;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class FilmeMapper {

    public FilmeResponseDTO toFilmeResponseDTO(Filme filme) {
        return FilmeResponseDTO.builder()
                .id(filme.getId())
                .titulo(filme.getTitulo())
                .diretor(filme.getDiretor())
                .anoLancamento(filme.getAnoLancamento())
                .genero(filme.getGenero())
                .disponivel(filme.isDisponivel())
                .build();
    }
}