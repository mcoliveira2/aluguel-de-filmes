package dev.mcoliveira.aluguelfilmes.application.mappers;

import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AluguelMapper {

    public static AluguelResponseDTO toAluguelResponseDTO(Aluguel aluguel) {
        return AluguelResponseDTO.builder()
                .idDoFilme(aluguel.getIdDoFilme())
                .idDoCliente(aluguel.getIdDoCliente())
                .dataDoAluguel(aluguel.getDataDoAluguel())
                .dataDaDevolucao(aluguel.getDataDaDevolucao())
                .build();
    }
}