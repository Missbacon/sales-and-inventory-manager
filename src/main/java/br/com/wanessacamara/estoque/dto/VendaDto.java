package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.model.Cliente;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter
public class VendaDto {
    private Long idVenda;
    private Double valorTotal;
    private Date dataVenda;
    private Cliente cpf;
}
