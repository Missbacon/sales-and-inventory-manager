package br.com.wanessacamara.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Deve conter um cpf")
    @Size(min = 11, max = 11, message = "O cpf deve conter 11 caracteres")
    @Column(unique = true, nullable = false)
    private String cpf;

    @NotEmpty(message = "Cliente deve conter um nome")
    private String nome;

    private Date dataDeNascimento;

    @NotEmpty
    @Size(min = 8, max = 8, message = "Cep deve conter 8 numeros sem espaços ou caracteres especiais")
    @Column(nullable = false)
    private String cep;
}
