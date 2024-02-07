package br.com.wanessacamara.estoque.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity(name = "entrada")
@Getter
@Setter
public class Entrada {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY )
        private Long id;
        private Long id_produto;
        private Integer quantidade_entrada;
        private Date date;
}
