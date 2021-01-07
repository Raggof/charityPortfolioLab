USE `charity-donation`;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS institutions;
DROP TABLE IF EXISTS donations;

CREATE TABLE IF NOT EXISTS categories(id Long AUTO_INCREMENT, name varchar(255));
INSERT INTO categories(name) VALUE ('zabawki');
INSERT INTO categories(name) VALUE ('ubrania');

CREATE TABLE IF NOT EXISTS donations (id Long AUTO_INCREMENT, quantity INTEGER, categories varchar(255), institution VARCHAR(255),
                        street VARCHAR(255), city VARCHAR(255), zipCode VARCHAR(255), pickUpDate VARCHAR(255), pickUpTime VARCHAR(255), pickUpComment VARCHAR(255));
INSERT INTO donations(quantity, categories, institution, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment)
VALUES (5,'zabawki','Pomagamy','Cukierkowa', 'Poznan','61-039','20-10-2019','14:30','Samochody i lalki');
INSERT INTO donations(quantity, categories, institution, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment)
VALUES (10,'ubrania','Pomagamy','Plecakowa', 'Poznan','60-079','15-10-2019','16:30','T-shirt-y i spodnie');

CREATE TABLE IF NOT EXISTS institutions(id Long AUTO_INCREMENT, name VARCHAR(255), description VARCHAR(255));
INSERT INTO institutions(name, description) VALUES ('Pomagamy','Zbiórki zabawek i ubrań');
INSERT INTO institutions(name, description) VALUES ('Zywimy','Zbiórki jedzenia dla głodujących');
