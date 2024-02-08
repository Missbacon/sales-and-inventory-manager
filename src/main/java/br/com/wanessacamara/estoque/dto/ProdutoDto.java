package br.com.wanessacamara.estoque.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

    private Long idProduto;

    private Long codigo;

    private String nomeProduto;

    private Double preco;
}
