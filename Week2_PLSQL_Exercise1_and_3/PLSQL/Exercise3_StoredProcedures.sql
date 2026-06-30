-- Exercise 3: Stored Procedures
-- Bank scenarios

USE dn5_plsql;

CREATE TABLE IF NOT EXISTS savings_accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(50),
    balance DECIMAL(10,2)
);

CREATE TABLE IF NOT EXISTS employees (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(50),
    department VARCHAR(50),
    salary DECIMAL(10,2)
);

INSERT INTO savings_accounts (customer_name, balance) VALUES
('Ramesh Gupta', 5000),
('Anjali Mehta', 12000),
('Suresh Iyer', 8000);

INSERT INTO employees (emp_name, department, salary) VALUES
('Aman Verma', 'Sales', 45000),
('Riya Kapoor', 'Sales', 48000),
('Karan Joshi', 'IT', 60000);


-- Scenario 1: Process monthly interest for all savings accounts

DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE savings_accounts
    SET balance = balance + (balance * 0.01);
END //

DELIMITER ;

CALL ProcessMonthlyInterest();
SELECT * FROM savings_accounts;



-- Scenario 2: Update employee bonus for a given department

DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(
    IN p_department VARCHAR(50),
    IN p_bonus_percent DECIMAL(5,2)
)
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percent / 100)
    WHERE department = p_department;
END //

DELIMITER ;

CALL UpdateEmployeeBonus('Sales', 10);
SELECT * FROM employees;



-- Scenario 3: Transfer funds between accounts, check balance first

DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN p_from_account INT,
    IN p_to_account INT,
    IN p_amount DECIMAL(10,2)
)
BEGIN
    DECLARE v_from_balance DECIMAL(10,2);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Transfer failed due to an error' AS message;
    END;

    START TRANSACTION;

    SELECT balance INTO v_from_balance
    FROM savings_accounts
    WHERE account_id = p_from_account
    FOR UPDATE;

    IF v_from_balance IS NULL THEN
        SELECT 'Source account not found' AS message;
        ROLLBACK;

    ELSEIF v_from_balance < p_amount THEN
        SELECT 'Insufficient balance for transfer' AS message;
        ROLLBACK;

    ELSE
        UPDATE savings_accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account;

        UPDATE savings_accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account;

        COMMIT;
        SELECT 'Transfer successful' AS message;
    END IF;

END //

DELIMITER ;

-- test: valid transfer
CALL TransferFunds(2, 1, 2000);

-- test: insufficient balance
CALL TransferFunds(1, 2, 999999);

SELECT * FROM savings_accounts;
