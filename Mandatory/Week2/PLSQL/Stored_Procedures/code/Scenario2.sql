--Add bonus to employees in a given department
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_dept_id IN NUMBER,
    p_bonus_pct IN NUMBER
) IS
BEGIN
    FOR emp IN (SELECT emp_id, salary FROM employees WHERE department_id = p_dept_id) LOOP
        UPDATE employees
        SET salary = salary + (salary * p_bonus_pct / 100)
        WHERE emp_id = emp.emp_id;

        DBMS_OUTPUT.PUT_LINE('Bonus added to Emp ID ' || emp.emp_id);
    END LOOP;

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus(10, 10); -- 10% bonus for dept 10
END;
/