package br.com.wanessacamara.estoque.controller;


import br.com.wanessacamara.estoque.assembly.ClienteAssembly;
import br.com.wanessacamara.estoque.dto.ClienteDto;
import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteAssembly assembly;


    @PostMapping(value = "/salva")
    public ResponseEntity<Cliente> salvaIProduto(@RequestBody ClienteDto clientesalvo) {
        return ResponseEntity.created(null).body(service.criaCliente(assembly.converterParaEntity(clientesalvo)));

    }
}
