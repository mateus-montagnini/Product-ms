# Products-ms

## Endpoints
- BaseURL: /products
- POST: create()
- GET:  getAll()
- GET  /{id}:  getById()
- PUT /{id}: update()
- DELETE /{id}: delete()

## Model
````json
{
	"id": 1,
	"name": "Produto",
	"description": "Descricao",
	"price": 1000.00,
	"isAvailable": true
}
````

## Business Rules
- So e possível a criacao de produtos com preco positivo;
- Nao e possível pesquisar produtos que não estao disponiveis;
- Nao e possível inserir deescricoes com menos de 50 caracteres;