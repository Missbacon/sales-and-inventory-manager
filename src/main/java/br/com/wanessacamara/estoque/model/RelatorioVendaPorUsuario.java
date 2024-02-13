package br.com.wanessacamara.estoque.model;

import br.com.wanessacamara.estoque.dto.ClienteDto;
import br.com.wanessacamara.estoque.dto.EnderecoDto;
import br.com.wanessacamara.estoque.dto.VendaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class RelatorioVendaPorUsuario {
    private ClienteDto cliente;
    private EnderecoDto endereco;
    private List<VendaDto> vendas;
}
