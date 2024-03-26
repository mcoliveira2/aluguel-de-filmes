# CRUD de aluguel de filmes

CRUD simples de alguel de filmes para aplicar conceitos de clean architeture, clean code, arquitetura hexagonal, SOLID, TDD, teste unitários e testes de integração

### Requisitos

- Possuir docker instalado na máquina

### Rodando o projeto local

- Na pasta raiz do projeto, rodar o comando ```docker-compose up -d --build```
- O comando irá criar um container com a imagem do banco MongoDB e um container com a imagem da aplicação
- Quando concluído. Acessar a url http://localhost:8080/api/swagger-ui/index.html#

### Endpoints
- Os endpoints podem ser testados na própria aplicação do swagger acessando a URL http://localhost:8080/api/swagger-ui/index.html#
- Na pasta raiz do projeto, existe também a coleção do postman que pode ser importada https://github.com/mcoliveira2/aluguel-de-filmes/blob/develop/Aluguel%20de%20Filmes.postman_collection.json

### Banco de Dados
- MongoDB

### Utilitários
- Lombok
- Spring Doc
