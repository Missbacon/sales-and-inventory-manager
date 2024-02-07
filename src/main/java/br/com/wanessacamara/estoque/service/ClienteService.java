package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.repository.ClienteRepository;
import br.com.wanessacamara.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    public List<Cliente> devolveClientes(){
        return repository.findAll();
    }

    public Cliente criaCliente(Cliente cliente) {
        return repository.save(cliente);
    }
}
