CREATE DATABASE minions;
USE minions;

-- minions (id, name, age)
-- towns (town_id, name)

CREATE TABLE minions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(32),
    age INT
);

CREATE TABLE towns (
    town_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(32)
);

-- 2

alter table minions
add column town_id int;

alter table minions
add constraint fk_minions_towns
foreign key minions(town_id)
references towns(town_id);

-- 3

insert into towns (id, name) values 
(1, 'Sofia'), 
(2, 'Plovdiv'), 
(3, 'Varna'); 

insert into minions (id, name, age, town_id) values
(1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', null, 2);

-- 4

truncate table minions;

-- 5

drop table minions;
drop table towns;

-- 6

CREATE TABLE people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(10 , 2 ),
    weight DOUBLE(10 , 2 ),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

insert into people (name, gender, birthdate)
values 
('test', 'm', date(now())),
('test1', 'f', date(now())),
('test2', 'm', date(now())),
('test3', 'f', date(now())),
('test4', 'm', date(now()));


-- 7 

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time DATETIME,
    is_deleted BOOLEAN
);

insert into users (username, password)
values 
('test', 'test'),
('test1', 'test1'),
('test2', 'test2'),
('test3', 'test3'),
('test4', 'test4');


-- 8

alter table users
drop primary key,
add constraint pk_users2
primary key users(id, username);

-- 9

alter table users
change column last_login_time last_login_time datetime default NOW();

-- 10

alter table users
drop primary key, 
add constraint pk_users
primary key users(id),
change column username username varchar(30) unique;

-- 11

create database movies;
use movies;
create table directors(
id int primary key auto_increment,
director_name varchar(50) not null,
notes TEXT
);

insert into directors (director_name) values 
('test'),
('test'),
('test'),
('test'),
('test');

create table genres(
id int primary key auto_increment,
genre_name varchar(20) not null,
notes text
);

insert into genres (genre_name) values 
('test'),
('test'),
('test'),
('test'),
('test');

create table categories(
id int primary key auto_increment,
category_name varchar(20) not null,
notes text
);

insert into categories (category_name) values 
('test'),
('test'),
('test'),
('test'),
('test');

CREATE TABLE movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    director_id INT,
    copyright_year YEAR,
    length DOUBLE(10 , 2 ),
    genre_id INT,
    category_id INT,
    rating DOUBLE(3 , 2 ),
    notes TEXT,
    FOREIGN KEY (director_id)
        REFERENCES directors (id),
    FOREIGN KEY (genre_id)
        REFERENCES genres (id),
    FOREIGN KEY (category_id)
        REFERENCES categories (id)
);

insert into movies (title, director_id,genre_id,category_id)
values
('test', 1, 2, 3),
('test', 1, 2, 5),
('test', 1, 2, 4),
('test', 1, 2, 3),
('test', 1, 2, 3);


-- 13

create database soft_uni;
use soft_uni;

CREATE TABLE towns (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30)
);

CREATE TABLE addresses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    address_text VARCHAR(50),
    town_id INT
);

CREATE TABLE departments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30)
);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    middle_name VARCHAR(30),
    last_name VARCHAR(30),
    job_title VARCHAR(30),
    department_id INT,
    hire_date DATETIME DEFAULT now(),
    salary DOUBLE,
    address_id INT,
    FOREIGN KEY (department_id)
        REFERENCES departments (id),
    FOREIGN KEY (address_id)
        REFERENCES addresses(id)
);

-- 14

SELECT 
    *
FROM
    towns;
SELECT 
    *
FROM
    departments;
SELECT 
    *
FROM
    employees;

-- 15

SELECT 
    *
FROM
    towns AS t
ORDER BY t.name;
SELECT 
    *
FROM
    departments AS d
ORDER BY t.name;
SELECT 
    *
FROM
    employees AS e
ORDER BY e.selary DESC;

-- 16

SELECT 
    t.name
FROM
    towns AS t;
SELECT 
    d.first_name, d.last_name, d.job_title, d.salary
FROM
    departments AS d;
SELECT 
    e.first_name, e.last_name, e.job_title, e.salary
FROM
    employees AS e;

-- 17

UPDATE employees 
SET 
    salary = salary * 1.1;
SELECT 
    salary
FROM
    employees;







