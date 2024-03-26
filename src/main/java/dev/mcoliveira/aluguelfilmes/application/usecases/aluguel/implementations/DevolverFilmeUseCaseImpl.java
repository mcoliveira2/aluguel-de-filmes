package dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.aluguel.AluguelNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.mappers.AluguelMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.DevolverFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.BuscarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.AlterarDisponibilidadeFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.validators.aluguel.CamposObrigatoriosAluguelValidator;
import dev.mcoliveira.aluguelfilmes.application.validators.aluguel.DevolverFilmeNaoAlugadoValidator;
import dev.mcoliveira.aluguelfilmes.domain.entities.Aluguel;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DevolverFilmeUseCaseImpl implements DevolverFilmeUseCase {

    private final AluguelRepository aluguelRepository;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final BuscarFilmeUseCase buscarFilmeUseCase;
    private final AlterarDisponibilidadeFilmeUseCase alterarDisponibilidadeFilmeUseCase;

    @Autowired
    public DevolverFilmeUseCaseImpl(AluguelRepository aluguelRepository,
                                    BuscarClienteUseCase buscarClienteUseCase,
                                    BuscarFilmeUseCase buscarFilmeUseCase,
                                    AlterarDisponibilidadeFilmeUseCase alterarDisponibilidadeFilmeUseCase) {
        this.aluguelRepository = aluguelRepository;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.buscarFilmeUseCase = buscarFilmeUseCase;
        this.alterarDisponibilidadeFilmeUseCase = alterarDisponibilidadeFilmeUseCase;
    }

    @Override
    public AluguelResponseDTO executar(AluguelRequestDTO aluguelRequestDTO) {
        validarAntesDeDevolver(aluguelRequestDTO);
        Aluguel aluguel = aluguelRepository
                .findByIdDoClienteAndIdDoFilme(aluguelRequestDTO.getIdDoCliente(), aluguelRequestDTO.getIdDoFilme())
                .orElseThrow(AluguelNaoEncontradoException::new);
        aluguel.setDataDaDevolucao(LocalDate.now());
        aluguelRepository.save(aluguel);
        alterarDisponibilidadeFilmeUseCase.executar(aluguel.getIdDoFilme());
        return AluguelMapper.toAluguelResponseDTO(aluguel);
    }

    private void validarAntesDeDevolver(AluguelRequestDTO aluguelRequestDTO) {
        CamposObrigatoriosAluguelValidator.validar(aluguelRequestDTO);
        buscarClienteUseCase.executar(aluguelRequestDTO.getIdDoCliente());
        DevolverFilmeNaoAlugadoValidator.validar(aluguelRequestDTO.getIdDoFilme(), buscarFilmeUseCase);
    }
}