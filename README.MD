# Desafio Anota.ai - Catálogo de Produtos

Este projeto é uma API REST desenvolvida como parte de um desafio prático de estudos, com o objetivo de construir um sistema de catálogo de produtos com persistência em banco de dados NoSQL.

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Spring Data MongoDB**
* **MongoDB** (Banco de dados NoSQL)
* **Lombok** (Para reduzir o código repetitivo)
* **Maven** (Gerenciador de dependências)

## 🏗️ Estrutura do Projeto

O projeto segue as boas práticas de arquitetura, separando as responsabilidades em camadas:

* **Domain**: Entidades que representam as regras de negócio (`Product`, `Category`).
* **Repositories**: Interfaces de acesso aos dados que estendem `MongoRepository`.
* **Config**: Configurações de infraestrutura (ex: conexão com o banco de dados).

## 💡 O que este projeto resolve?

O desafio foca na criação de um CRUD completo para um catálogo de produtos, permitindo:
1.  **Gerenciamento de Categorias**: Criação e listagem de categorias.
2.  **Gerenciamento de Produtos**: Criação, listagem, atualização e deleção de produtos vinculados a categorias.
3.  **Persistência NoSQL**: Utilização do MongoDB para armazenar os documentos, explorando a flexibilidade do formato BSON.

## 🛠️ Como rodar o projeto

1.  **Pré-requisitos**:
    * Ter o [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-downloads.html) instalado.
    * Ter o [MongoDB](https://www.mongodb.com/try/download/community) rodando localmente (ou via Docker).
2.  **Clone o repositório**:
    ```bash
    git clone https://github.com/SEU-USUARIO/nome-do-repositorio.git
    ```
3.  **Configure o banco**:
    * Certifique-se de que o MongoDB está rodando na porta padrão `27017`.
4.  **Execute a aplicação**:
    ```bash
    ./mvnw spring-boot:run
    ```

## 📚 Aprendizados

Durante este projeto, pude aprofundar os meus conhecimentos em:
* Configuração manual de `MongoTemplate` e `MongoDatabaseFactory`.
* Uso de `@Configuration` e `@Bean` para gerenciar a injeção de dependência no Spring.
* Trabalhar com `Spring Data MongoDB` para abstrair operações de banco de dados.
* Tratamento de erros comuns em mapeamento de documentos (`@Document`).
