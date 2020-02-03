---(Q2) SQL Queries

---Question (2.1) SELECT
---Gets the whole table, and nothing but the table
SELECT * FROM employee;

---Looks for only those with the last name "King"
SELECT * FROM employee WHERE lastname = 'King';

---Looks for only those with the first name "Andrew", and only reports to NULL;
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

--- Question (2.2) SQL ORDER BY
-- Orders all titles in album by descending order
SELECT * FROM album ORDER BY title DESC;
-- Orders all customers by their cities in ascending order
SELECT * FROM customer ORDER BY city ASC;

--- QUESTION (2.3) INSERT INTO
--- Views the genre table in order by the id number
SELECT * FROM genre ORDER BY genreid;
--- Inserts K-Pop, into the 26th slot of genre
INSERT INTO genre VALUES(26, 'K-pop');
--- Inserts Psy.Rock, into the 27th slot of genre
INSERT INTO genre VALUES(27, 'Psychedelic Rock');

-- Views all the employees
SELECT * FROM employee;
-- Inserts Amanda Vokey with all values needed for the paramaters
INSERT INTO employee VALUES(13, 'Vokey', 'Amanda', 'Company Mascot', 1, TO_DATE('1992-3-30 00:00:00',
'yyyy-mm-dd hh24:mi:ss'), TO_DATE('1978-12-31 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 'Under a bench', 'Tampa',
'FL', 'USA', '33601', '+1 (403) 333-3333', '+1 (403) 131-3131', 'icantcode@chinookcorp.com');
-- Inserts Dante Inferno with all values needed for the paramaters
INSERT INTO employee VALUES(9, 'Inferno', 'Dante', 'Head Hunter', 1, TO_DATE('1308-5-13 00:00:00',
'yyyy-mm-dd hh24:mi:ss'), TO_DATE('1320-5-31 00:00:00', 'yyyy-mm-dd hh24:mi:ss'), 'Gates of Hell', 'Hell',
'MI', 'USA', '48169', '+1 (666) 666-6666', '+1 (666) 666-6666', 'DivineComedy@chinookcorp.com');

SELECT * FROM customer;
---Insert two new customers, the first using the method to create a null record in 
INSERT INTO customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Email,
SupportRepId) VALUES (60, 'Lupe', 'Rodreiguez', 'Atlanta Police Agency', '41 Sunset drive', 'Atlanta',
'GA', 'USA', '15433', '+1 (514) 763-7632', 'LupeChuppy@A_P_Agency.org', 3);
-- Insert customer, using all the values
INSERT INTO customer Values(62, 'Boney', 'Bones', 'The Graveyard', '78 boneway Ave', 'Crypt', 'Unknown', 'Unknown', '75747', 
'+1 (708) 657-9021', '1+ (708) 432-9834', 'BoneyofBones@gravekeep.zom', 5);

---Question (2.4)
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE customerid = 32;
--UPDATE customer SET lastname = 'Walter' WHERE customerid = 32;

SELECT * FROM artist;
--Changes ARTISTID 76's name to CCR
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--Question (2.5) LIKE
SELECT * FROM invoice;
-- Looks for any invoice where the billing address starts with T.
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--Question (2.6) LIKE
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

SELECT * FROM employee;
SELECT * FROM employee WHERE hiredate BETWEEN '1-JUN-03' AND '1-MAR-04';

--Question (2.7) DELETE
SELECT * FROM customer;
SELECT * FROM customer WHERE firstname = 'Robert';

ALTER TABLE invoice DISABLE CONSTRAINT fk_invoicecustomerid;
/
DELETE FROM customer WHERE customerid = 32;

--Question (3.1) SYSTEM DEFINED FUNCTIONS
SELECT CURRENT_TIMESTAMP from dual;
SELECT LENGTH (name) FROM mediatype;
--Question (3.2) SYSTEM DEFINED AGGREGATE FUNCTIONS
SELECT AVG(total) FROM invoice;
SELECT * FROM track;
SELECT MAX(unitprice) from track; 


--Question (3.3) USER DEFINED SCALAR FUNCTIONS
SELECT * FROM invoiceline;
SELECT AVG(unitprice) from invoiceline;
--Question (3.4) USER DEFINED TABLE VALUED FUNCTIONS
SELECT * FROM employee;
SELECT * FROM employee WHERE birthdate > '31-DEC-68';

