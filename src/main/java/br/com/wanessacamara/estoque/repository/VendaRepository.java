package br.com.wanessacamara.estoque.repository;

import br.com.wanessacamara.estoque.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
