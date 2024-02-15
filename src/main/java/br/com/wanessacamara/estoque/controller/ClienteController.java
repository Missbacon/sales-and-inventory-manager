package br.com.wanessacamara.estoque.controller;


import br.com.wanessacamara.estoque.assembly.ClienteAssembly;
import br.com.wanessacamara.estoque.dto.ClienteDto;
import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteAssembly assembly;


    @PostMapping
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody ClienteDto cliente) {
        cliente = assembly.converterParaDto(service.cadastraCliente(assembly.converterParaEntity(cliente)));
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = service.buscarClientePorId(id);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com o ID " + id + " não encontrado");
        }
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {

        Cliente clienteExistente = service.buscarClientePorId(id);
        if (clienteExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com o ID " + id + " não encontrado");
        }

        clienteExistente.setNome(clienteDto.getNome());
        clienteExistente.setCep(clienteDto.getCep());
        service.atualizarCliente(clienteExistente);

        return ResponseEntity.ok(clienteExistente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {

        Cliente clienteExistente = service.buscarClientePorId(id);
        if (clienteExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com o ID " + id + " não encontrado");
        }

        service.deletarCliente(clienteExistente);

        return ResponseEntity.ok("Cliente com o ID: " + id + " DELETADO com sucesso!");
    }
}

