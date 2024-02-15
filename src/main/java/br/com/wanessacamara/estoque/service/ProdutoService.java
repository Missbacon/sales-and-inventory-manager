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

    public void atualizarProduto(Produto produto) {
        repository.save(produto);
    }

    public Produto buscarProdutoPorId(Long id) {
        Optional<Produto> produtoOptional = repository.findById(id);
        return produtoOptional.orElse(null);
    }


    public void deletarProduto(Produto produto) {
        repository.delete(produto);
    }

    public Produto cadastraProduto(Produto produto) {
        return repository.save(produto);
    }

    public String obterNomeProdutoPorCodigo(int codigoProduto) {
        Optional<Produto> produtoOptional = repository.findById((long) codigoProduto);
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            return produto.getNomeProduto();
        } else {
            return null;
        }
    }
}