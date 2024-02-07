package br.com.wanessacamara.estoque.repository;

import br.com.wanessacamara.estoque.model.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaProdutoRepository extends JpaRepository<VendaProduto, Long> {
}
