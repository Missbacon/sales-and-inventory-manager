package br.com.wanessacamara.estoque.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

    private Long id;

    private Long codigo;

    private String nome;

    private Double preco;
}
