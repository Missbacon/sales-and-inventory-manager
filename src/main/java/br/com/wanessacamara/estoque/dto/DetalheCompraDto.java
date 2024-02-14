package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.enums.StatusRelatorio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalheCompraDto {
    private String cpf;
    private Date dataCompra;
    private int quantidade;
    private StatusRelatorio status;
}
