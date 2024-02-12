package br.com.wanessacamara.estoque.repository;

import br.com.wanessacamara.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findByCodigo(Long codigo);
}
