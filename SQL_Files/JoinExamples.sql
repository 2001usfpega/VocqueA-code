--------------JOIN EXAMPLES!!!!!

SELECT * FROM album;
SELECT * FROM artist;

------INNER JOIN
SELECT * FROM artist a INNER JOIN album b ON a.artistid = b.artistid;
----let's do a count
SELECT COUNT(*) FROM artist a INNER JOIN album b ON a.artistid = b.artistid;
--- old way of doing an inner join
SELECT * FROM artist a, album b WHERE a.artistid = b.artistid;


---------LEFT OUTER JOIN
SELECT * FROM artist a LEFT OUTER JOIN album b ON a.artistid = b.artistid;
-- let's do a count
SELECT COUNT(*) FROM artist a LEFT OUTER JOIN album b ON a.artistid = b.artistid;
--- old way of doing a left outer join
SELECT * FROM artist a, album b WHERE a.artistid=b.artistid(+);

----------RIGHT OUTER JOIN
SELECT * FROM artist a LEFT OUTER JOIN album b ON a.artistid = b.artistid;
----------let's do a count
SELECT COUNT(*) FROM artist a RIGHT OUTER JOIN album b ON a.artistid = b.artistid;
-------- old way of doing it.
SELECT * FROM artist a, album b WHERE a.artistid(+)=b.artistid;


--------FULL OUTER JOIN
SELECT * FROM artist a FULL OUTER JOIN album b ON a.artistid = b.artistid;
SELECT * FROM artist a FULL JOIN album b ON a.artistid = b.artistid;

-------- Let's count it!
SELECT COUNT(*) FROM artist a FULL OUTER JOIN album b ON a.artistid = b.artistid;


-----joins do NOT have to be joined on keys, they CAN be non-key fields
-----LEFT without middle of vendiagram,
-----(exclusive left join, aka distinct left join, aka strictly left join)
SELECT * FROM artist a LEFT OUTER JOIN album b ON a.artistid=b.artistid
    WHERE a.artistid NOT IN(
        SELECT c.artistid FROM artist c INNER JOIN album d ON c.artistid = d.artistid
        );

----ANOTHER WAY to do the same exact thing
SELECT * FROM artist a LEFT OUTER JOIN album b ON a.artistid = b.artistid
    WHERE b.artistid IS NULL;
    
------EXCLUSIVE FULL JOIN
SELECT * FROM artist a FULL OUTER JOIN album b ON a.artistid = b.artistid
    WHERE b.artistid IS NULL OR a.artistid IS NULL;
    
    
--SELF JOIN
---SELECT * FROM table01 a INNER JOIN table01 b ON a.id=b.foreignid;

----CROSS JOIN aka CARTESIAN JOIN
------SELECT  * FROM table01 CROSS JOIN table02;
