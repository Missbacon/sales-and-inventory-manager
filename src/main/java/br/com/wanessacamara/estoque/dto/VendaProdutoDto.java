package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.model.Venda;


public class VendaProdutoDto {
    private Long idLista;
    private Integer quantidadeVenda;
    private Double valorProdutoTotal;
    private Venda venda;
    private Produto produto;

}
