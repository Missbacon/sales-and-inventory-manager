package br.com.wanessacamara.estoque.assembly;


import br.com.wanessacamara.estoque.dto.ClienteDto;
import br.com.wanessacamara.estoque.model.Cliente;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ClienteAssembly {


    public Cliente converterParaEntity(ClienteDto dto) {
        Cliente entity = new Cliente();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setIdCliente(dto.getIdCliente());
        entity.setEndereco(dto.getEndereco());
        entity.setDataDeNascimento(dto.getDataDeNascimento());
        return entity;
    }

    public ClienteDto converterParaDto(Cliente entity) {
        ClienteDto dto = new ClienteDto();
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setIdCliente(entity.getIdCliente());
        dto.setEndereco(entity.getEndereco());
        dto.setDataDeNascimento(entity.getDataDeNascimento());
        return dto;
    }

    public List<Cliente> converterParaEntity(List<ClienteDto> dtos) {
        return dtos.stream().map(dto -> this.converterParaEntity(dto)).toList();
    }

    public  List<ClienteDto> converterParaDto(List<Cliente> entities) {
        return entities.stream().map(entity -> this.converterParaDto(entity)).toList();
    }
}
