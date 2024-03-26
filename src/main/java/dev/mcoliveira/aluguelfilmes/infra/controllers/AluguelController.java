package dev.mcoliveira.aluguelfilmes.infra.controllers;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import static dev.mcoliveira.aluguelfilmes.infra.exceptions.MensagensDeErro.*;


public interface AluguelController {

    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_FILME_ID_OBRIGATORIO + "<br>" +
            ERRO_CLINTE_ID_OBRIGATORIO + "<br>" +
            ERRO_FILME_JA_ESTA_ALUGADO)
    ResponseEntity<AluguelResponseDTO> alugarFilme(AluguelRequestDTO aluguelRequestDTO);

    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_FILME_ID_OBRIGATORIO + "<br>" +
            ERRO_CLINTE_ID_OBRIGATORIO + "<br>" +
            ERRO_FILME_JA_ESTA_ALUGADO + "<br>" +
            ERRO_FILME_NAO_ALUGADO + "<br>" +
            ERRO_ALUGUEL_NAO_ENCONTRADO + "<br>")
    ResponseEntity<AluguelResponseDTO> devolverFilme(AluguelRequestDTO aluguelRequestDTO);

    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_ALUGUEL_NAO_ENCONTRADO)
    ResponseEntity<AluguelResponseDTO> buscarAluguel(String idDoCliente, String idDoFilme);
}