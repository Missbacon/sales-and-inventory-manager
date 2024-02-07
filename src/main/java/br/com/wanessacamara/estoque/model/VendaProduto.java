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
    private Double valorProdutoTotal;

    @ManyToOne
    @JoinColumn(name = "id_venda", referencedColumnName = "idVenda", insertable = false, updatable = false)
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "idProduto", insertable = false, updatable = false)
    private Produto produto;
}

