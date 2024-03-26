package dev.mcoliveira.aluguelfilmes.infra.controllers;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import org.springframework.http.ResponseEntity;


public interface AluguelController {

    ResponseEntity<AluguelResponseDTO> alugarFilme(AluguelRequestDTO aluguelRequestDTO);
    ResponseEntity<AluguelResponseDTO> devolverFilme(AluguelRequestDTO aluguelRequestDTO);
}