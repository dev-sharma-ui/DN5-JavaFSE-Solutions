-- Exercise 1: Control Structures
-- Bank scenarios

CREATE DATABASE IF NOT EXISTS dn5_plsql;
USE dn5_plsql;

-- tables needed for these scenarios

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    balance DECIMAL(10,2),
    is_vip BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS loans (
    loan_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    interest_rate DECIMAL(5,2),
    due_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO customers (name, age, balance) VALUES
('Ramesh Gupta', 65, 5000),
('Anjali Mehta', 45, 12000),
('Suresh Iyer', 70, 8000),
('Pooja Sharma', 35, 15000),
('Vikram Singh', 62, 3000);

INSERT INTO loans (customer_id, interest_rate, due_date) VALUES
(1, 8.5, '2026-07-15'),
(2, 7.0, '2026-08-20'),
(3, 9.0, '2026-07-10'),
(5, 8.0, '2026-09-01');


-- Scenario 1: Apply 1% interest discount for customers above 60

DELIMITER //

CREATE PROCEDURE apply_senior_discount()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_loan_id INT;
    DECLARE v_customer_id INT;
    DECLARE v_age INT;
    DECLARE v_rate DECIMAL(5,2);

    DECLARE cur CURSOR FOR
        SELECT l.loan_id, c.customer_id, c.age, l.interest_rate
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO v_loan_id, v_customer_id, v_age, v_rate;

        IF done = 1 THEN
            LEAVE read_loop;
        END IF;

        IF v_age > 60 THEN
            UPDATE loans
            SET interest_rate = interest_rate - 1
            WHERE loan_id = v_loan_id;
        END IF;

    END LOOP;

    CLOSE cur;
END //

DELIMITER ;

CALL apply_senior_discount();

SELECT c.name, c.age, l.interest_rate
FROM customers c JOIN loans l ON c.customer_id = l.customer_id;


-- Scenario 2: Set IsVIP = TRUE for balance over $10,000

DELIMITER //

CREATE PROCEDURE update_vip_status()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_customer_id INT;
    DECLARE v_balance DECIMAL(10,2);

    DECLARE cur CURSOR FOR
        SELECT customer_id, balance FROM customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;

    vip_loop: LOOP
        FETCH cur INTO v_customer_id, v_balance;

        IF done = 1 THEN
            LEAVE vip_loop;
        END IF;

        IF v_balance > 10000 THEN
            UPDATE customers SET is_vip = TRUE WHERE customer_id = v_customer_id;
        END IF;

    END LOOP;

    CLOSE cur;
END //

DELIMITER ;

CALL update_vip_status();

SELECT name, balance, is_vip FROM customers;


-- Scenario 3: Reminder for loans due within next 30 days

DELIMITER //

CREATE PROCEDURE loan_due_reminders()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_name VARCHAR(50);
    DECLARE v_due_date DATE;

    DECLARE cur CURSOR FOR
        SELECT c.name, l.due_date
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;

    reminder_loop: LOOP
        FETCH cur INTO v_name, v_due_date;

        IF done = 1 THEN
            LEAVE reminder_loop;
        END IF;

        SELECT CONCAT('Reminder: ', v_name, ', your loan is due on ', v_due_date) AS message;

    END LOOP;

    CLOSE cur;
END //

DELIMITER ;

CALL loan_due_reminders();
