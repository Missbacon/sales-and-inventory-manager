package br.com.wanessacamara.estoque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RelatorioVendas {
    private List<ProdutoVendido> produtosVendidos;

    public RelatorioVendas() {

    }
}
