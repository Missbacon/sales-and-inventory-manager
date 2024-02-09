package br.com.wanessacamara.estoque.controller;


import br.com.wanessacamara.estoque.assembly.ClienteAssembly;
import br.com.wanessacamara.estoque.dto.ClienteDto;
import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteAssembly assembly;


    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody ClienteDto cliente) {
        cliente = assembly.converterParaDto(service.criaCliente(assembly.converterParaEntity(cliente)));
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = service.buscarClientePorId(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        // Verifica se o cliente existe no banco de dados
        Cliente clienteExistente = service.buscarClientePorId(id);
        if (clienteExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }

        // Atualiza os dados do cliente com base nos dados fornecidos no DTO
        clienteExistente.setNome(clienteDto.getNome());
      //  clienteExistente.setDataDeNascimento(clienteDto.getDataDeNascimento());
        clienteExistente.setCep(clienteDto.getCep());

        // Salva as alterações no banco de dados
        service.atualizarCliente(clienteExistente);

        return ResponseEntity.ok("Cliente atualizado com sucesso.");
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        // Verifica se o cliente existe no banco de dados
        Cliente clienteExistente = service.buscarClientePorId(id);
        if (clienteExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }

        service.deletarCliente(clienteExistente);

        return ResponseEntity.ok("Cliente deletado com sucesso.");
    }
}

