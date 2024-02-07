package br.com.wanessacamara.estoque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_entrada;
    private Long id_venda_produto;

}
