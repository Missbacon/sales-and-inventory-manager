package br.com.wanessacamara.estoque.dto;

import br.com.wanessacamara.estoque.model.comum.Endereco;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteDto {

    private Long idCliente;

    private String nome;

    private Date dataDeNascimento;

    private String cpf;

    private Endereco endereco;
}
