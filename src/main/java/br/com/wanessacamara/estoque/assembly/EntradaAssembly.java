package br.com.wanessacamara.estoque.assembly;

import br.com.wanessacamara.estoque.dto.EntradaDto;
import br.com.wanessacamara.estoque.model.Entrada;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntradaAssembly {


    public Entrada converterParaEntity(EntradaDto dto) {
        Entrada entity = new Entrada();

        entity.setIdEntrada(dto.getIdEntrada());
        entity.setDataEntrada(dto.getDataEntrada());
        entity.setQuantidadeEntrada(dto.getQuantidadeEntrada());
        entity.setProduto(dto.getProduto());
        return entity;
    }

    public EntradaDto converterParaDto(Entrada entity) {
        EntradaDto  dto = new EntradaDto();

        dto.setIdEntrada(entity.getIdEntrada());
        dto.setDataEntrada(entity.getDataEntrada());
        dto.setQuantidadeEntrada(entity.getQuantidadeEntrada());
        dto.setProduto(entity.getProduto());
        return dto;
    }

    public List<Entrada> converterParaEntity(List<EntradaDto> dtos) {
        return dtos.stream().map(dto -> this.converterParaEntity(dto)).toList();
    }

    public  List<EntradaDto> converterParaDto(List<Entrada> entities) {
        return entities.stream().map(entity -> this.converterParaDto(entity)).toList();
    }
}
