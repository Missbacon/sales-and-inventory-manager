package br.com.wanessacamara.estoque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "venda")
@Getter
@Setter
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_produto")
    private int codigoProduto;

    @Column(name = "cpf_usuario")
    private String cpfUsuario;

    private int quantidade;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_compra")
    private Date dataCompra;

}
