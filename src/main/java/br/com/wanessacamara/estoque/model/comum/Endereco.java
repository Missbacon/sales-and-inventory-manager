package br.com.wanessacamara.estoque.model.comum;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Endereco {


    private String logradouro;

    private int numero;

    private String complemento;

    private String cep;




}
