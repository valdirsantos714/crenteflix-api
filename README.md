# CrenteFlix API

CrenteFlix é uma API que permite a autenticação de usuários e oferece funcionalidades para cadastrar, atualizar, deletar e buscar filmes e séries.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Spring Security
- Lombok
- Validation

## Funcionalidades

- **Autenticação de Usuários**
  - Login e registro de novos usuários com Spring Security.
  
- **Gestão de Conteúdos**
  - Cadastrar, atualizar, deletar e buscar filmes e séries.
  - Pesquisar filmes e séries por categorias ou pelo nome.
  - Pesquisar todos os conteúdos pelo nome.

## Endpoints Disponíveis

### Autenticação

- `POST /api/auth/login` - Realiza login do usuário.
- `POST /api/auth/register` - Registra um novo usuário.
- `GET /api/auth/all` - Retorna uma lista dos usuários cadastrados (requer autenticação).

### Conteúdos

- **Buscar Todos os Conteúdos:**
  - `GET /api/conteudos/all` - Retorna todos os conteúdos.
  
- **Buscar Conteúdo por ID:**
  - `GET /api/conteudos/{id}` - Retorna um conteúdo específico por ID.

- **Buscar Conteúdo pelo Nome:**
  - `GET /api/conteudo/find/{nomeConteudo}` - Busca conteúdos pelo nome.

- **Buscar Todos os Filmes:**
  - `GET /api/conteudos/filmes` - Retorna todos os filmes.
  
- **Buscar Filmes pelo Nome:**
  - `GET /api/conteudo/filmes/{nomeFilme}` - Busca filmes pelo nome.

**Buscar Todas as Séries:**
  - `GET /api/conteudos/series` - Retorna todas as séries.
  
- **Buscar Séries pelo Nome:**
  - `GET /api/conteudo/series/{nomeSerie}` - Busca séries pelo nome.
  
- **Cadastrar Novo Conteúdo:**
  - `POST /api/conteudos` - Cadastra um novo conteúdo (requer autenticação).

- **Atualizar Conteúdo:**
  - `PUT /api/conteudos/{id}` - Atualiza um conteúdo existente (requer autenticação).

- **Deletar Conteúdo:**
  - `DELETE /api/conteudos/{id}` - Deleta um conteúdo existente (requer autenticação).

## Configuração e Execução

### Pré-requisitos

- JDK 17 ou superior
- Maven
- PostgreSQL

### Passo a Passo

1. Clone o repositório:

```bash
git clone https://github.com/valdirsantos714/crenteflix-api
cd crenteflix-api
```

2. Configure o arquivo `application.properties` com as informações do seu banco de dados PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/crenteflix
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

3. Compile e execute a aplicação:

```bash
./mvnw spring-boot:run
```

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests para melhorias.
