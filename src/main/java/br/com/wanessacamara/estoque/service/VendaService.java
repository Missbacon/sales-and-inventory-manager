package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.model.Venda;
import br.com.wanessacamara.estoque.model.VendaProduto;
import br.com.wanessacamara.estoque.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository repository;

    public Venda criaVenda() {
        Produto produto = new Produto();
        VendaProduto vendaProduto =new VendaProduto();
        vendaProduto.setProduto(produto);
        Venda venda = new Venda();
        venda.setVendaProdutos(new ArrayList<>());
        venda.getVendaProdutos().add(vendaProduto);
        return repository.save(venda);
    }

    public List<Venda> consultaVenda(Integer mes){
        Date dataInicial = Date.from(Instant.now());
        dataInicial.setMonth(mes);
        dataInicial.setDate(1);
        Date dataFinal = new Date(dataInicial.getYear(),mes , 31);
        return repository.findByStartDateBetween(dataInicial , dataFinal);
    }
}
