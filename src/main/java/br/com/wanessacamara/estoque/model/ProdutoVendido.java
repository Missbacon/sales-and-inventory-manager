package br.com.wanessacamara.estoque.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoVendido {

    private String nome;
    private int quantidade;

    public ProdutoVendido(int codigoProduto) {
    }

    public void aumentarQuantidade(int quantidade) {
    }
}
