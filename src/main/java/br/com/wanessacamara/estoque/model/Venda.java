package br.com.wanessacamara.estoque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "venda")
@Getter
@Setter
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    private Double valorTotal;

    private Date dataVenda;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venda", referencedColumnName = "idVenda")
    private List<VendaProduto> vendaProdutos;


    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Cliente cliente;
}
