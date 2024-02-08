package br.com.wanessacamara.estoque.controller;

import br.com.wanessacamara.estoque.assembly.ProdutoAssembly;
import br.com.wanessacamara.estoque.dto.ProdutoDto;
import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/todos")
    public ResponseEntity<List<ProdutoDto>> devolveProduto() {
        return ResponseEntity.ok(assembly.converterParaDto(service.devolveProdutos()));
    }

    @PostMapping(value = "/salva")
    public ResponseEntity<Produto> salvaIProduto(@RequestBody ProdutoDto itemsalvo) {
        return ResponseEntity.created(null).body(service.criaProduto(assembly.converterParaEntity(itemsalvo)));
    }

    @PutMapping(value = "/atualiza/{idProduto}")
    public ResponseEntity<Produto> atualizaProduto(@PathVariable Long idProduto, @RequestBody ProdutoDto produtoDto) {
        Produto produtoAtualizado = assembly.converterParaEntity(produtoDto);
        Produto produto = service.atualizaProduto(idProduto, produtoAtualizado);
        return ResponseEntity.ok(produto);
    }


}
