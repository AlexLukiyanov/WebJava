DROP TABLE users IF EXISTS;
DROP TABLE products IF EXISTS;
DROP TABLE buyers IF EXISTS;
DROP TABLE buyers_and_products IF EXISTS;

CREATE TABLE IF NOT EXISTS users (id bigserial, score int, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO users (name, score) VALUES ('Bob', 80), ('Jack', 80), ('John', 80);

CREATE TABLE IF NOT EXISTS buyers (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO buyers (name) VALUES ('Bob'), ('Jack');

CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255),  price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Banana', 100), ('Lemon', 50), ('Apelsin', 70);

CREATE TABLE buyers_and_products (id_buyer bigint, id_product bigint, FOREIGN KEY (id_buyer) REFERENCES buyers (id), FOREIGN KEY (id_product) REFERENCES products (id));
INSERT INTO buyers_and_products (id_buyer, id_product) VALUES (1, 1), (1, 2), (2, 3);
