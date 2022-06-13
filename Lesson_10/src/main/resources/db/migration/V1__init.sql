create table if not exists products (id bigserial primary key, title varchar(255), price int);

insert into products (title, price)
values
('Milk', 100),
('Bread', 80),
('Cheese', 90);

create table if not exist cart (id bigserial prmary key, title varchar (255), price int);