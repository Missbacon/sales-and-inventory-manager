package br.com.wanessacamara.estoque.repository;

import br.com.wanessacamara.estoque.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends JpaRepository <Entrada, Long> {
}
