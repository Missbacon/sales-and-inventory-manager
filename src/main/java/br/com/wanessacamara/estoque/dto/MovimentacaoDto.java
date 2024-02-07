package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.model.Entrada;
import br.com.wanessacamara.estoque.model.VendaProduto;


public class MovimentacaoDto {
    private Long id;
    private Long id_entrada;
    private Long id_venda_produto;
    private Entrada entrada;
    private VendaProduto vendaProduto;
}
