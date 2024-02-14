package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional
    public void deletaProduto(Long id) {
        Optional<Produto> optionalProduto = repository.findById(id);

        if (optionalProduto.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }

    @Transactional
    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Optional<Produto> optionalProduto = repository.findById(id);

        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setNomeProduto(produtoAtualizado.getNomeProduto());
            produto.setPreco(produtoAtualizado.getPreco());
            return repository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }

    public Produto buscarProdutoPorId(Long id) {
        Optional<Produto> produtoOptional = repository.findById(id);
        return produtoOptional.orElse(null);
    }

    @Transactional
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
            // Se o produto com o código especificado não for encontrado, retornar null
            return null;
        }
    }
}