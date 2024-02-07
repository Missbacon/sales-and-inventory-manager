package br.com.wanessacamara.estoque.assembly;

import br.com.wanessacamara.estoque.dto.ProdutoDto;
import br.com.wanessacamara.estoque.model.Produto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoAssembly {
    public Produto converterParaEntity(ProdutoDto dto) {
        Produto entity = new Produto();
        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setIdProduto(dto.getIdProduto());
        return entity;
    }

    public ProdutoDto converterParaDto(Produto entity) {
        ProdutoDto dto = new ProdutoDto();
        dto.setCodigo(entity.getCodigo());
        dto.setNome(entity.getNome());
        dto.setIdProduto(entity.getIdProduto());
        return dto;
    }

    public List<Produto> converterParaEntity(List<ProdutoDto> dtos) {
        return dtos.stream().map(dto -> this.converterParaEntity(dto)).toList();
    }

    public  List<ProdutoDto> converterParaDto(List<Produto> entities) {
        return entities.stream().map(entity -> this.converterParaDto(entity)).toList();
    }
}
