package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> devolveProdutos() {
        return repository.findAll();
    }

    public Produto criaProduto(Produto produto) {
        return repository.save(produto);
    }

    public void deletaProduto(Long id) {
        repository.deleteById(id);
    }

    public Produto atualizaProduto(Long id, Produto produtoAtualizado) {
        Optional<Produto> optionalProduto = repository.findById(id);

        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setCodigo(produtoAtualizado.getCodigo());
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return repository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }
}