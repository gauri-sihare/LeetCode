SELECT Sales.year, Sales.price , Product.product_name
FROM Product
JOIN Sales
ON Product.product_id = Sales.product_id