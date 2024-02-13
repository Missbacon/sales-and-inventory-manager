package br.com.wanessacamara.estoque.service;

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

    public RelatorioVendas gerarRelatorioVendasPorMes(int ano, int mes) {
        // Cria uma instância do Calendar e define o mês e ano fornecidos
        Calendar cal = Calendar.getInstance();
        cal.set(ano, mes - 1, 1); // Lembre-se que o mês de Janeiro é 0, então subtraímos 1 do mês fornecido
        Date inicioMes = cal.getTime();

        // Define o último dia do mês fornecido
        cal.set(ano, mes - 1, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date fimMes = cal.getTime();

        // Realiza a busca no repositório utilizando o intervalo de datas correspondente ao mês fornecido
        List<Venda> vendasDoMes = vendaRepository.findByMes(ano,mes);


        // Inicializar estruturas de dados para armazenar as informações do relatório
        Map<Integer, ProdutoVendido> produtosVendidosMap = new HashMap<>();
        int quantidadeTotalVendida = 0;
        List<DetalheCompra> detalhesCompras = new ArrayList<>();

        // Iterar sobre as vendas do mês para preencher as informações do relatório
        for (Venda venda : vendasDoMes) {
            Long codigoProduto = (long) venda.getCodigoProduto();

            // Obter o nome do produto com base no código
            String nomeProduto = produtoService.obterNomeProdutoPorCodigo(codigoProduto);

            // Atualizar a quantidade total vendida
            quantidadeTotalVendida += venda.getQuantidade();

            // Atualizar a lista de produtos vendidos
            produtosVendidosMap.putIfAbsent(Math.toIntExact(codigoProduto), new ProdutoVendido(Math.toIntExact(codigoProduto)));
            ProdutoVendido produtoVendido = produtosVendidosMap.get(codigoProduto);
            if (produtoVendido == null) {
                produtoVendido = new ProdutoVendido(Math.toIntExact(codigoProduto));
                produtosVendidosMap.put(Math.toIntExact(codigoProduto), produtoVendido);
            }
            produtoVendido.setNome(nomeProduto); // Definir o nome do produto

            produtoVendido.setQuantidade(venda.getQuantidade());

            // Adicionar detalhes da compra
            detalhesCompras.add(new DetalheCompra(venda.getCpf(), venda.getDataCompra(), venda.getQuantidade()));
        }

        // Converter o mapa de produtos vendidos em uma lista
        List<ProdutoVendido> produtosVendidos = new ArrayList<>(produtosVendidosMap.values());

        // Criar o objeto RelatorioVendas com as informações coletadas
        RelatorioVendas relatorio = new RelatorioVendas();
        relatorio.setProdutosVendidos(produtosVendidos);
        relatorio.setQuantidadeTotalVendida(quantidadeTotalVendida);
        relatorio.setDetalhesCompras(detalhesCompras);

        return relatorio;
    }
}


