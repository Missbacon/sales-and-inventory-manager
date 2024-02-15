package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.exception.ProdutoNotFoundException;
import br.com.wanessacamara.estoque.model.Entrada;
import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository repository;

    @Autowired
    private ProdutoService produtoService;

    @Transactional
    public Entrada registrarEntradaProduto(Long produtoId, int quantidade, int mes, int ano) throws ProdutoNotFoundException {
        Produto produtoExistente = produtoService.buscarProdutoPorId(produtoId);
        if (produtoExistente == null) {
            throw new ProdutoNotFoundException("Produto com o ID " + produtoId + " não encontrado");
        }

        int codigoProduto = Math.toIntExact(produtoExistente.getCodigo());

        Entrada entradaProduto = new Entrada();
        entradaProduto.setQuantidadeEntrada(quantidade);
        entradaProduto.setMes(mes);
        entradaProduto.setAno(ano);
        entradaProduto.setCodigoProduto(codigoProduto);
       repository.save(entradaProduto);

        return entradaProduto;
    }

    public int calcularTotalEntradasPorMesEProduto(int mes, int ano, int codigo) {
        List<Entrada> entradas = repository.findByMesAndAnoAndCodigo(mes, ano, codigo);

        int total = 0;
        for (Entrada entrada : entradas) {
            total += entrada.getQuantidadeEntrada();
        }
        return total;
    }


}
