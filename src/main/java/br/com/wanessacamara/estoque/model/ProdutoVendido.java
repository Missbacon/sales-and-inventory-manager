package br.com.wanessacamara.estoque.model;

import br.com.wanessacamara.estoque.enums.StatusRelatorio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoVendido {

    private String nome;
    private List<DetalheCompra> detalhesCompras;
    private Integer quantidadeTotal;
    private StatusRelatorio statusRelatorio;


    public ProdutoVendido(int intExact) {
    }
}
