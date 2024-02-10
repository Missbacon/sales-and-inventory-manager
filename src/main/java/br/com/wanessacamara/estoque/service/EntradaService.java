package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.model.Entrada;
import br.com.wanessacamara.estoque.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository repository;
    public Entrada cadastraEntrada(Entrada entrada) {
        return repository.save(entrada);
    }


}
