package br.com.wanessacamara.estoque.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioVendaPorUsuarioDto {

    private ClienteDto cliente;

    private EnderecoDto endereco;

    private List<VendaDto> vendas;
}
