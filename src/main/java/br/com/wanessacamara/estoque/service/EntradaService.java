package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.model.Entrada;
import br.com.wanessacamara.estoque.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository repository;
    public Entrada cadastraEntrada(Entrada entrada) {
        return repository.save(entrada);
    }

    public int calcularTotalEntradasPorMesEProduto(int mes, int ano, int codigo) {
        List<Entrada> entradas = repository.findByMesAndAnoAndCodigo(mes, ano, codigo);

        int total = 0;
        for (Entrada entrada : entradas) {
            total += entrada.getQuantidadeEntrada();
        }
        return total;
    }


}
