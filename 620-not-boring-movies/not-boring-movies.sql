# Write your MySQL query statement below
SELECT t.id , t.movie, t.description , t.rating
FROM Cinema t
WHERE id % 2 !=0 
AND description != 'boring'
ORDER BY t.rating  DESC