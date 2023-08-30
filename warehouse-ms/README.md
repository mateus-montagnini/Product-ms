# Warehouse-ms
## Endpoints
- BaseURL: /warehouses
- POST: create()
- GET:  getAll()
- GET  /{id}:  getById() *
- PUT /{id}: update() *

## Model
````json
{
	"id": 1,
	"product-id": 1,
	"quantity": 10,
}
````

## Business Rules
- O estoque e responsavel por avisar se o produto esta ou não disponivel, ou seja, caso o valor da quantidade seja igual a zero, deve informar outro servico;
- Nao e permitido mais de uma linha do mesmo produto salvo na base de dados;