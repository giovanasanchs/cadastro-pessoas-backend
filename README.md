# 📌 API Backend - Cadastro de Pessoas

Este backend foi desenvolvido em **Java com Spring Boot** para atender ao desafio técnico de criação de um sistema completo de **cadastro de pessoas**. Ele oferece endpoints RESTful para criar, ler, atualizar e excluir registros, com integração à API ViaCEP para preenchimento automático de endereço.

> 🛠️ **Arquitetura em camadas (Controller, Service, Repository), validações robustas e integração com banco de dados MySQL.**

---

## 📦 Repositório

👉 [cadastro-de-pessoas-backend](https://github.com/giovanasanchs/cadastro-pessoas-backend)

---

## 🚀 Funcionalidades Implementadas

- ✅ Criação de pessoa (Pessoa Física ou Jurídica)
- ✅ Leitura de todos os cadastros e por ID
- ✅ Atualização de cadastro
- ✅ Remoção de cadastro por ID
- ✅ Validação de campos obrigatórios (nome, e-mail, CPF/CNPJ, CEP, etc.)
- ✅ Integração com API [ViaCEP](https://viacep.com.br) para buscar endereço a partir do CEP
- ✅ Tratamento de exceções personalizadas (ex: CPF inválido, CEP não encontrado)
- ✅ Persistência dos dados em banco de dados MySQL

---

## 🔐 Estrutura dos Endpoints

| Método | Endpoint              | Descrição                                |
|--------|-----------------------|------------------------------------------|
| GET    | `/api/pessoas`        | Lista todas as pessoas cadastradas       |
| GET    | `/api/pessoas/{id}`   | Retorna os dados de uma pessoa específica|
| POST   | `/api/pessoas`        | Cria uma nova pessoa                     |
| PUT    | `/api/pessoas/{id}`   | Atualiza os dados de uma pessoa          |
| DELETE | `/api/pessoas/{id}`   | Remove uma pessoa do sistema             |

---

## 🧰 Tecnologias Utilizadas

- [Java 17](https://www.oracle.com/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL](https://www.mysql.com/)
- [API ViaCEP](https://viacep.com.br)
- [Maven](https://maven.apache.org/)

---

## 🗂️ Organização do Projeto

```bash
📁 src
├── 📁 controller      → Define os endpoints da API
├── 📁 dto             → Objetos de transferência de dados (DTOs)
├── 📁 model           → Entidades JPA (Pessoa, Endereço)
├── 📁 repository      → Interfaces que acessam o banco de dados
├── 📁 service         → Lógica de negócio e regras de validação
├── 📁 config          → Configurações gerais da aplicação
└── 📄 application.properties → Configuração de acesso ao banco de dados
```
---

## 🧪 Como Executar o Backend Localmente

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/cadastro-de-pessoas-backend.git

# Acesse o diretório do projeto
cd cadastro-de-pessoas-backend

# Configure o acesso ao MySQL no arquivo application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Execute a aplicação
./mvnw spring-boot:run

A API estará disponível em http://localhost:8080/api/pessoas.
```
