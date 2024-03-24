package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;

import java.util.List;

public interface ListarFilmesDisponiveisUseCase {
    List<FilmeResponseDTO> listarFilmesDisponiveis();
}