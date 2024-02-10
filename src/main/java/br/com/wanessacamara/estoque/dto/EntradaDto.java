package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.model.Produto;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter
public class EntradaDto {

    private Long idEntrada;

    private Integer quantidadeEntrada;

    private Integer mes;

    private Integer ano;

}
