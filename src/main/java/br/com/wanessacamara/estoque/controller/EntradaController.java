package br.com.wanessacamara.estoque.controller;


import br.com.wanessacamara.estoque.exception.ProdutoNotFoundException;
import br.com.wanessacamara.estoque.model.Entrada;
import br.com.wanessacamara.estoque.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @PostMapping("/{produtoId}")
    public ResponseEntity<?> registrarProdutoMes(@PathVariable Long produtoId, @RequestParam int quantidade, @RequestParam int mes, @RequestParam int ano) {
        try {
            Entrada entradaProduto = entradaService.registrarEntradaProduto(produtoId, quantidade, mes, ano);
            return ResponseEntity.ok(entradaProduto);
        } catch (ProdutoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
