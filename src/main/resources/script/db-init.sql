CREATE TABLE IF NOT EXISTS Product (
       id INTEGER,
       name varchar2,
       price numeric(19,2)
);

INSERT INTO Product VALUES
    (1, 'Chrome Toaster', 100),
    (2, 'Copper Kettle', 49.99),
    (3, 'Mixing Bowl', 20);


SELECT
    S.ID,
    S.DISCOUNT,
    ST.PRODUCT_ID,
    ST.QUANTITY
FROM SALE S
JOIN SALE_ITEM ST ON S.ID = ST.SALE_ID;