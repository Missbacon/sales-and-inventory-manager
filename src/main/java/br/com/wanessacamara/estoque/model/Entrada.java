package br.com.wanessacamara.estoque.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "entrada")
@Getter
@Setter
public class Entrada {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY )
        private Long idEntrada;
        private Integer quantidadeEntrada;
        private Date dataEntrada;

        @ManyToOne
        @JoinColumn(name = "id_produto", referencedColumnName = "idProduto", insertable = false, updatable = false)
        private Produto produto;
}
