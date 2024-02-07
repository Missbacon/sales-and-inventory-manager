package br.com.wanessacamara.estoque.model;

import br.com.wanessacamara.estoque.model.comum.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "Cliente")
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date dataDeNascimento;

    private String cpf;

    @Embedded
    private Endereco endereco;
}
