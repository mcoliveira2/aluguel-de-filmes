package dev.mcoliveira.aluguelfilmes.application.validations.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.ValidacaoFilmeException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalvarFilmeValidator extends FilmeValidator {
    private final BuscarFilmeUseCase buscarFilmeUseCase;

    public SalvarFilmeValidator(BuscarFilmeUseCase buscarFilmeUseCase) {
        this.buscarFilmeUseCase = buscarFilmeUseCase;
    }
    public void validar(FilmeRequestDTO filme) {
        validarCamposObrigatorios(filme);
        super.validarAnoLancamento(filme.getAnoLancamento());
        validarFilmeExistente(filme.getTitulo(), filme.getAnoLancamento());
    }

    public void validarCamposObrigatorios(FilmeRequestDTO filme) throws ValidacaoFilmeException {
        if (filme.getTitulo() == null || filme.getTitulo().isEmpty()) {
            throw new ValidacaoFilmeException("O 'título' do filme é obrigatório.");
        }
        if (filme.getAnoLancamento() == null) {
            throw new ValidacaoFilmeException("O 'ano de lançamento' do filme é obrigatório.");
        }
        if (filme.getGenero() == null) {
            throw new ValidacaoFilmeException("O 'gênero' do filme é obrigatório.");
        }
    }

    public void validarFilmeExistente(String titulo, Integer anoLancamento) {
        Optional<FilmeResponseDTO> filmeExistente = buscarFilmeUseCase.executarPorTituloEAnoLancamento(titulo, anoLancamento);
        if (filmeExistente.isPresent()) {
            throw new ValidacaoFilmeException("Já existe um filme com o mesmo título e ano de lançamento.");
        }
    }
}