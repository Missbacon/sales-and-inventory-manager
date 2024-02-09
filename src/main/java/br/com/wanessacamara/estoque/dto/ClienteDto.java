package br.com.wanessacamara.estoque.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteDto {


    private String nome;

    private Date dataDeNascimento;

    private String cpf;

    private String cep;
}
