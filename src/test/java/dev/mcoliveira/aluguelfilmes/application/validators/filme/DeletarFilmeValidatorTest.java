package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.filme.ValidacaoFilmeException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeletarFilmeValidatorTest {

    @Mock
    private BuscarFilmeUseCase buscarFilmeUseCase;

    @InjectMocks
    private DeletarFilmeValidator deletarFilmeValidator;

    @Test
    void validarDisponibilidadeFilme_FilmeNaoAlugado_DevePassarSemExcecao() {
        String filmeId = "1";

        FilmeResponseDTO filmeResponseDTO = new FilmeResponseDTO();
        filmeResponseDTO.setDisponivel(true);

        when(buscarFilmeUseCase.executar(filmeId)).thenReturn(filmeResponseDTO);

        deletarFilmeValidator.validarDisponibilidadeFilme(filmeId);
    }

    @Test
    void validarDisponibilidadeFilme_FilmeAlugado_DeveLancarExcecao() {
        String filmeId = "1";

        FilmeResponseDTO filmeResponseDTO = new FilmeResponseDTO();
        filmeResponseDTO.setDisponivel(false);

        when(buscarFilmeUseCase.executar(filmeId)).thenReturn(filmeResponseDTO);

        assertThrows(ValidacaoFilmeException.class, () ->
                deletarFilmeValidator.validarDisponibilidadeFilme(filmeId));
    }
}