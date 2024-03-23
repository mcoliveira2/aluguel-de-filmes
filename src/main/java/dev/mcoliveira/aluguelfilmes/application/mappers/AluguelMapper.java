package dev.mcoliveira.aluguelfilmes.application.mappers;

import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AluguelMapper {

    public AluguelResponseDTO toAluguelResponseDTO(Aluguel aluguel) {
        return AluguelResponseDTO.builder()
                .id(aluguel.getId())
                .idDoFilme(aluguel.getIdDoFilme())
                .idDoCliente(aluguel.getIdDoCliente())
                .dataDoAluguel(aluguel.getDataDoAluguel())
                .dataDevolucaoPrevista(aluguel.getDataDevolucaoPrevista())
                .dataDevolucao(aluguel.getDataDevolucao())
                .build();
    }
}