package br.com.wanessacamara.estoque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalheCompra {
 
        private String cpf;
        private Date dataCompra;
        private int quantidade;


}

