package br.com.wanessacamara.estoque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movimentacao")
@Getter
@Setter
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimentacao;

   /* @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Entrada id;*/

   /* @ManyToOne
    @JoinColumn(name = "id_venda_produto", referencedColumnName = "idLista", insertable = false, updatable = false)
    private VendaProduto idVendaProduto;*/

}
