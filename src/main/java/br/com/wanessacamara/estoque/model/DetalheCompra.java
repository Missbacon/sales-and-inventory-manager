package br.com.wanessacamara.estoque.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class DetalheCompra {
 
        private String usuario;
        private Date dataCompra;
        private int quantidade;

    public DetalheCompra(String cpfUsuario, Date dataCompra, int quantidade) {
    }
}
