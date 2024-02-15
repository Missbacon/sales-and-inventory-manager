package br.com.wanessacamara.estoque.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;
}
