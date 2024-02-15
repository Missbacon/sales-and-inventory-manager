package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.enums.StatusRelatorio;
import br.com.wanessacamara.estoque.model.DetalheCompra;
import br.com.wanessacamara.estoque.model.ProdutoVendido;
import br.com.wanessacamara.estoque.model.RelatorioVendas;
import br.com.wanessacamara.estoque.model.Venda;
import br.com.wanessacamara.estoque.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RelatorioVendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private EntradaService entradaService;

    public RelatorioVendas gerarRelatorioVendasPorMes(int ano, int mes) {

        Calendar cal = Calendar.getInstance();
        cal.set(ano, mes - 1, 1);
        Date inicioMes = cal.getTime();

        cal.set(ano, mes - 1, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date fimMes = cal.getTime();

        List<Venda> vendasDoMes = vendaRepository.findByMes(ano,mes);

        Map<Integer, ProdutoVendido> produtosVendidosMap = new HashMap<>();

        for (Venda venda : vendasDoMes) {
            int codigo = (int) venda.getCodigoProduto();


            String nomeProduto = produtoService.obterNomeProdutoPorCodigo(codigo);

            List<DetalheCompra> detalhesCompras = new ArrayList<>();

            produtosVendidosMap.putIfAbsent(codigo, new ProdutoVendido(codigo));
            ProdutoVendido produtoVendido = produtosVendidosMap.get(codigo);
            produtoVendido.setNome(nomeProduto);

            detalhesCompras.add(new DetalheCompra(venda.getCpf(), venda.getDataCompra(), venda.getQuantidade()));
            produtoVendido.setDetalhesCompras(detalhesCompras);
            produtoVendido.setQuantidadeTotal(venda.getQuantidade());


            int totalDisponivel = entradaService.calcularTotalEntradasPorMesEProduto(mes, ano, codigo);
            double limiteInferior = totalDisponivel * 0.25; // 25% do total disponível

            if (produtoVendido.getQuantidadeTotal() > totalDisponivel) {
                produtoVendido.setStatusRelatorio(StatusRelatorio.QTD_DIVERGENTE);
            } else if (produtoVendido.getQuantidadeTotal() >= limiteInferior && produtoVendido.getQuantidadeTotal() < totalDisponivel) {
                produtoVendido.setStatusRelatorio(StatusRelatorio.OK);
            } else if (produtoVendido.getQuantidadeTotal() < limiteInferior) {
                produtoVendido.setStatusRelatorio(StatusRelatorio.BAIXA_DEMANDA);
            }
        }

        List<ProdutoVendido> produtosVendidos = new ArrayList<>(produtosVendidosMap.values());

        RelatorioVendas relatorio = new RelatorioVendas();
        relatorio.setProdutosVendidos(produtosVendidos);

        return relatorio;
    }
}


