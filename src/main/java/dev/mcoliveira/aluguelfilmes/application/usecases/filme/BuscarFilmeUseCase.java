package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;

import java.util.Optional;

public interface BuscarFilmeUseCase {
    FilmeResponseDTO executar(String filmeId);
    Optional<FilmeResponseDTO> executarPorTituloEAnoLancamento(String titulo, Integer anoLancamento);
}