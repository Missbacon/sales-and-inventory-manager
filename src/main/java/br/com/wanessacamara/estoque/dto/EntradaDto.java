package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.model.Produto;


import java.util.Date;

public class EntradaDto {

    private Long idEntrada;
    private Integer quantidadeEntrada;
    private Date dataEntrada;
    private Produto produto;
}
