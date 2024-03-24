package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.ValidacaoFilmeException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class DeletarFilmeValidator {

    private final BuscarFilmeUseCase buscarFilmeUseCase;

    public DeletarFilmeValidator(BuscarFilmeUseCase buscarFilmeUseCase) {
        this.buscarFilmeUseCase = buscarFilmeUseCase;
    }

    public void validarDisponibilidadeFilme(String filmeId) {
        FilmeResponseDTO filme = buscarFilmeUseCase.executar(filmeId);
        if (Boolean.FALSE.equals(filme.getDisponivel())) {
            throw new ValidacaoFilmeException("O filme está atualmente alugado e não pode ser excluído.");
        }
    }
}