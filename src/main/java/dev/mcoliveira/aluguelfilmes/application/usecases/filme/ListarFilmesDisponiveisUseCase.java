package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ListarFilmesDisponiveisUseCase {
    List<FilmeResponseDTO> executar(Pageable pageable);
}