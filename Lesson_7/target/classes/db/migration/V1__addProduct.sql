create table if not exists products (id bigserial primary key, title varchar(255), price int);

insert into products (title, price)
values
    ('Apple', 10),
    ('Kiwi', 20),
    ('Banana', 30),
    ('Cabbage', 40),
    ('Onion', 50),
    ('Carrot', 60),
    ('Watermelon', 70),
    ('Orange', 80),
    ('Lemon', 90),
    ('Pepper', 100),
    ('Beet', 110),
    ('Tomato', 120),
    ('Cucumber', 130),
    ('Melon', 140),
    ('Grape', 150),
    ('Cherry', 160),
    ('Tea', 170),
    ('Coffee', 180),
    ('Olives', 190),
    ('Chips', 200);