package br.com.wanessacamara.estoque.model;

import br.com.wanessacamara.estoque.enums.StatusRelatorio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_produto")
    private Integer codigoProduto;

    @Column(name = "cpf_usuario")
    private String cpf;

    private int quantidade;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_compra")
    private Date dataCompra;

    private StatusRelatorio statusRelatorio;

    public Venda(int codigoProduto, int quantidade, Date dataCompra) {
    }
}
