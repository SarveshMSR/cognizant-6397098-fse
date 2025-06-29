SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT customer_id
        FROM customers
        WHERE balance > 10000
    ) LOOP
        UPDATE customers
        SET isvip = 'Y'
        WHERE customer_id = rec.customer_id;

        DBMS_OUTPUT.PUT_LINE(' Customer ID ' || rec.customer_id || ' promoted to VIP.');
    END LOOP;

    COMMIT;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('VIP promotion completed for customers with balance over 10,000.');
END;
/
-- This code promotes customers with a balance over 10,000 to VIP status.
-- It uses a cursor to iterate through the customers and updates their status accordingly.
-- The output confirms the promotion for each customer and provides a final confirmation message.