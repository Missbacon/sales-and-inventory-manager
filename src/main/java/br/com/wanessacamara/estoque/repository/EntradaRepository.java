package br.com.wanessacamara.estoque.repository;

import br.com.wanessacamara.estoque.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaRepository extends JpaRepository <Entrada, Long> {

    @Query("SELECT e FROM Entrada e WHERE e.mes = :mes AND e.ano = :ano AND e.codigoProduto = :codigo")
    List<Entrada> findByMesAndAnoAndCodigo(int mes, int ano, long codigo);
}
