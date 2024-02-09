package br.com.wanessacamara.estoque.model;

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
    private String cpf;

    private String nome;

    private Date dataDeNascimento;

    private String cep;
}
