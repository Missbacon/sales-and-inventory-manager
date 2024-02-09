package br.com.wanessacamara.estoque.controller;

import br.com.wanessacamara.estoque.assembly.VendaAssembly;
import br.com.wanessacamara.estoque.dto.VendaDto;
import br.com.wanessacamara.estoque.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;
    @Autowired
    private VendaAssembly vendaAssembly;

    /*@GetMapping("/{mes}")
    public ResponseEntity<List<VendaDto>> relatorioVendas(@PathVariable Integer mes){
        return ResponseEntity.ok(vendaAssembly.converterParaDto(vendaService.consultaVenda(mes)));

    }*/


}