--Question (4.1) BASIC STORED PROCEDURE
SELECT * FROM employee;
CREATE OR REPLACE PROCEDURE namefinder
IS
    CURSOR curse IS SELECT firstname, lastname FROM employee;
BEGIN
   FOR word IN curse
   LOOP
    DBMS_OUTPUT.PUT_LINE(word.firstname || ' ' || word.lastname);
    END LOOP;
END;
/

BEGIN 
namefinder();
END;
/

--Question (4.2) STORED PROCEDURE INPUT PARAMETERS
SELECT * FROM employee; 
CREATE OR REPLACE PROCEDURE updateemployee (empID in NUMBER , addressChange in VARCHAR2)
IS
BEGIN
    UPDATE employee SET address = addressChange WHERE employeeid = empID;
END;
/
BEGIN
updateemployee(7, '13 Hellsway Ave.');
END;
/
CREATE OR REPLACE PROCEDURE findManager (empID in NUMBER , bossID out NUMBER)
IS
BEGIN
  SELECT reportsto INTO bossID FROM employee WHERE employeeid = empID;
END;
/
DECLARE
    bossID NUMBER(3);
BEGIN
    findManager(7, bossid);
    DBMS_OUTPUT.PUT_LINE(bossid);
END;
/
---QUESTION (4.3) STORED PROCEDURE OUTPUT PARAMETERS
SELECT * FROM customer;
CREATE OR REPLACE PROCEDURE customerFinder (cusID in NUMBER , cusFirstnam out VARCHAR2, cusLastName out VARCHAR2,
cusCompany out VARCHAR2)
IS
BEGIN
  SELECT firstname, lastname, company INTO cusFirstnam, cusLastName, cusCompany FROM customer
  WHERE customerid = cusID;
END;
/
DECLARE
    cus_first VARCHAR2(22);
    cus_last VARCHAR2 (22);
    cus_company VARCHAR2(121);
BEGIN
    customerFinder(5, cus_first, cus_last, cus_company);
    DBMS_OUTPUT.PUT_LINE(cus_first || ' ' || cus_last || ' ' || cus_company);
END;
/
---- QUESTION (5.0) TRANSACTIONS
CREATE OR REPLACE PROCEDURE deleteInvoice(invId IN NUMBER)
IS
BEGIN
    DELETE FROM invoiceline WHERE invoiceid = invId;
    DELETE FROM invoice WHERE invoiceid = invId;
    --COMMIT;---
END;
/
BEGIN
    deleteInvoice(3);
END;
/
SELECT * FROM invoice;

SELECT * FROM customer;
CREATE OR REPLACE PROCEDURE nestedAdd(nesNum IN NUMBER, nesFir IN VARCHAR2, nesLas IN VARCHAR2, 
nesCom IN VARCHAR2, nesEma IN VARCHAR2)
IS
BEGIN
   INSERT INTO customer(customerid, firstname, lastname, company, email) 
    VALUES(nesNum, nesFir, nesLas, nesCom, nesEma);
END;
/
BEGIN
    nestedadd(64, 'Rick', 'Sanchez', 'Himself', 'wubbadubbadub@science.org');
END;
/
--QUESTION (6.1) TRIGGERS AFTER/FOR
CREATE OR REPLACE TRIGGER employee_got_hired
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('You got a new employee!');
END;
/
CREATE OR REPLACE TRIGGER album_new_tunes
BEFORE UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New tunes!');
END;
/
CREATE OR REPLACE TRIGGER get_rid_of_customer
BEFORE DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer got fired from customering!');
END;
/
SELECT * FROM customer;
SELECT * FROM invoice;
SELECT * FROM album;
--QUESTION (7.1) INNER JOINS
SELECT c.firstname, o.invoiceid FROM customer c INNER JOIN invoice o ON c.customerid = o.customerid;

--Question (7.2) OUTER JOINS
SELECT c.firstname, c.lastname, o.invoiceid, o.total FROM customer c FULL JOIN invoice o ON c.customerid = o.customerid;

--QUESTION (7.3) RIGHT JOIN
SELECT r.name, a.title FROM album a RIGHT JOIN artist r ON a.artistid = r.artistid;

--QUESTION (7.4) CROSS JOIN
SELECT * FROM album a CROSS JOIN artist r ORDER BY r.name ASC;

--QUESTION (7.5)
SELECT * FROM employee e, employee m WHERE e.reportsto = m.reportsto;
Commit;