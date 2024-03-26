package dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.implementations;

import dev.mcoliveira.aluguelfilmes.application.converters.AluguelConverter;
import dev.mcoliveira.aluguelfilmes.application.mappers.AluguelMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.AlugarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.BuscarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.aluguel.CamposObrigatoriosAluguelValidator;
import dev.mcoliveira.aluguelfilmes.application.validators.aluguel.FilmeJaFoiDevolvidoValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DevolverFilmeUseCaseImpl implements AlugarFilmeUseCase {

    private final AluguelRepository aluguelRepository;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final BuscarFilmeUseCase buscarFilmeUseCase;

    @Autowired
    public DevolverFilmeUseCaseImpl(AluguelRepository aluguelRepository,
                                    BuscarClienteUseCase buscarClienteUseCase,
                                    BuscarFilmeUseCase buscarFilmeUseCase) {
        this.aluguelRepository = aluguelRepository;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.buscarFilmeUseCase = buscarFilmeUseCase;

    }

    @Override
    public AluguelResponseDTO executar(AluguelRequestDTO aluguelRequestDTO) {
        validarAntesDeDevolver(aluguelRequestDTO);
        Aluguel aluguel = AluguelConverter.toEntity(aluguelRequestDTO);
        aluguel.setDataDoAluguel(LocalDate.now());
        return AluguelMapper.toAluguelResponseDTO(aluguelRepository.save(aluguel));
    }

    private void validarAntesDeDevolver(AluguelRequestDTO aluguelRequestDTO) {
        CamposObrigatoriosAluguelValidator.validar(aluguelRequestDTO);
        buscarClienteUseCase.executar(aluguelRequestDTO.getIdDoCliente());
        FilmeJaFoiDevolvidoValidator.validar(aluguelRequestDTO.getIdDoFilme(), buscarFilmeUseCase);
    }
}