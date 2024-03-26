package dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.implementations;

import dev.mcoliveira.aluguelfilmes.application.exceptions.aluguel.AluguelNaoEncontradoException;
import dev.mcoliveira.aluguelfilmes.application.mappers.AluguelMapper;
import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.BuscarAluguelUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import dev.mcoliveira.aluguelfilmes.infra.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarAluguelUseCaseImpl implements BuscarAluguelUseCase {

    private final AluguelRepository aluguelRepository;

    @Autowired
    public BuscarAluguelUseCaseImpl(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public AluguelResponseDTO executar(String clienteId, String filmeId) {
        return aluguelRepository.findByIdDoClienteAndIdDoFilmeAndDataDaDevolucaoNull(clienteId, filmeId)
                .map(AluguelMapper::toAluguelResponseDTO)
                .orElseThrow(AluguelNaoEncontradoException::new);
    }

}