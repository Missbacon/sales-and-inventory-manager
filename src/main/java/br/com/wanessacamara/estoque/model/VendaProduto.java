package br.com.wanessacamara.estoque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "venda_produto")
@Setter
@Getter
public class VendaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLista;

    private Integer quantidadeVenda;



    @ManyToOne
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    private Produto produto;
}

