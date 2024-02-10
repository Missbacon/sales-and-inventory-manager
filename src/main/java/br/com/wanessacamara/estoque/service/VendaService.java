package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.model.Venda;
import br.com.wanessacamara.estoque.repository.ClienteRepository;
import br.com.wanessacamara.estoque.repository.VendaRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class VendaService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private VendaRepository vendaRepository;

    public void processarUploadVendas(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            List<Venda> vendas = new ArrayList<>();
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (currentRow.getRowNum() == 0) {
                    continue; // Pula a linha do cabeçalho
                }

                Venda venda = new Venda();
                venda.setCodigoProduto((int) currentRow.getCell(0).getNumericCellValue());
                venda.setCpfUsuario(currentRow.getCell(1).getStringCellValue());
                venda.setQuantidade((int) currentRow.getCell(2).getNumericCellValue());
                venda.setDataCompra(currentRow.getCell(3).getDateCellValue());

                vendas.add(venda);
            }

            vendaRepository.saveAll(vendas);

            workbook.close();
        }
    }
}
