package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.model.Produto;
import br.com.wanessacamara.estoque.repository.ClienteRepository;
import br.com.wanessacamara.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Cliente atualizaCliente(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> optionalCliente = repository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpf(clienteAtualizado.getCpf());
            return repository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
    }

    public void deletaCliente(Long id) {
        Optional<Cliente> optionalCliente = repository.findById(id);

        if (optionalCliente.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
    }
}
