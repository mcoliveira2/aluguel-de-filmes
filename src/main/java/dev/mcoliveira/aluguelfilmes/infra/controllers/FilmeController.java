package dev.mcoliveira.aluguelfilmes.infra.controllers;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static dev.mcoliveira.aluguelfilmes.application.validators.MensagensDeErro.*;


public interface FilmeController {


    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
                    ERRO_TITULO_OBRIGATORIO + "<br>" +
                    ERRO_ANO_LANCAMENTO_OBRIGATORIO + "<br>" +
                    ERRO_GENERO_OBRIGATORIO + "<br>" +
                    ERRO_ANO_LANCAMENTO_INVALIDO + "<br>" +
                    ERRO_FILME_EXISTENTE)
    ResponseEntity<FilmeResponseDTO> salvarFilme(FilmeRequestDTO filmeRequestDTO);
    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_ANO_LANCAMENTO_INVALIDO + "<br>" +
            ERRO_FILME_NAO_ENCONTRADO + "<br>" +
            ERRO_FILME_EXISTENTE)
    ResponseEntity<FilmeResponseDTO> atualizarFilme(String id, FilmeRequestDTO filmeRequestDTO);
    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_FILME_NAO_ENCONTRADO)
    ResponseEntity<FilmeResponseDTO> buscarFilme(String id);
    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_FILME_ALUGADO_NAO_PODE_DELETAR + "<br>" +
            ERRO_FILME_NAO_ENCONTRADO)
    ResponseEntity<Void> deletarFilme(String id);
    ResponseEntity<List<FilmeResponseDTO>> listarFilmesDisponiveis(Pageable pageable);
}