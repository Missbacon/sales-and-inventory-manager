package br.com.wanessacamara.estoque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoVendido {

    private String nome;
    private int quantidade;


    public ProdutoVendido(int intExact) {
    }
}
