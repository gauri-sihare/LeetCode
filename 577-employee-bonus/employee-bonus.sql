SELECT e.name , b.bonus
FROM Employee e
LEFT JOIN Bonus b
ON e.empId  = B.empId
WHERE b.bonus < 1000 
OR b.bonus is NULL