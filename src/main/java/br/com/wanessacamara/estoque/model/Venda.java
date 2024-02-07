package br.com.wanessacamara.estoque.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_cliente;
    private Double valor_total;
    private Date data;
}
