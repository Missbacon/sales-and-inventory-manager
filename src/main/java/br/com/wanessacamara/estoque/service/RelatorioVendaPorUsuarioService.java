package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.dto.ClienteDto;
import br.com.wanessacamara.estoque.dto.EnderecoDto;
import br.com.wanessacamara.estoque.dto.RelatorioVendaPorUsuarioDto;
import br.com.wanessacamara.estoque.dto.VendaDto;
import br.com.wanessacamara.estoque.exception.UsuarioNotFoundException;
import br.com.wanessacamara.estoque.model.Cliente;
import br.com.wanessacamara.estoque.model.RelatorioVendaPorUsuario;
import br.com.wanessacamara.estoque.model.Venda;
import br.com.wanessacamara.estoque.repository.ClienteRepository;
import br.com.wanessacamara.estoque.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RelatorioVendaPorUsuarioService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ViaCepService viaCepService;



    public RelatorioVendaPorUsuarioDto gerarRelatorioPorCPF(String cpf) {
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);
        if (!clienteOptional.isPresent()) {
            throw new UsuarioNotFoundException("Cliente não encontrado para o CPF: " + cpf);
        }

        Cliente cliente = clienteOptional.get();
        System.out.println("Dados do cliente antes de criar o DTO: " + cliente.toString()); // Adicionando log

        EnderecoDto endereco = viaCepService.buscarEndereco(cliente.getCep());
// Adiciona aspas duplas ao CPF
        String cpfComAspas = "\"" + cpf + "\"";

        // Busca as vendas pelo CPF com aspas
        List<Venda> vendas = vendaRepository.findByCpf(cpfComAspas);
        List<VendaDto> vendasDto = vendas.stream()
                .map(venda -> new VendaDto(venda.getCodigoProduto(), venda.getQuantidade(), venda.getDataCompra()))
                .collect(Collectors.toList());

        System.out.println("Dados do endereço: " + endereco.toString()); // Adicionando log

        return new RelatorioVendaPorUsuarioDto(new ClienteDto(cliente.getNome(), cliente.getDataDeNascimento(), cliente.getCpf(), cliente.getCep()), endereco, vendasDto);
    }
}
