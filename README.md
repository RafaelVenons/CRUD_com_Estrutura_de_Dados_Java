# CRUD com Estrutura de Dados Java
Este projeto tem como intuito praticar os conceitos do CRUD

## Modelo utilizado
Foi feito a Classe `Data<E>` que usa como chave uma String (podendo usar um nome qualquer ou uma Hash) e para chave tem um valor associado da Classe E, para testes da Classe `Data<E>` foi usado a Classe Double como o valor retornado

## Testes Unitários
Para garantir o bom funcionamento do Modelo criado, foi feito testes unitários para garantir o bom funcionamento dos métodos e garantir que qualquer alteração não prejudique implementações anteriores

## Persistência de dados
Foi feita a persistência de dados através de arquivos CSV, podendo verificar a existência de arquivos, Listar os arquivos existentes, Ler um arquivo e Salvar.

## MVC
### Model
Foi usado a classe `Data<Double>` para salvar as informações em memória, usando a Chave como o nome do produto e o valor retornado a respectiva quantidade

### View
Foi criado a classe `InputOutput` com métodos estáticos que concentra todas as entradas e saídas de dados do programa

### Controller
A principal Classe usada e que possui a funcionalidade de Controller é a classe `InterfaceMenu` que integra o Modelo, a persistência de dados e a entrada e saída de dados.