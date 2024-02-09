package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.model.Venda;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VendaProdutoDto {
    private Long idLista;
    private Integer quantidadeVenda;
    private Double valorProdutoTotal;
    private Venda idVenda;
    private Produto codigo;

}
