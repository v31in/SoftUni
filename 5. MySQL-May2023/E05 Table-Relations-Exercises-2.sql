USE geography;

-- 1. One-To-One Relationship

CREATE TABLE people (
    person_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(60) NOT NULL,
    salary DECIMAL(10 , 2 ) NOT NULL,
    passport_id INT UNIQUE,
    CONSTRAINT fk_people_passports FOREIGN KEY (passport_id)
        REFERENCES passports (passport_id)
);

CREATE TABLE passports (
    passport_id INT PRIMARY KEY AUTO_INCREMENT,
    passport_number VARCHAR(7) UNIQUE
);

-- 2. One-To-Many Relationship

CREATE TABLE manufacturers (
    manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL UNIQUE,
    established_on DATE
);

CREATE TABLE models (
    model_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    manufacturer_id INT,
    CONSTRAINT fk_model_manufacturers FOREIGN KEY (manufacturer_id)
        REFERENCES manufacturers (manufacturer_id)
);

-- 3. Many-To-Many Relationship

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
);

CREATE TABLE exams (
    exam_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
);

CREATE TABLE students_exams (
    student_id INT NOT NULL,
    exam_id INT NOT NULL,
    CONSTRAINT pk PRIMARY KEY (student_id , exam_id),
    CONSTRAINT fk_this_student FOREIGN KEY (student_id)
        REFERENCES students (student_id),
    CONSTRAINT fk_this_exams FOREIGN KEY (exam_id)
        REFERENCES exams (exam_id)
);

-- 4. Self-Referencing

CREATE TABLE teachers (
    teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL,
    manager_id INT
);
   
ALTER TABLE teachers
ADD CONSTRAINT fk
FOREIGN KEY (manager_id)
REFERENCES teachers (teacher_id);

-- 5. Online Store Database

CREATE TABLE cities (
    city_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);
 
CREATE TABLE item_types (
    item_type_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);
 
CREATE TABLE customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    birthday DATE,
    city_id INT NULL,
    CONSTRAINT fk_customer_city FOREIGN KEY (`city_id`)
        REFERENCES `cities` (`city_id`)
);
 
CREATE TABLE `orders` (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    CONSTRAINT fk_order_customer FOREIGN KEY (`customer_id`)
        REFERENCES `customers` (`customer_id`)
);
 
CREATE TABLE items (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    item_type_id INT NOT NULL,
    CONSTRAINT fk_items_type FOREIGN KEY (`item_type_id`)
        REFERENCES `item_types` (`item_type_id`)
);
 
CREATE TABLE order_items (
    order_id INT NOT NULL,
    item_id INT NOT NULL,
    CONSTRAINT pk PRIMARY KEY (`order_id` , `item_id`),
    CONSTRAINT fk_order FOREIGN KEY (`order_id`)
        REFERENCES `orders` (`order_id`),
    CONSTRAINT fk_item FOREIGN KEY (`item_id`)
        REFERENCES `items` (`item_id`)
);

-- 6. University Database

CREATE TABLE subjects (
    subject_id INT PRIMARY KEY AUTO_INCREMENT,
    subject_name VARCHAR(50) NOT NULL
);
 
CREATE TABLE majors (
    major_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);
 
CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_number VARCHAR(12) UNIQUE NOT NULL,
    student_name VARCHAR(50) NOT NULL,
    major_id INT NULL,
    CONSTRAINT fk_student_major FOREIGN KEY (`major_id`)
        REFERENCES `majors` (`major_id`)
);
 
CREATE TABLE payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    payment_date DATE NOT NULL,
    payment_amount DECIMAL(8 , 2 ),
    student_id INT NULL,
    CONSTRAINT fk_payment_student FOREIGN KEY (`student_id`)
        REFERENCES `students` (`student_id`)
);
 
CREATE TABLE agenda (
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    CONSTRAINT pk PRIMARY KEY (`student_id` , `subject_id`),
    CONSTRAINT fk_student FOREIGN KEY (`student_id`)
        REFERENCES `students` (`student_id`),
    CONSTRAINT fk_item FOREIGN KEY (`subject_id`)
        REFERENCES `subjects` (`subject_id`)
);

-- 9. Peaks in Rila

SELECT 
    m.mountain_range, p.peak_name, p.elevation
FROM
    mountains AS m
        JOIN
    peaks AS p ON p.mountain_id = m.`id`
WHERE
    m.mountain_range = 'Rila'
ORDER BY p.elevation DESC;