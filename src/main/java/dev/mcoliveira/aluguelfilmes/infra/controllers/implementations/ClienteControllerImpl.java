package dev.mcoliveira.aluguelfilmes.infra.controllers.implementations;

import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.AtualizarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.BuscarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.DeletarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.application.usecases.cliente.SalvarClienteUseCase;
import dev.mcoliveira.aluguelfilmes.infra.controllers.ClienteController;
import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteControllerImpl implements ClienteController {

    private final AtualizarClienteUseCase atualizarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final DeletarClienteUseCase deletarClienteUseCase;
    private final SalvarClienteUseCase salvarClienteUseCase;

    @Autowired
    public ClienteControllerImpl(AtualizarClienteUseCase atualizarClienteUseCase,
                                 BuscarClienteUseCase buscarClienteUseCase,
                                 DeletarClienteUseCase deletarClienteUseCase,
                                 SalvarClienteUseCase salvarClienteUseCase) {
        this.atualizarClienteUseCase = atualizarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
        this.deletarClienteUseCase = deletarClienteUseCase;
        this.salvarClienteUseCase = salvarClienteUseCase;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        return ResponseEntity.ok(salvarClienteUseCase.executar(clienteRequestDTO));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@PathVariable String id,
                                                           @RequestBody ClienteRequestDTO clienteRequestDTO) {
        return ResponseEntity.ok(atualizarClienteUseCase.executar(id, clienteRequestDTO));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarCliente(@PathVariable String id) {
        return ResponseEntity.ok(buscarClienteUseCase.executar(id));
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String id) {
        deletarClienteUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }
}