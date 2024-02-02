# My Sample OpenAPI app


## Stage 1

`GET /products`
Create an API endpoint that serves a list of products that can be sold.

A product consists of:
- A unique ID
- A name
- A price

Products may be stored in memory. An external database may be used, but is not required.

| ID  |      Name      | Price  |
|:---:|:--------------:|:------:|
|  1  | Chrome Toaster |  $100  |
|  2  | Copper Kettle  | $49.99 |
|  3  |  Mixing Bowl   |  $20   |


## Stage 2
`POST /products` Create an API endpoint that allows creating a new product.

The response should contain the product details in the same format as Stage 1.

The new product must be persisted so that the endpoint from stage 1 includes the new product in its responses.

## Stage 3
`POST /sales` Create an API endpoint that allows sales to be made. It is not necessary to persist sales.

A sale request consists of:
- An array of line items.
- Each line item includes a product ID and a quantity.

A sale response consists of:
- Everything in the sale request
- A total for each line item.
- A total price of sale.



