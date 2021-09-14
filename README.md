# Teste de seleção para vaga de Java

## Faça um fork desse projeto e siga as instruções a seguir utilizando esse projeto.

# Pré-requisitos

Implementar apenas a API (Backend)
Versão Java +8 (caso seja Java 8, verificar compatibilidade da sua IDE)
Versão Spring Boot >= 2.4
Banco de dados fica a seu critério (Sql, NoSql)
Seu projeto deve obrigatoriamente ter as anotações: @Repository, @Entity e @Controller
Documentação mínima da API (Swagger ou documento PDF)

# Objetivo
Implementar para empresa de transporte de cargas SigaBem o endpoint para o cálculo do preço do frete:

Você deve calcular o valor total do frete e a data prevista da entrega.

Considerar regras para calcular o valor do frete:
 * CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia
 * CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias
 * CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias
 * O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00

Seu input de entrada deve ser “peso”, “cepOrigem”, “cepDestino” e “nomeDestinatario“

Você utilizará a API gratuita de consulta de CEP abaixo: 
Documentação da API: https://viacep.com.br/
Exemplo do GET: https://viacep.com.br/ws/<CEP_A_CONSULTAR>/json/

Endpoint pode ser público
Response/Output deve possuir: “vlTotalFrete” e “dataPrevistaEntrega”, “cepOrigem” e “cepDestino”
Deve ser persistido no banco os valores da cotação os valores consultados: “peso”, “cepOrigem”, “cepDestino”, “nomeDestinatario”, “vlTotalFrete”, “dataPrevistaEntrega” e “dataConsulta”



# Critérios de avaliação:
 * Implementação das regras de negócios para o cálculo do frete
 * Boas práticas de programação, arquitetura  e padrões de projetos

# Entrega: 
 * Disponibilizar um link do repositório no GitHub e encaminhar para developer@cd2.com.br


# Link do Swagger (Documentação)
<a href="https://app.swaggerhub.com/apis-docs/AL33H/SigaBemJavaTest/1.0.0">Clique Aqui.</a>

# Tecnologias 
- Project: Maven
- Language: Java 11
- Springboot: Versão 2.5.4
- Banco de dados: H2-test, PostgreSQL-dev/prod


# Iniciar Aplicação

1. Selecione o diretório abra o CMD, e insira;

```xsdregexp
git clone https://github.com/AL33H/JavaTest.git
```
2. Após Clonar o diretório, insira;

```xsdregexp
mvn spring-boot:run 
```

3. Após a inicialização acesse, <a href="http://localhost:8080/consulta">Clique aqui</a>.




# Configuração banco de dados

Atualizar valor em ```application-dev.properties``` com os valores de acordo com a configuração do banco de dados postgreSQL.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/${DATABASE_NAME}
spring.datasource.username=${USER_NAME_DB}
spring.datasource.password=${PASSWORD}
```

Em ```application.properties``` atualizar valor de, ```spring.profiles.active=test``` para ```spring.profiles.active=dev```


