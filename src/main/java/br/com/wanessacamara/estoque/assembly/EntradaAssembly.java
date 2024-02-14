package br.com.wanessacamara.estoque.assembly;

import br.com.wanessacamara.estoque.dto.EntradaDto;
import br.com.wanessacamara.estoque.model.Entrada;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntradaAssembly {


    public Entrada converterParaEntity(EntradaDto dto) {
        Entrada entity = new Entrada();

        entity.setId(dto.getIdEntrada());
        entity.setMes(dto.getMes());
        entity.setAno(dto.getAno());
        entity.setQuantidadeEntrada(dto.getQuantidadeEntrada());
        entity.setCodigoProduto(dto.getCodigoProduto());
        return entity;
    }

    public EntradaDto converterParaDto(Entrada entity) {
        EntradaDto  dto = new EntradaDto();

        dto.setIdEntrada(entity.getId());
        dto.setMes(entity.getMes());
        dto.setAno(entity.getAno());
        dto.setQuantidadeEntrada(entity.getQuantidadeEntrada());
       dto.setCodigoProduto(entity.getCodigoProduto());
        return dto;
    }

    public List<Entrada> converterParaEntity(List<EntradaDto> dtos) {
        return dtos.stream().map(dto -> this.converterParaEntity(dto)).toList();
    }

    public  List<EntradaDto> converterParaDto(List<Entrada> entities) {
        return entities.stream().map(entity -> this.converterParaDto(entity)).toList();
    }
}
