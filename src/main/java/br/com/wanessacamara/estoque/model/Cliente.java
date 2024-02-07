package br.com.wanessacamara.estoque.model;

import br.com.wanessacamara.estoque.model.comum.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nome;

    private Date dataDeNascimento;

    private String cpf;

    @Embedded
    private Endereco endereco;
}
