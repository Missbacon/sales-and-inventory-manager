package br.com.wanessacamara.estoque.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class VendaDto {
    private Long id;

    private int codigoProduto;

    private String cpf;

    private int quantidade;

    private Date dataCompra;





    public VendaDto(int codigoProduto, int quantidade, Date dataCompra) {
    }
}