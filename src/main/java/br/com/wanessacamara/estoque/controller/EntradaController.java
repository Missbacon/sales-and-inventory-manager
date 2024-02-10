package br.com.wanessacamara.estoque.controller;


import br.com.wanessacamara.estoque.model.Entrada;
import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.repository.EntradaRepository;
import br.com.wanessacamara.estoque.service.EntradaService;
import br.com.wanessacamara.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/entradas")
public class EntradaController {
    @Autowired
    private EntradaRepository repository;

    @Autowired
    private EntradaService service;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/{produtoId}")
    public ResponseEntity<?> registrarProdutoMes(@PathVariable Long produtoId, @RequestParam int quantidade, @RequestParam int mes, @RequestParam int ano) {
        Produto produtoExistente = produtoService.buscarProdutoPorId(produtoId);
        if (produtoExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com o ID " + produtoId + " não encontrado");
        }

        Entrada entradaProduto = new Entrada();
        entradaProduto.setQuantidade(quantidade);
        entradaProduto.setMes(mes);
        entradaProduto.setAno(ano);
        repository.save(entradaProduto);

        return ResponseEntity.ok(entradaProduto);
    }

    

}
