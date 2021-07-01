CREATE SCHEMA IF NOT EXISTS homework;
DROP TABLE IF EXISTS homework.products;
CREATE TABLE IF NOT EXISTS homework.products (id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
title VARCHAR(255),
cost FLOAT NOT NULL);
INSERT INTO homework.products (title, cost) VALUES
('Product_1',125.23),
('Product_2',256.32),
('Product_3',1258.23),
('Product_4',125.36),
('Product_5',256.52);
COMMIT;