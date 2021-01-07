CREATE TABLE IF NOT EXISTS categories(id BIGINT PRIMARY KEY AUTO_INCREMENT, name varchar(255));
CREATE TABLE IF NOT EXISTS donations (id BIGINT PRIMARY KEY AUTO_INCREMENT, quantity INTEGER, categories varchar(255), institution VARCHAR(255),
                                      street VARCHAR(255), city VARCHAR(255), zipCode VARCHAR(255), pickUpDate VARCHAR(255), pickUpTime VARCHAR(255), pickUpComment VARCHAR(255));
CREATE TABLE IF NOT EXISTS institutions(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), description VARCHAR(255));