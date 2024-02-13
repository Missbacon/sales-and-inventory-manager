package br.com.wanessacamara.estoque.service;

import br.com.wanessacamara.estoque.dto.EnderecoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {


        private final RestTemplate restTemplate;

        public ViaCepService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public EnderecoDto buscarEndereco(String cep) {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            return restTemplate.getForObject(url, EnderecoDto.class);
        }
    }

