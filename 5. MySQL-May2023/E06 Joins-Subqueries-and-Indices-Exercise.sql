-- 1. Employee Address

SELECT e.employee_id, e.job_title, e.address_id, address_text
FROM employees e
JOIN addresses a on a.address_id = e.address_id
ORDER BY a.address_id
LIMIT 5;

-- 2. Addresses with Towns

SELECT e.first_name, e.last_name, t.name, a.address_text
FROM employees e
JOIN addresses a ON a.address_id = e.address_id
JOIN towns t on t.town_id = a.town_id
ORDER BY e.first_name, e.last_name
LIMIT 5;

-- 3. Sales Employee

SELECT e.employee_id, e.first_name, e.last_name, d.name
FROM employees AS e
JOIN departments AS d
    ON d.department_id = e.department_id
WHERE d.`name` = 'Sales'
ORDER BY employee_id DESC;

-- 4. Employee Departments

SELECT e.employee_id, e.first_name, e.salary, d.name
FROM employees AS e
INNER JOIN departments AS d
    ON d.department_id = e.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;

-- 5. Employees Without Project

SELECT e.employee_id, e.first_name
FROM employees AS e
LEFT JOIN employees_projects p
    ON e.employee_id = p.employee_id
WHERE p.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;

-- 6. Employees Hired After

SELECT e.first_name,
       e.last_name,
       e.hire_date,
       d.name AS 'dept_name'
FROM employees AS e
JOIN departments AS d
    ON d.department_id = e.department_id
WHERE d.name IN ('Sales', 'Finance') AND DATE(hire_date) > '1999-01-01'
ORDER BY hire_date;

-- 7. Employees with Project

SELECT e.employee_id,
       e.first_name,
       p.name AS 'project_name'
FROM employees AS e
JOIN employees_projects AS ep
    ON e.employee_id = ep.employee_id
JOIN projects p
    ON p.project_id = ep.project_id
WHERE DATE(p.start_date) > '2002-08-13'
  AND p.end_date IS NULL
ORDER BY e.first_name,
         p.name
LIMIT 5;

-- 8. Employee 24

SELECT e.employee_id,
       e.first_name,
       IF(YEAR(p.start_date) >= 2005, NULL, p.name) AS 'project_name'
FROM employees AS e
JOIN employees_projects AS ep
    ON e.employee_id = ep.employee_id
JOIN projects p
    ON p.project_id = ep.project_id
WHERE e.employee_id = 24
ORDER BY p.name;

-- 9. Employee Manager

SELECT e.employee_id,
       e.first_name,
       e.manager_id,
       m.first_name
FROM employees AS e
JOIN employees AS m
    ON e.manager_id = m.employee_id
WHERE e.manager_id IN (3, 7)
ORDER BY e.first_name;

-- 10. Employee Summary

SELECT e.employee_id,
       CONCAT_WS(' ', e.first_name, e.last_name) AS 'employee_name',
       CONCAT_WS(' ', m.first_name, m.last_name) AS 'manager_name',
       d.name AS 'department_name'
FROM employees AS e
JOIN departments AS d
    ON d.department_id = e.department_id
JOIN employees AS m
    ON e.manager_id = m.employee_id
WHERE e.manager_id IS NOT NULL
ORDER BY e.employee_id
LIMIT 5;

-- 11. Min Average Salary

SELECT AVG(salary) AS 'min_average_salary'
FROM employees
GROUP BY department_id
ORDER BY min_average_salary
LIMIT 1;

-- 12. Highest Peaks in Bulgaria

SELECT c.country_code,
       m.mountain_range,
       p.peak_name,
       p.elevation
FROM peaks AS p
JOIN mountains AS m
    ON p.mountain_id = m.id
JOIN mountains_countries AS c
    ON m.id = c.mountain_id
WHERE c.country_code = 'BG'
  AND p.elevation > '2835'
ORDER BY p.elevation DESC;

-- 13. Count Mountain Ranges

SELECT c.country_code,
       COUNT(m.mountain_range) AS 'mountain_range'
FROM mountains AS m
JOIN mountains_countries AS c
    ON m.id = c.mountain_id
WHERE c.country_code IN ('BG', 'RU', 'US')
GROUP BY c.country_code
ORDER BY mountain_range DESC;

-- 14. Countries with Rivers

SELECT c.`country_name`,
       r.`river_name`
FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr
    ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r
    ON r.`id` = cr.`river_id`
WHERE c.`continent_code` = 'AF'
ORDER BY c.`country_name`
LIMIT 5;

-- 15. *Continents and Currencies

SELECT d1.continent_code,
       d1.currency_code,
       d1.currency_usage
FROM (
	SELECT `c`.`continent_code`, `c`.`currency_code`,
    COUNT(`c`.`currency_code`) AS `currency_usage` FROM countries AS c
	GROUP BY c.currency_code, c.continent_code HAVING currency_usage > 1
    ) AS d1
LEFT JOIN (
    SELECT `c`.`continent_code`,
           `c`.`currency_code`,
           COUNT(`c`.`currency_code`) AS `currency_usage`
    FROM countries as c
    GROUP BY c.currency_code, c.continent_code
    HAVING currency_usage > 1
    ) AS d2
ON d1.continent_code = d2.continent_code
       AND d2.currency_usage > d1.currency_usage
WHERE d2.currency_usage IS NULL
ORDER BY d1.continent_code, d1.currency_code;

-- 16. Countries Without Any Mountains

SELECT COUNT(c.`country_code`)
FROM `countries` AS c
LEFT JOIN `mountains_countries` AS mc
    ON c.`country_code` = mc.`country_code`
LEFT JOIN `mountains` AS m
    ON mc.`mountain_id` = m.`id`
WHERE m.`id` IS NULL;

-- 17. Highest Peak and Longest River by Country

SELECT c.country_name,
       MAX(p.elevation) AS 'highest_peak_elevation',
       MAX(r.length) AS 'longest_river_length'
FROM countries AS c
JOIN mountains_countries AS mc
    ON c.country_code = mc.country_code
JOIN peaks AS p
    ON mc.mountain_id = p.mountain_id
JOIN countries_rivers AS cr
    ON c.country_code = cr.country_code
JOIN rivers AS r
    ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC,
         longest_river_length DESC,
         c.country_name
LIMIT 5;
