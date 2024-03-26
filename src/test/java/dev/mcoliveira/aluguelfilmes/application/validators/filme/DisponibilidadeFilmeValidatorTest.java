package dev.mcoliveira.aluguelfilmes.application.validators.filme;

import dev.mcoliveira.aluguelfilmes.application.exceptions.ValidacaoException;
import dev.mcoliveira.aluguelfilmes.application.usecases.filme.BuscarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DisponibilidadeFilmeValidatorTest {

    @Mock
    private BuscarFilmeUseCase buscarFilmeUseCase;

    @Test
    void validarDisponibilidadeFilme_FilmeNaoAlugado_DevePassarSemExcecao() {
        String filmeId = "1";

        FilmeResponseDTO filmeResponseDTO = new FilmeResponseDTO();
        filmeResponseDTO.setDisponivel(true);

        when(buscarFilmeUseCase.executar(filmeId)).thenReturn(filmeResponseDTO);

        assertDoesNotThrow(() -> DisponibilidadeFilmeValidator.validar(filmeId, buscarFilmeUseCase));
    }

    @Test
    void validarDisponibilidadeFilme_FilmeAlugado_DeveLancarExcecao() {
        String filmeId = "1";

        FilmeResponseDTO filmeResponseDTO = new FilmeResponseDTO();
        filmeResponseDTO.setDisponivel(false);

        when(buscarFilmeUseCase.executar(filmeId)).thenReturn(filmeResponseDTO);

        assertThrows(ValidacaoException.class, () ->
                DisponibilidadeFilmeValidator.validar(filmeId, buscarFilmeUseCase));
    }
}