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
    private Long idVenda;
    private Double valorTotal;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    private Cliente cliente;
}
