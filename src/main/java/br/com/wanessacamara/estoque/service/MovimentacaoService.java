package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;





}
