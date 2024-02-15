package br.com.wanessacamara.estoque.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private String nome;

    private Date dataDeNascimento;

    private String cpf;

    private String cep;
}
