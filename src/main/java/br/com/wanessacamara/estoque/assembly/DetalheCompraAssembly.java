package br.com.wanessacamara.estoque.assembly;

import br.com.wanessacamara.estoque.dto.DetalheCompraDto;
import br.com.wanessacamara.estoque.model.DetalheCompra;
import org.springframework.stereotype.Component;

@Component
public class DetalheCompraAssembly {
    public DetalheCompra converterParaEntity(DetalheCompraDto dto){
        DetalheCompra entity = new DetalheCompra();

        entity.setCpf(dto.getCpf());
        entity.setDataCompra(dto.getDataCompra());
        entity.setQuantidade(dto.getQuantidade());
        return entity;

    }
    public DetalheCompraDto converterParaDto(DetalheCompra entity){
        DetalheCompraDto dto = new DetalheCompraDto();
        dto.setCpf(entity.getCpf());
        dto.setDataCompra(entity.getDataCompra());
        dto.setQuantidade(entity.getQuantidade());
        return dto;
    }


}
