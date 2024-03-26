package dev.mcoliveira.aluguelfilmes.infra.controllers.implementations;

import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.AlugarFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.DevolverFilmeUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.implementations.AlugarFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.application.usecases.aluguel.implementations.DevolverFilmeUseCaseImpl;
import dev.mcoliveira.aluguelfilmes.infra.controllers.AluguelController;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluguel")
public class AluguelControllerImpl implements AluguelController {

    private final AlugarFilmeUseCase alugarFilmeUseCase;
    private final DevolverFilmeUseCase devolverFilmeUseCase;

    @Autowired
    public AluguelControllerImpl(AlugarFilmeUseCase alugarFilmeUseCase,
                                 DevolverFilmeUseCase devolverFilmeUseCase) {

        this.alugarFilmeUseCase = alugarFilmeUseCase;
        this.devolverFilmeUseCase = devolverFilmeUseCase;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<AluguelResponseDTO> alugarFilme(AluguelRequestDTO aluguelRequestDTO) {
        return ResponseEntity.ok(alugarFilmeUseCase.executar(aluguelRequestDTO));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/devolver")
    public ResponseEntity<AluguelResponseDTO> devolverFilme(AluguelRequestDTO aluguelRequestDTO) {
        return ResponseEntity.ok(devolverFilmeUseCase.executar(aluguelRequestDTO));
    }
}