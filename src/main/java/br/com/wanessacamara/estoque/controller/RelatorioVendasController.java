package br.com.wanessacamara.estoque.controller;

import br.com.wanessacamara.estoque.model.RelatorioVendas;
import br.com.wanessacamara.estoque.service.RelatorioVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RelatorioVendasController {

    @Autowired
    private RelatorioVendaService relatorioVendaService;
    @GetMapping("/relatorio-vendas")
    public RelatorioVendas consultarRelatorioVendas(@RequestParam("ano") int ano, @RequestParam("mes") int mes) {
        RelatorioVendas relatorio = relatorioVendaService.gerarRelatorioVendasPorMes(ano, mes);
        return relatorio;
    }
}

