# Ecommers - Back-end de Simulação de E-commerce

Este projeto simula um back-end simplificado de um e-commerce, oferecendo funcionalidades básicas para gerenciamento de usuários, produtos e compras. Foi desenvolvido utilizando o Quarkus e Java 17 com a distribuição GraalVM, utilizando PostgreSQL como banco de dados. O projeto é facilmente executado via Docker.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

*   **Criação de Usuários:** Permite o cadastro de novos usuários no sistema, com as seguintes validações:
    *   **Validação de CPF:** Garante que o CPF inserido seja válido através de uma validação formal.
    *   **Unicidade de CPF e Email:** Impede a criação de usuários com CPFs ou endereços de e-mail já existentes no sistema.
    *   **Validação de Formato de Email:** Verifica se o formato do endereço de e-mail inserido é válido, garantindo a correta comunicação.
*   **Cadastro de Produtos:** Possibilita o cadastro de novos produtos no sistema, com as seguintes validações:
    *   **Validação de Preço:** Garante que o preço do produto seja um valor positivo (maior que zero), prevenindo erros financeiros.
    *   **Validação de Quantidade:** Garante que a quantidade do produto seja um valor positivo (maior que zero), assegurando a disponibilidade para venda.
*   **Realização de Compras:** Permite a simulação da compra de produtos por usuários, com a seguinte funcionalidade:
    *   **Informações Necessárias:** Requer o CPF do usuário, o nome do produto desejado e a quantidade a ser comprada.

## Tecnologias Utilizadas

*   **Quarkus:** Framework Java Kubernetes Native, projetado para o desenvolvimento de aplicações cloud-native e serverless.
*   **Java 17:** Linguagem de programação utilizada no desenvolvimento do projeto.
*   **GraalVM:** Distribuição JDK de alta performance e polyglot.
*   **PostgreSQL:** Banco de dados relacional utilizado para persistência dos dados.
*   **Docker:** Plataforma de conteinerização utilizada para facilitar a execução e o deploy da aplicação.

## Como Executar o Projeto

1.  **Pré-requisitos:**
    *   Java 17 (com GraalVM ou openJDK) instalado e configurado.
    *   Maven instalado.
    *   Docker e Docker Compose instalados.

2.  **Clone o Repositório:**
    ```bash
    git clone https://github.com/gabriel1003/ecommers.git
    cd ecommers
    ```

3.  **Inicie o Container PostgreSQL:**
    ```bash
    docker-compose up -d
    ```
    Este comando irá construir e iniciar o container do PostgreSQL definido no arquivo `docker-compose.yml`. Certifique-se de que o Docker Compose está instalado e configurado corretamente.

4.  **Execute a Aplicação Quarkus:**
    ```bash
    ./mvnw compile quarkus:dev
    ```
    Isso iniciará a aplicação em modo de desenvolvimento.  A aplicação Quarkus se conectará ao banco de dados PostgreSQL em execução no container Docker.

## Endpoints da API

A seguir, estão os endpoints disponíveis na API:

### Usuários

*   **Criação de Usuário:**
    *   `POST http://localhost:8080/users`
    *   Content-Type: `application/json`
    *   Exemplo de Request Body:
        ```json
        {
          "name": "Gabriel",
          "cpf": "42642980162",
          "email": "gabriel.exemplo3@gmail.com"
        }
        ```
*   **Listar Usuários:**
    *   `GET http://localhost:8080/users`
*   **Listar Usuário por ID:**
    *   `GET http://localhost:8080/users/{id}` (substitua `{id}` pelo ID do usuário)
    *   Exemplo: `GET http://localhost:8080/users/1`
*   **Atualizar Usuário:**
    *   `PUT http://localhost:8080/users/{id}` (substitua `{id}` pelo ID do usuário)
    *   Content-Type: `application/json`
    *   Exemplo de Request Body:
        ```json
        {
          "name": "Daniel",
          "cpf": "11122233344",
          "email": "email@exemplo.com"
        }
    *Observação:* O CPF deve ser inserido sem formatação
        ```
*   **Deletar Usuário:**
    *   `DELETE http://localhost:8080/users/{id}` (substitua `{id}` pelo ID do usuário)
    *   Exemplo: `DELETE http://localhost:8080/users/1`

### Produtos

*   **Criar Produto:**
    *   `POST http://localhost:8080/products`
    *   Content-Type: `application/json`
    *   Exemplo de Request Body:
        ```json
        {
          "name": "abacaxi",
          "price": 0.10,
          "quantity": 5
        }
        ```
*   **Listar Produtos:**
    *   `GET http://localhost:8080/products`
*   **Listar Produto por ID:**
    *   `GET http://localhost:8080/products/{id}` (substitua `{id}` pelo ID do produto)
    *   Exemplo: `GET http://localhost:8080/products/1`
*   **Deletar Produto:**
    *   `DELETE http://localhost:8080/products/{id}` (substitua `{id}` pelo ID do produto)
    *   Exemplo: `DELETE http://localhost:8080/products/1`
*   **Atualizar Produto:**
    *   `PUT http://localhost:8080/products/{id}` (substitua `{id}` pelo ID do produto)
    *   Content-Type: `application/json`
    *   Exemplo de Request Body:
        ```json
        {
          "name": "nome do produto",
          "price": 1.50,
          "quantity": 10
        }
        ```

### Compras

*   **Realizar Compra:**
    *   `POST http://localhost:8080/purchases`
    *   Content-Type: `application/json`
    *   Exemplo de Request Body:
        ```json
        {
          "cpf": "42642980162",
          "products": [
            { "name": "abacaxi", "quantity": 1 }
          ]
        }
    *Observação:* O CPF deve ser inserido sem formatação
        ```

## Contribuição

Contribuições são sempre bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

