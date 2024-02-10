package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    public List<Cliente> devolveClientes(){
        return repository.findAll();
    }

    public Cliente cadastraCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        repository.save(cliente);
    }


    public Cliente buscarClientePorId(Long id) {
        Optional<Cliente> clienteOptional = repository.findById(id);
        return clienteOptional.orElse(null);
    }

    @Transactional
    public void deletarCliente(Cliente cliente) {
        repository.delete(cliente);
    }
}



