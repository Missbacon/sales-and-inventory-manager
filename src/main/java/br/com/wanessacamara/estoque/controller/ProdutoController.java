package br.com.wanessacamara.estoque.controller;

import br.com.wanessacamara.estoque.assembly.ProdutoAssembly;
import br.com.wanessacamara.estoque.dto.ClienteDto;
import br.com.wanessacamara.estoque.dto.ProdutoDto;
import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.repository.ProdutoRepository;
import br.com.wanessacamara.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoAssembly assembly;

    @Autowired
    private ProdutoRepository repository;


    @PostMapping (value = "/cadastrar")
    public ResponseEntity<ProdutoDto> cadastraProduto(@RequestBody ProdutoDto produto) {
        produto = assembly.converterParaDto(service.cadastraProduto(assembly.converterParaEntity(produto)));
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = service.buscarProdutoPorId(id);
        if (produto== null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto com o ID " + id + " não encontrado");
        }
        return ResponseEntity.ok(produto);
    }

    @GetMapping(value = "/todos")
    public ResponseEntity<List<ProdutoDto>> devolveProduto() {
        return ResponseEntity.ok(assembly.converterParaDto(service.devolveProdutos()));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {

        Produto produtoExistente = service.buscarProdutoPorId(id);
        if (produtoExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        produtoExistente.setNomeProduto(produtoDto.getNomeProduto());
        produtoExistente.setPreco(produtoDto.getPreco());

        service.atualizarProduto(produtoExistente);
        return ResponseEntity.ok(produtoExistente);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {

        Produto produtoExistente = service.buscarProdutoPorId(id);
        if (produtoExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        service.deletarProduto(produtoExistente);
        return ResponseEntity.ok("Produto Deletado com sucesso");
    }
}


