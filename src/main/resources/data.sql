INSERT INTO categories(name) VALUE ('zabawki');
INSERT INTO categories(name) VALUE ('ubrania');
INSERT INTO donations(quantity, categories, institution, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment)
VALUES (5,'zabawki','Pomagamy','Cukierkowa', 'Poznan','61-039','20-10-2019','14:30','Samochody i lalki');
INSERT INTO donations(quantity, categories, institution, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment)
VALUES (10,'ubrania','Pomagamy','Plecakowa', 'Poznan','60-079','15-10-2019','16:30','T-shirt-y i spodnie');
INSERT INTO institutions(name, description) VALUES ('Pomagamy','Zbiórki zabawek i ubrań');
INSERT INTO institutions(name, description) VALUES ('Zywimy','Zbiórki jedzenia dla głodujących');
