package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.ValidacaoFilmeException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AtualizarFilmeValidator extends FilmeValidator {
    private final BuscarFilmeUseCase buscarFilmeUseCase;

    public AtualizarFilmeValidator(BuscarFilmeUseCase buscarFilmeUseCase) {
        this.buscarFilmeUseCase = buscarFilmeUseCase;
    }

    public void validarFilmeExistente(String titulo, Integer anoLancamento, String filmeId) {
        Optional<FilmeResponseDTO> filmeExistente = buscarFilmeUseCase.executarPorTituloEAnoLancamento(titulo, anoLancamento);
        if (filmeExistente.isPresent() && !filmeExistente.get().getId().equals(filmeId)) {
            throw new ValidacaoFilmeException("Já existe um filme com o mesmo título e ano de lançamento.");
        }
    }
}