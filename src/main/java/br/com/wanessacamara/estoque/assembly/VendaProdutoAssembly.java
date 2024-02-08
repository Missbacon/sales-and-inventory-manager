package br.com.wanessacamara.estoque.assembly;

import br.com.wanessacamara.estoque.dto.VendaProdutoDto;
import br.com.wanessacamara.estoque.model.VendaProduto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendaProdutoAssembly {
    public VendaProduto converterParaEntity(VendaProdutoDto dto) {
        VendaProduto entity = new VendaProduto();
        entity.setProduto(dto.getIdProduto());
        entity.setQuantidadeVenda(dto.getQuantidadeVenda());
        entity.setIdLista(dto.getIdLista());
        return entity;
    }

    public VendaProdutoDto converterParaDto(VendaProduto entity) {
        VendaProdutoDto dto = new VendaProdutoDto();
        dto.setIdProduto(entity.getProduto());
        dto.setQuantidadeVenda(entity.getQuantidadeVenda());
        dto.setIdLista(entity.getIdLista());
        return dto;
    }

}
