create database spring01hibernate
    character set utf8
    collate utf8_general_ci;

INSERT INTO Publisher VALUES (default, 'PWN'),
                             (default, 'Ossolineum'),
                             (default, 'Helion');

show databases;
use spring01hibernate;
show tables;
select * from books;
select * from authors;
select * from publishers;

select * from books_authors;

INSERT INTO authors
VALUES (default, 'Adam', 'Mickiewicz'),
       (default, 'Jan', 'Brzechwa');