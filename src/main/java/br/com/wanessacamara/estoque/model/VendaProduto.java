package br.com.wanessacamara.estoque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "venda_produto")
public class VendaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_venda;
    private Long id_produto;
    private Integer quantidade_venda;
    private Double valor_produto_total;
}

