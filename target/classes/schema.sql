--DROP TABLE IF EXISTS price;
DROP TABLE IF EXISTS brand;
CREATE TABLE brand (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100));


DROP TABLE IF EXISTS product;
CREATE TABLE  product(
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               name VARCHAR(100));
DROP TABLE IF EXISTS price;
CREATE TABLE price (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                               brand_id INT,
                               product_id INT,
                               start_date DATETIME,
                               end_date DATETIME,
                               priority INT,
                               price DECIMAL(10, 2),
                               currency VARCHAR(3),
                               PRIMARY KEY (id),
                               FOREIGN KEY (brand_id) REFERENCES brand(id),
                               FOREIGN KEY (id) REFERENCES price(id),
                               FOREIGN KEY (product_id) REFERENCES product(id)
);


INSERT INTO brand (id, name) VALUES (1, 'ZARA');

INSERT INTO product (id, name) VALUES (35455, 'Jeans');


INSERT INTO price (id, brand_id, product_id, start_date, end_date, priority, price, currency)
VALUES
    (1, 1, 35455, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 0, 35.50, 'EUR'),
    (2, 1, 35455, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 1, 25.45, 'EUR'),
    (3, 1, 35455, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 1, 30.50, 'EUR'),
    (4, 1, 35455, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 1, 38.95, 'EUR');
