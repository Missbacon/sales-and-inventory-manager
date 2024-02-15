package br.com.wanessacamara.estoque.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntradaDto {

    private Long idEntrada;

    private Integer quantidadeEntrada;

    private Integer mes;

    private Integer ano;

    private int codigoProduto;

}
