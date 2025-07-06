-- Customer.sql
SET SERVEROUTPUT ON;

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE loans CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/

-- Create tables
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER,
    balance NUMBER,
    isvip CHAR(1) DEFAULT 'N'
);

CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    interest_rate NUMBER,
    due_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Insert data
INSERT INTO customers VALUES (1, 'Steve Rogers', 65, 12000, 'N');
INSERT INTO customers VALUES (2, 'Peter Parker', 45, 8000, 'N');
INSERT INTO customers VALUES (3, 'Tony Stark', 70, 15000, 'N');
INSERT INTO customers VALUES (4, 'Natasha Romanoff', 55, 9000, 'N');

INSERT INTO loans VALUES (101, 1, 5.0, SYSDATE + 10);
INSERT INTO loans VALUES (102, 2, 4.5, SYSDATE + 40);
INSERT INTO loans VALUES (103, 3, 6.0, SYSDATE + 20);
INSERT INTO loans VALUES (104, 4, 4.0, SYSDATE + 25);

COMMIT;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Tables created and data inserted.');
END;
/