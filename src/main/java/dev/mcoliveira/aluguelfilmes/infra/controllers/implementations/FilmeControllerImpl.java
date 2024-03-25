package dev.mcoliveira.aluguelfilmes.infra.controllers.implementations;

import dev.mcoliveira.aluguelfilmes.application.usecases.filme.*;
import dev.mcoliveira.aluguelfilmes.infra.controllers.FilmeController;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeControllerImpl implements FilmeController {

    private final AtualizarFilmeUseCase atualizarFilmeUseCase;
    private final BuscarFilmeUseCase buscarFilmeUseCase;
    private final DeletarFilmeUseCase deletarFilmeUseCase;
    private final ListarFilmesDisponiveisUseCase listarFilmesDisponiveisUseCase;
    private final SalvarFilmeUseCase salvarFilmeUseCase;

    @Autowired
    public FilmeControllerImpl(AtualizarFilmeUseCase atualizarFilmeUseCase,
                               BuscarFilmeUseCase buscarFilmeUseCase,
                               DeletarFilmeUseCase deletarFilmeUseCase,
                               ListarFilmesDisponiveisUseCase listarFilmesDisponiveisUseCase,
                               SalvarFilmeUseCase salvarFilmeUseCase) {
        this.atualizarFilmeUseCase = atualizarFilmeUseCase;
        this.buscarFilmeUseCase = buscarFilmeUseCase;
        this.deletarFilmeUseCase = deletarFilmeUseCase;
        this.listarFilmesDisponiveisUseCase = listarFilmesDisponiveisUseCase;
        this.salvarFilmeUseCase = salvarFilmeUseCase;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<FilmeResponseDTO> salvarFilme(@RequestBody FilmeRequestDTO filmeRequestDTO) {
        return ResponseEntity.ok(salvarFilmeUseCase.executar(filmeRequestDTO));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> atualizarFilme(@PathVariable String id,
                                                           @RequestBody FilmeRequestDTO filmeRequestDTO) {
        return ResponseEntity.ok(atualizarFilmeUseCase.executar(id, filmeRequestDTO));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/disponiveis")
    public ResponseEntity<List<FilmeResponseDTO>> listarFilmesDisponiveis(
            @PageableDefault(page = 0, size = 20, sort = "titulo", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(listarFilmesDisponiveisUseCase.executar(pageable));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> buscarFilme(@PathVariable String id) {
        return ResponseEntity.ok(buscarFilmeUseCase.executar(id));
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable String id) {
        deletarFilmeUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }
}