-- AccountsAndEmployees.sql
SET SERVEROUTPUT ON;

-- Drop tables if exist
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE employees CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

-- Create accounts table
CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    balance NUMBER,
    account_type VARCHAR2(20) -- e.g., 'savings' or 'current'
);

-- Create employees table
CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    department_id NUMBER,
    salary NUMBER,
    performance_rating VARCHAR2(10) -- e.g., 'A', 'B', etc.
);

-- Insert accounts
INSERT INTO accounts VALUES (101, 'Steve Rogers', 5000, 'savings');
INSERT INTO accounts VALUES (102, 'Peter Parker', 7000, 'current');
INSERT INTO accounts VALUES (103, 'Tony Stark', 12000, 'savings');
INSERT INTO accounts VALUES (104, 'Natasha Romanoff', 3000, 'savings');

-- Insert employees
INSERT INTO employees VALUES (1, 'Sarvesh', 10, 50000, 'A');
INSERT INTO employees VALUES (2, 'Rithu', 10, 55000, 'B');
INSERT INTO employees VALUES (3, 'Aswin', 20, 60000, 'A');
INSERT INTO employees VALUES (4, 'Prashanth', 30, 48000, 'C');

COMMIT;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Tables created and data inserted.');
END;
/