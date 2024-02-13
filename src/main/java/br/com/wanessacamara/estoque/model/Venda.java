package br.com.wanessacamara.estoque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "venda")
@Getter
@Setter
@NoArgsConstructor
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_produto")
    private int codigoProduto;

    @Column(name = "cpf_usuario")
    private String cpf;

    private int quantidade;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_compra")
    private Date dataCompra;

    public Venda(int codigoProduto, int quantidade, Date dataCompra) {
    }
}
