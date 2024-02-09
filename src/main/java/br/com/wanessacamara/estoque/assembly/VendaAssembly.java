package br.com.wanessacamara.estoque.assembly;

import br.com.wanessacamara.estoque.dto.VendaDto;
import br.com.wanessacamara.estoque.model.Venda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendaAssembly {
    public Venda converterParaEntity(VendaDto dto) {
        Venda entity = new Venda();
        entity.setIdVenda(dto.getIdVenda());
        entity.setDataVenda(dto.getDataVenda());
        entity.setValorTotal(dto.getValorTotal());
        entity.setCliente(dto.getCpf());
        return entity;
    }
    public VendaDto converterParaDto (Venda entity) {
        VendaDto dto = new VendaDto();
        dto.setIdVenda(entity.getIdVenda());
        dto.setDataVenda(entity.getDataVenda());
        dto.setValorTotal(entity.getValorTotal());
        dto.setCpf(entity.getCliente());
        return dto;
    }

    public List<VendaDto> converterParaDto (List<Venda> entities){
       return entities.stream().map(this::converterParaDto).toList();
    }

}
