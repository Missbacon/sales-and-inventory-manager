package br.com.wanessacamara.estoque.controller;

import br.com.wanessacamara.estoque.dto.RelatorioVendaPorUsuarioDto;
import br.com.wanessacamara.estoque.service.RelatorioVendaPorUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelatorioVendaPorUsuarioController {

    @Autowired
    private RelatorioVendaPorUsuarioService relatorioService;

    @GetMapping("/relatorio-vendas-por-usuario")
    public ResponseEntity<RelatorioVendaPorUsuarioDto> relatorioVendasPorUsuario(@RequestParam String cpf) {
        RelatorioVendaPorUsuarioDto relatorio = relatorioService.gerarRelatorioPorCPF(cpf);
        return ResponseEntity.ok(relatorio);
    }
}