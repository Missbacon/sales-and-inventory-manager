package br.com.wanessacamara.estoque.controller;

import br.com.wanessacamara.estoque.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadVendas(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Arquivo não pode ser vazio.");
        }

        try {
            service.processarUploadVendas(file);
            return ResponseEntity.ok("Upload de vendas realizado com sucesso.");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}

