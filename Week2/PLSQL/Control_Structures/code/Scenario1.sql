SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT l.loan_id, c.customer_id
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60
    ) LOOP
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE loan_id = rec.loan_id;

        DBMS_OUTPUT.PUT_LINE('1% discount applied for Customer ID ' || rec.customer_id);
    END LOOP;

    COMMIT;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('Discounts applied to loans for customers over 60 years old.');
END;
/
-- This script applies a 1% discount on the interest rate of loans for customers over 60 years old.
-- It updates the interest rate in the loans table and outputs a message for each customer.