package dev.mcoliveira.aluguelfilmes.infra.controllers;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface FilmeController {

    ResponseEntity<FilmeResponseDTO> atualizarFilme(String id, FilmeRequestDTO filmeRequestDTO);
    ResponseEntity<FilmeResponseDTO> buscarFilme(String id);
    ResponseEntity<Void> deletarFilme(String id);
    ResponseEntity<List<FilmeResponseDTO>> listarFilmesDisponiveis(Pageable pageable);
    ResponseEntity<FilmeResponseDTO> salvarFilme(FilmeRequestDTO filmeRequestDTO);
}