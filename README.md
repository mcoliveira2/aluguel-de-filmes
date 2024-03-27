# CRUD de aluguel de filmes

CRUD simples de alguel de filmes para aplicar conceitos de clean architeture, clean code, arquitetura hexagonal, SOLID, TDD, teste unitários e testes de integração

## Acesso a API no heroku

- https://stormy-shore-70595-add1faba3d36.herokuapp.com/api/swagger-ui/index.html#/

## Rodando o projeto local

- Possuir docker instalado na máquina
- Na pasta raiz do projeto, rodar o comando ```docker-compose up -d --build```
- O comando irá criar um container com a imagem do banco MongoDB e um container com a imagem da aplicação
- Quando concluído. Acessar a url http://localhost:8080/api/swagger-ui/index.html#

## Endpoints
- Na pasta .postman, existe coleção do endpoints para ser importada ao app Postman. https://github.com/mcoliveira2/aluguel-de-filmes/blob/develop/.postman/Aluguel%20de%20Filmes.postman_collection.json

## Banco de Dados
- MongoDB

## Utilitários
- Lombok
- Spring Doc
