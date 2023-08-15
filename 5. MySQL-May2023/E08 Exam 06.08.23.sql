-- Section 1: Data Definition Language (DDL)

CREATE DATABASE real_estate_db;
USE real_estate_db;

-- 1. Table Design

CREATE TABLE cities (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE property_types(
id INT PRIMARY KEY AUTO_INCREMENT,
type VARCHAR(40) NOT NULL UNIQUE,
`description` TEXT
);

CREATE TABLE properties(
id INT PRIMARY KEY AUTO_INCREMENT,
address VARCHAR(80) NOT NULL UNIQUE,
price DECIMAL(19,2) NOT NULL,
area DECIMAL(19,2),
property_type_id INT,
city_id INT,
CONSTRAINT fk_property_type_id FOREIGN KEY (property_type_id) REFERENCES property_types(id),
CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES cities(id) 
);

CREATE TABLE agents(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
phone VARCHAR(20) NOT NULL UNIQUE,
email VARCHAR(50) NOT NULL UNIQUE,
city_id INT,
CONSTRAINT fk_agents_city_id FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE buyers(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
phone VARCHAR(20) NOT NULL UNIQUE,
email VARCHAR(50) NOT NULL UNIQUE,
city_id INT,
CONSTRAINT fk_buyers_city_id FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE property_offers(
property_id INT NOT NULL,
agent_id INT NOT NULL,
price DECIMAL(19,2) NOT NULL,
offer_datetime DATETIME,
CONSTRAINT fk_offers_id_property FOREIGN KEY (property_id) REFERENCES properties(id),
CONSTRAINT fk_agents_id_property FOREIGN KEY (agent_id) REFERENCES agents(id)
);





































