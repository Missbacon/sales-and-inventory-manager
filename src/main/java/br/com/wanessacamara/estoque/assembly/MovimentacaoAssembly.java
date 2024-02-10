package br.com.wanessacamara.estoque.assembly;

import br.com.wanessacamara.estoque.dto.MovimentacaoDto;
import br.com.wanessacamara.estoque.model.Movimentacao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovimentacaoAssembly {


    /*public Movimentacao  converterParaEntity(MovimentacaoDto dto) {
         Movimentacao entity = new Movimentacao();

        entity.setIdMovimentacao (dto.getIdMovimentacao());
         entity.setIdEntrada(entity.getIdEntrada());
         entity.setIdVendaProduto(entity.getIdVendaProduto());
         return entity;
    }

    public MovimentacaoDto converterParaDto(Movimentacao entity) {
        MovimentacaoDto  dto = new MovimentacaoDto();

        dto.setIdMovimentacao(entity.getIdMovimentacao());
        dto.setIdVendaProduto(entity.getIdVendaProduto());
        dto.setIdEntrada(entity.getIdEntrada());
        return dto;
    }

    public List<Movimentacao> converterParaEntity(List<MovimentacaoDto> dtos) {
        return dtos.stream().map(dto -> this.converterParaEntity(dto)).toList();
    }

    public  List<MovimentacaoDto> converterParaDto(List<Movimentacao> entities) {
        return entities.stream().map(entity -> this.converterParaDto(entity)).toList();
    */
}
