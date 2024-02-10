package br.com.wanessacamara.estoque.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "entrada")
@Getter
@Setter
public class Entrada {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY )
        private Long id;
        private Integer quantidade;
        private Integer mes;
        private Integer ano;




}
