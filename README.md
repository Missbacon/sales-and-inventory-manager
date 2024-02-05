<h1 align="center">  Desafio  final AceleraDevs </h1>

![AceleraDevs](https://github.com/Missbacon/sales-and-inventory-manager/assets/74019772/9a3792b3-c382-4785-b291-afdf9b5bc02f)

<p align="center">
 <a href="#contexto">Contexto</a> •
 <a href="#objetivo">Objetivo</a> • 
 <a href="#requisitos">Requisitos</a> • 
 <a href="#tecnologias">Tecnologias</a> • 

</p>


###  Contexto

O AceleraDevs é um programa voltado para formação de desenvolvedores, alavancando o desenvolvimento profissional dos colaboradores que desejam uma nova carreira dentro da Stefanini. 


### Objetivo

O objetivo deste desafio é construir uma api de controle de estoque e vendas.





###   Requisitos

* Disponibilizar um serviço de restful para um crud de usuarios(clientes) com as seguintes informações:
  - `Nome`
  - `Data de nascimento`
  - `CPF`
  - `CEP`

* Disponibilizar um serviço restful para um crud de produtos com as informações:
  - `Código`
  - `Nome`
  - `Preço`

* Disponibilizar um serviço de restful que receba como parametro o ID de um produto e registre as quantidades para um determinado mês do ano.

* Disponibilizar um endpoint que faça a leitura de uma planilha XLSX com os dados das vendas realizadas e armazene estes dados:

  - Colunas do xlsx:
    - `Codigo do produto`
    - `CPF do usuario`
    - `Quantidade de produtos comprados`
    - `Data da compra(Formato xx/xx/xxxx)`

* Disponibilizar um endpoint para consulta do relatorio de vendas de um determinado mês informado por parâmetro- Padrão Json.

  - O resultado deve conter:
    - `Lista de produtos vendidos`
    - `Quantidade total vendida`
    - `Detalhamento de quais usuarios compraram esse produto em qual data e qual quantidade`

  #### Regras:
    - Caso tenha sido vendida uma quantidade de produtos superior a quantidade disponivel para o mês,
    informar no body do JSON retornando um campo de status: QTD_DIVERGENTE
    - Caso o total de vendas do produto esteja de acordo com a quantidade do mês o status deverá ser : OK 
    - Caso o total de vendas do produto esteja abaixo de 25% do total disponivel para o mes o status deverá ser : BAIXA_DEMANDA.


* Disponibilizar um endpoint para consulta do Relatorio de venda por usuario- Formato json- parâmetro CPF

  - Retornar todos os dados do Usuario
  - Com base no CEP informado no registro, consultar o endereço do usuario atraves da API viaCEP e retornar essas informações
  - Retornar a lista de produtos comprados + quantidade + data 




* Obrigatorio

   - ✔️ Projeto no repositorio com redme bem estruturado
   - ✔️ Coleção do postman 
   - ✔️ Apresentação do projeto 



* Desejavel 

  - Swagger
  - JUnit 

###  Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Java](https://www.java.com/pt-BR/)
- [Springboot](https://spring.io/projects/spring-boot)
- [MySql](https://www.mysql.com/)
- [Maven](https://maven.apache.org/)
- [Poi Apache](https://poi.apache.org/)



