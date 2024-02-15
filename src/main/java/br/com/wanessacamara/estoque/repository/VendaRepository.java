package br.com.wanessacamara.estoque.repository;

import br.com.wanessacamara.estoque.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataCompraBetween(LocalDate primeiroDia, LocalDate ultimoDia);

    default List<Venda> findByMes(int ano, int mes) {
        LocalDate primeiroDia = LocalDate.of(ano, mes, 1);
        LocalDate ultimoDia = primeiroDia.withDayOfMonth(primeiroDia.lengthOfMonth());

        return findByDataCompraBetween(primeiroDia, ultimoDia);
    }

    List<Venda> findByCpf(String cpf);
}

