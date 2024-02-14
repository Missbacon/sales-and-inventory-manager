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

// Iterar sobre as vendas do mês para preencher as informações do relatório
        for (Venda venda : vendasDoMes) {
            int codigo = (int) venda.getCodigoProduto();

            // Obter o nome do produto com base no código
            String nomeProduto = produtoService.obterNomeProdutoPorCodigo(codigo);

            // Inicializar a lista de detalhes de compra apenas para o produto atual
            List<DetalheCompra> detalhesCompras = new ArrayList<>();

            // Atualizar a lista de produtos vendidos
            produtosVendidosMap.putIfAbsent(codigo, new ProdutoVendido(codigo));
            ProdutoVendido produtoVendido = produtosVendidosMap.get(codigo);
            produtoVendido.setNome(nomeProduto); // Definir o nome do produto

            // Adicionar detalhes da compra apenas para o produto atual
            detalhesCompras.add(new DetalheCompra(venda.getCpf(), venda.getDataCompra(), venda.getQuantidade()));
            produtoVendido.setDetalhesCompras(detalhesCompras);

            // Definir a quantidade total apenas para o produto atual
            produtoVendido.setQuantidadeTotal(venda.getQuantidade());


            int totalDisponivel = entradaService.calcularTotalEntradasPorMesEProduto(mes, ano, codigo);
            double limiteInferior = totalDisponivel * 0.25; // 25% do total disponível

            if (produtoVendido.getQuantidadeTotal() > totalDisponivel) {
                produtoVendido.setStatusRelatorio(StatusRelatorio.QTD_DIVERGENTE);
            } else if (produtoVendido.getQuantidadeTotal() == totalDisponivel) {
                produtoVendido.setStatusRelatorio(StatusRelatorio.OK);
            } else if (produtoVendido.getQuantidadeTotal() >= limiteInferior && produtoVendido.getQuantidadeTotal() < totalDisponivel) {
                produtoVendido.setStatusRelatorio(StatusRelatorio.OK);
            } else if (produtoVendido.getQuantidadeTotal() < limiteInferior) {
                produtoVendido.setStatusRelatorio(StatusRelatorio.BAIXA_DEMANDA);
            }
        }

// Converter o mapa de produtos vendidos em uma lista
        List<ProdutoVendido> produtosVendidos = new ArrayList<>(produtosVendidosMap.values());

// Criar o objeto RelatorioVendas com as informações coletadas
        RelatorioVendas relatorio = new RelatorioVendas();
        relatorio.setProdutosVendidos(produtosVendidos);

        return relatorio;


        }


}


