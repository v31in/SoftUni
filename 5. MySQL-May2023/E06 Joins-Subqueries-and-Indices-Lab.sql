-- 1. Managers

SELECT e.employee_id,
       CONCAT_WS(' ', e.first_name, e.last_name) AS 'full_name',
       d.department_id,
       d.name
FROM employees e
JOIN departments d ON e.employee_id = d.manager_id
ORDER BY employee_id
LIMIT 5;

-- 2. Towns Addresses

SELECT t.town_id, t.name, a.address_text
FROM towns t
JOIN addresses a on t.town_id = a.town_id
WHERE t.town_id IN (9, 15, 32)
ORDER BY t.town_id, a.address_id;

-- 3. Employees Without Managers

SELECT e.employee_id, e.first_name, e.last_name, e.department_id, e.salary
FROM employees e
WHERE e.manager_id IS NULL;

-- 4. Higher Salary

SELECT COUNT(e.employee_id) AS 'count'
FROM employees e
WHERE e.salary > (
    SELECT AVG(salary) AS 'average_salary' FROM employees
    );
    