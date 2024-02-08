package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.model.Entrada;
import br.com.wanessacamara.estoque.model.VendaProduto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MovimentacaoDto {
    private Long idMovimentacao;
    private Entrada idEntrada;
    private VendaProduto idVendaProduto;

}
