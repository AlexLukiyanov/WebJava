DROP TABLE clients_and_products IF EXISTS;
DROP TABLE products IF EXISTS;
DROP TABLE clients IF EXISTS;

CREATE TABLE IF NOT EXISTS clients (id bigserial, name VARCHAR(255), score int, PRIMARY KEY (id));
INSERT INTO clients (name, score) VALUES ('Bob', 10), ('Jack', 80);

CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255),  price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Banana', 100), ('Lemon', 50), ('Apelsin', 70);

CREATE TABLE clients_and_products (id_client bigserial, id_product bigint, FOREIGN KEY (id_client) REFERENCES clients (id), FOREIGN KEY (id_product) REFERENCES products (id));
INSERT INTO clients_and_products (id_client, id_product) VALUES (1, 1), (1, 2), (2, 3);