package br.com.wanessacamara.estoque.assembly;

import br.com.wanessacamara.estoque.dto.VendaDto;
import br.com.wanessacamara.estoque.model.Venda;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class VendaAssembly {
    public Venda converterParaEntity (VendaDto dto){
        Venda entity = new Venda();
       // entity.setId(dto.getId());
        entity.setQuantidade(dto.getQuantidade());
        entity.setDataCompra(dto.getDataCompra());
        entity.setCodigoProduto(dto.getCodigoProduto());
        return entity;
    }
    public VendaDto converterParaDto (Venda entity){
        VendaDto dto = new VendaDto();
       // dto.setId(entity.getId());
        dto.setQuantidade(entity.getQuantidade());
        dto.setDataCompra(entity.getDataCompra());
        dto.setCodigoProduto(entity.getCodigoProduto());
        return dto;
    }




}
