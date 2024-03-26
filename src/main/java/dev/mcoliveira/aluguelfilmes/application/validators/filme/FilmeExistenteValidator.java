package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static dev.mcoliveira.aluguelfilmes.application.validators.MensagensDeErro.ERRO_FILME_EXISTENTE;

@Component
public class FilmeExistenteValidator {

    public static void validar(String titulo, Integer anoLancamento, String filmeId, BuscarFilmeUseCase buscarFilmeUseCase) {
        Optional<FilmeResponseDTO> filmeExistente = buscarFilmeUseCase.executarPorTituloEAnoLancamento(titulo, anoLancamento);
        if (filmeExistente.isPresent() && !filmeExistente.get().getId().equals(filmeId)) {
            throw new ValidacaoException(ERRO_FILME_EXISTENTE);
        }
    }

    public static void validar(String titulo, Integer anoLancamento, BuscarFilmeUseCase buscarFilmeUseCase) {
        Optional<FilmeResponseDTO> filmeExistente = buscarFilmeUseCase.executarPorTituloEAnoLancamento(titulo, anoLancamento);
        if (filmeExistente.isPresent()) {
            throw new ValidacaoException(ERRO_FILME_EXISTENTE);
        }
    }
}