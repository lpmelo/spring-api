# Spring API

Esta é uma API Spring que oferece operações CRUD (Create, Read, Update, Delete) para gerenciar informações de clientes. Com esta API, você pode realizar as seguintes operações:

## Obter todos os clientes

- **Endpoint**: `/api/client`
- **Método HTTP**: GET
- **Descrição**: Esta operação permite recuperar uma lista de todos os clientes armazenados no sistema.

## Obter cliente por ID

- **Endpoint**: `/api/client/{id}`
- **Método HTTP**: GET
- **Descrição**: Use este endpoint para buscar informações detalhadas de um cliente específico, fornecendo o ID do cliente como parâmetro na URL.

## Criar novo cliente

- **Endpoint**: `/api/client`
- **Método HTTP**: POST
- **Descrição**: Com esta operação, é possível criar um novo cliente no sistema. Você deve fornecer os dados do cliente no corpo da requisição em formato JSON.

## Editar cliente

- **Endpoint**: `/api/client/edit/{id}`
- **Método HTTP**: PUT
- **Descrição**: Use esta operação para atualizar as informações de um cliente existente. Forneça o ID do cliente a ser atualizado na URL e os novos dados do cliente no corpo da requisição em formato JSON.

## Excluir cliente

- **Endpoint**: `/api/client/remove/{id}`
- **Método HTTP**: DELETE
- **Descrição**: Esta operação permite remover um cliente do sistema com base no ID fornecido na URL.

## Tecnologias Utilizadas

- **Spring Data JPA**: Utilizei o Spring Data JPA para simplificar o acesso a dados e a persistência no banco de dados.
- **Banco de Dados H2**: Utilizei o banco de dados H2 para armazenar os dados dos clientes. É um banco de dados em memória, útil para desenvolvimento e testes.
- **Lombok**: Utilizei o Lombok para geração automática de getters e setters, reduzindo a verbosidade do código.
