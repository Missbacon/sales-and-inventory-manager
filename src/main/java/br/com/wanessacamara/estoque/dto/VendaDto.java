package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.model.Cliente;


import java.util.Date;

public class VendaDto {
    private Long idVenda;
    private Double valorTotal;
    private Date data;
    private Cliente cliente;
}
