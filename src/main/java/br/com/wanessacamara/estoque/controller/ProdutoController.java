package br.com.wanessacamara.estoque.controller;

import br.com.wanessacamara.estoque.assembly.ProdutoAssembly;
import br.com.wanessacamara.estoque.dto.ClienteDto;
import br.com.wanessacamara.estoque.dto.ProdutoDto;
import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.repository.ProdutoRepository;
import br.com.wanessacamara.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/todos")
    public ResponseEntity<List<ProdutoDto>> devolveProduto() {
        return ResponseEntity.ok(assembly.converterParaDto(service.devolveProdutos()));
    }
    @PostMapping (value = "/cadastrar")
    public ResponseEntity<String> cadastraProduto(Produto produto) {
        // Verifica se já existe um produto com o mesmo nome
        Produto produtoExistente = repository.findByNomeProduto(produto.getNomeProduto());
        if (produtoExistente != null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um produto com o nome fornecido.");
        } else {
            // Se não existe, salva o produto normalmente
            repository.save(produto);
        }
        return ResponseEntity.ok("Produto cadastrado com sucesso.");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {

        Produto produtoExistente = service.buscarProdutoPorId(id);
        if (produtoExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        produtoExistente.setNomeProduto(produtoDto.getNomeProduto());
        produtoExistente.setPreco(produtoDto.getPreco());

        // Salva as alterações no banco de dados
        service.atualizarProduto(produtoExistente);

        return ResponseEntity.ok("Produto atualizado com sucesso.");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {

        Produto produtoExistente = service.buscarProdutoPorId(id);
        if (produtoExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        service.deletarProduto(produtoExistente);

        return ResponseEntity.ok("Produto deletado com sucesso.");
    }
}


