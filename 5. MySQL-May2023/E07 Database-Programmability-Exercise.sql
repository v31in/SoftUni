-- Part I – Queries for SoftUni Database
-- 1. Employees with Salary Above 35000

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
    SELECT first_name, last_name
    FROM employees
    WHERE salary > 35000
    ORDER BY first_name, last_name, employee_id;
END$$


-- 2. Employees with Salary Above Number

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary DECIMAL(50, 4))
BEGIN
    SELECT e.first_name, e.last_name
        FROM employees AS e
    WHERE e.salary >= salary
    ORDER BY e.first_name, e.last_name, e.employee_id;
END$$

-- 3. Town Names Starting With

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with (town_substring VARCHAR(50))
BEGIN
    SELECT name AS 'town_name'
    FROM towns
    WHERE name LIKE CONCAT(town_substring,'%')
    ORDER BY name;
END$$

-- 4. Employees from Town

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
    SELECT e.first_name,
           e.last_name
    FROM employees AS e
    JOIN addresses AS a
        ON a.address_id = e.address_id
    JOIN towns AS t
        ON t.town_id = a.town_id
    WHERE t.name = town_name
    ORDER BY e.first_name, e.last_name, e.employee_id;
END$$

-- 5. Salary Level Function

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
RETURNS VARCHAR(8)
DETERMINISTIC
BEGIN
    DECLARE salary_level VARCHAR(8);
    IF salary < 30000 THEN SET salary_level := 'Low';
    ELSEIF salary <= 50000 THEN SET salary_level := 'Average';
    ELSE SET salary_level := 'High';
    END IF;
    RETURN salary_level;
END$$

-- 6. Employees by Salary Level

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
RETURNS VARCHAR(8)
DETERMINISTIC
BEGIN
    DECLARE salary_level VARCHAR(8);
    IF salary < 30000 THEN SET salary_level := 'Low';
    ELSEIF salary <= 50000 THEN SET salary_level := 'Average';
    ELSE SET salary_level := 'High';
    END IF;
    RETURN salary_level;
END$$

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
    SELECT first_name, last_name
    FROM employees
    WHERE ufn_get_salary_level(salary) LIKE salary_level
    ORDER BY first_name DESC, last_name DESC;
END$$

-- 7. Define Function

DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
    RETURN word REGEXP (CONCAT('^[', set_of_letters, ']+$'));
END$$

-- PART II – Queries for Bank Database
-- 8. Find Full Name

DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
    SELECT CONCAT_WS(' ', first_name, last_name) AS 'full_name'
    FROM account_holders
    ORDER BY full_name, id;
END$$

-- 9. People with Balance Higher Than

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(money DECIMAL(19, 4))
BEGIN
    SELECT h.first_name,
           h.last_name
    FROM account_holders AS h
    JOIN accounts AS a
        ON h.id = a.account_holder_id
    GROUP BY h.first_name, h.last_name
    HAVING SUM(a.balance) > money
    ORDER BY MAX(a.account_holder_id);
END$$

-- 10. Future Value Function

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4), yearly_interest DOUBLE, years INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
    DECLARE future_sum DECIMAL(19, 4);
    SET future_sum := sum * POW(1 + yearly_interest, years);
    RETURN future_sum;
END$$

-- 11. Calculating Interest

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4), yearly_interest DOUBLE, yers INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
    DECLARE future_sum DECIMAL(19, 4);
    SET future_sum := sum * POW(1 + yearly_interest, yers);
    RETURN future_sum;
END$$

CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(19,4))
BEGIN
    SELECT a.id AS 'account_id',
           ah.first_name,
           ah.last_name,
           a.balance AS 'current_balance',
           ufn_calculate_future_value(a.balance, interest_rate, 5) AS 'balance_in_5_years'
    FROM account_holders AS ah
    JOIN accounts AS a
        ON ah.id = a.account_holder_id
    WHERE a.id = account_id;
END$$

-- 12. Deposit Money

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0) THEN
        ROLLBACK;
    ELSE
        UPDATE accounts AS ac
        SET ac.balance = ac.balance + money_amount
        WHERE ac.id = account_id;
    END IF;
END$$

-- 13. Withdraw Money

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id int, money_amount decimal(19,4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0 OR
        (SELECT `balance`
         FROM accounts AS a
         WHERE a.`id` = account_id) < money_amount) THEN
    ROLLBACK;
    ELSE
        UPDATE accounts as ac SET ac.balance = ac.balance - money_amount
        WHERE ac.id = account_id;
        COMMIT;
    END IF;
END$$

-- 14. Money Transfer

CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, money_amount DECIMAL(19,4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0
        OR (SELECT `balance`
         FROM accounts AS a
         WHERE a.`id` = from_account_id) < money_amount)
        OR from_account_id = to_account_id
        OR (SELECT COUNT(id) FROM accounts WHERE id = from_account_id) <> 1
        OR (SELECT COUNT(id) FROM accounts WHERE id = to_account_id) <> 1
       THEN
    ROLLBACK;
    ELSE
        UPDATE accounts as ac
        SET ac.balance = ac.balance - money_amount
        WHERE ac.id = from_account_id;
        UPDATE accounts as ac
        SET ac.balance = ac.balance + money_amount
        WHERE ac.id = to_account_id;
        COMMIT;
    END IF;
END;

-- 15. Log Accounts Trigger

CREATE TABLE `logs`(
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    old_sum DECIMAL(19, 4) NOT NULL,
    new_sum DECIMAL(19, 4) NOT NULL
);

CREATE TRIGGER tr_change_balance
AFTER UPDATE ON accounts
FOR EACH ROW
BEGIN
    INSERT INTO logs(account_id, old_sum, new_sum)
    VALUES (OLD.id, OLD.balance, NEW.balance);
END;

-- 16. Emails Trigger

CREATE TABLE logs(
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    old_sum DECIMAL(19, 4) NOT NULL,
    new_sum DECIMAL(19, 4) NOT NULL
);

CREATE TRIGGER tr_change_balance
AFTER UPDATE ON accounts
FOR EACH ROW
BEGIN
    INSERT INTO logs(account_id, old_sum, new_sum)
    VALUES (OLD.id, OLD.balance, NEW.balance);
END;

CREATE TABLE notification_emails(
    id INT PRIMARY KEY AUTO_INCREMENT,
    recipient INT NOT NULL,
    subject TEXT,
    body TEXT
);

CREATE TRIGGER tr_email_on_change_balance
    AFTER INSERT
    ON logs
    FOR EACH ROW
    BEGIN
        INSERT INTO notification_emails(recipient, subject, body)
            VALUES (NEW.account_id,
                    CONCAT_WS(' ', 'Balance change for account:', NEW.account_id),
                    CONCAT_WS(' ', 'On', NOW(), 'your balance was changed from', NEW.old_sum, NEW.new_sum,'.'));
    END;
