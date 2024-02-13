package br.com.wanessacamara.estoque.repository;

import br.com.wanessacamara.estoque.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataCompraBetween(LocalDate primeiroDia, LocalDate ultimoDia);

    // Método personalizado para buscar vendas de um determinado mês
    default List<Venda> findByMes(int ano, int mes) {
        // Obtém o primeiro dia do mês
        LocalDate primeiroDia = LocalDate.of(ano, mes, 1);

        // Obtém o último dia do mês
        LocalDate ultimoDia = primeiroDia.withDayOfMonth(primeiroDia.lengthOfMonth());

        // Chama o método findByDataCompraBetween com os parâmetros calculados
        return findByDataCompraBetween(primeiroDia, ultimoDia);
    }

  
    List<Venda> findByCpf(String cpf);
}

