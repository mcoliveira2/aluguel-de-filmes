package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;

import java.util.Optional;

public interface BuscarFilmeUseCase {
    Optional<FilmeResponseDTO> executar(String filmeId);
}