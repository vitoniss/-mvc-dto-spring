# Atividade: Arquitetura MVC, DTOs e Requisições POST no Spring

API Spring Boot que demonstra o uso do padrão DTO para evitar Mass Assignment (Overposting)
no cadastro de usuários.

## Como executar

Requisitos: Java 17+ e Maven.

```bash
mvn spring-boot:run
```

A API sobe em `http://localhost:8080`.

## Testando o POST

```bash
curl -X POST http://localhost:8080/usuarios \
  -H "Content-Type: application/json" \
  -d '{"nome":"Maria da Silva","email":"maria.silva@email.com","senha":"senhaSegura123"}'
```

Mesmo que o cliente envie `"isAdmin": true`, o campo é ignorado, pois não existe no
`UsuarioCadastroDTO`. O usuário é salvo com `isAdmin = false`.

Console do banco H2: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:atividadedb`, user `sa`, senha vazia).

## Estrutura

- `model/Usuario` – entidade JPA
- `dto/UsuarioCadastroDTO` – dados que o cliente pode enviar (nome, email, senha)
- `repository/UsuarioRepository` – acesso a dados (Spring Data JPA)
- `controller/UsuarioController` – recebe o POST, converte DTO -> entidade e salva
