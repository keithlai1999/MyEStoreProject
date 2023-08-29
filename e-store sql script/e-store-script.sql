/*
DROP TABLE VisaddressaddresspoitemitEvent;
DROP TABLE POItem;
DROP TABLE PO;
DROP TABLE Address;visiteventpoitemtype
DROP TABLE Item;
*/
/* create Item table*/
CREATE TABLE Item(
bid VARCHAR(20) NOT NULL PRIMARY KEY,
name VARCHAR(60) NOT NULL,
description VARCHAR(60) NOT NULL,
type VARCHAR(60) NOT NULL,
brand VARCHAR(60) NOT NULL,
quantity INT NOT NULL,
price INT NOT NULL
);
/*insert data into item table*/
INSERT INTO ITEM (bid, name, description, type, brand, price, quantity) VALUES ('b001', 'Little Prince', 'a book for all ages', 'book', 'Penguin', 20, 100);
INSERT INTO ITEM (bid, name, description, type, brand, price, quantity) VALUES ('c001', 'iPad', 'a device for personal use', 'computer', 'Apple', 500, 100);
INSERT INTO ITEM (bid, name, description, type, brand, price, quantity) VALUES ('d001', 'laptopm', 'a device for personal use', 'computer', 'Apple', 1500, 100);
/*create an addtess table*/
CREATE TABLE Address (
id INT NOT NULL AUTO_INCREMENT,
street VARCHAR(100) NOT NULL,
province VARCHAR(20) NOT NULL,
country VARCHAR(20) NOT NULL,
zip VARCHAR(20) NOT NULL,
phone VARCHAR(20),
PRIMARY KEY(id)
);
/*populate the address table*/
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (1, '123 Yonge St', 'ON', 'Canada', 'K1E 6T5' ,'647-123-4567');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (2, '445 Avenue rd', 'ON', 'Canada', 'M1C 6K5' ,'416-123-8569');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (3, '789 Keele St.', 'ON', 'Canada', 'K3C 9T5' ,'416-123-9568');
/* create Purchase Order(PO) table */
/* Purchase Order
* lname: last name
* fname:
* id:
first name
purchase order id
* status: status of purchase: Processed, Denied, Ordered */
CREATE TABLE PO (
id INT NOT NULL AUTO_INCREMENT,
lname VARCHAR(20) NOT NULL,
fname VARCHAR(20) NOT NULL,
status VARCHAR(20)NOT NULL,
address INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (address) REFERENCES Address (id)
);
/*
* Inserting data for table 'PO' */
INSERT INTO PO (id, lname, fname, status, address) VALUES (1, 'John', 'White', 'PROCESSED', 1);
INSERT INTO PO (id, lname, fname, status, address) VALUES (2, 'Peter', 'Black', 'DENIED', 2);
INSERT INTO PO (id, lname, fname, status, address) VALUES (3, 'Andy', 'Green', 'ORDERED', 3);
/*create table Purchase Ordert Item, contains items on each order*/
CREATE TABLE POItem (
id INT NOT NULL,
bid VARCHAR(20) NOT NULL,
price INT NOT NULL,
PRIMARY KEY(id,bid),
FOREIGN KEY(id) REFERENCES PO(id),
FOREIGN KEY(bid) REFERENCES Item(bid)
);
/*
*Inserting data for table 'POitem'
*/
INSERT INTO POItem (id, bid, price) VALUES (1, 'b001', 20); INSERT INTO POItem (id, bid, price) VALUES (2, 'c001', 500);

SELECT * FROM POItem;
SELECT * FROM PO;
SELECT * FROM Address;
SELECT * FROM Item;

CREATE TABLE Review (
    id INT NOT NULL AUTO_INCREMENT,
    bid VARCHAR(20) NOT NULL,
    reviewText VARCHAR(255) NOT NULL,
    rating INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(bid) REFERENCES Item(bid)
);

CREATE TABLE User (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role VARCHAR(10) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO Review (bid, reviewText, rating) VALUES ('b001', 'Great book! Highly recommend.', 5);
INSERT INTO Review (bid, reviewText, rating) VALUES ('c001', 'Awesome device, love it.', 4);
INSERT INTO Review (bid, reviewText, rating) VALUES ('b001', 'Not satisfied with the quality.', 2);

INSERT INTO User (username, password, email, role) VALUES ('alice', 'hashed_password', 'alice@example.com', 'USER');
INSERT INTO User (username, password, email, role) VALUES ('bob', 'hashed_password', 'bob@example.com', 'USER');
INSERT INTO User (username, password, email, role) VALUES ('admin', 'hashed_password', 'admin@example.com', 'ADMIN');