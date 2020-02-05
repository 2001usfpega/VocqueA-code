--TO CREATE A NEW USER
------and grant that user permissions
--CREATE USER bankUser IDENTIFIED BY p4ssw0rd;
--
--GRANT CONNECT, RESOURCE TO bankUser;
--GRANT DBA TO bankUser WITH ADMIN OPTION;


DROP TABLE userbank;
CREATE TABLE userbank(
    user_id NUMBER(15) 
    , first_name VARCHAR2 (100) 
    , last_name VARCHAR2 (100) 
    , username VARCHAR2 (100)
    , password VARCHAR2 (100)
    , isAdmin Number (15)
     , accnum NUMBER (15) 
    , acctype VARCHAR2 (100)
    , balance FLOAT (100)
    , savings FLOAT (100)
    , PRIMARY KEY (user_id)
);
SELECT * FROM userbank;
INSERT INTO userbank VALUES (userid.nextval, 'Stan', 'Marsh','Stannyboy', '707', 0, accID.nextval, 'Checking', 176.09, 54.32);
INSERT INTO userbank VALUES (userid.nextval, 'Kyle', 'Brofloski','Basketball', 'kyle', 0, accID.nextval, 'Checking', 234.78, 129.00);
INSERT INTO userbank VALUES (userid.nextval, 'Eric', 'Cartman', 'Ericisbest', 'cartmansmom', 0,accID.nextval, 'Checking', 43.21, 1.50);

DROP TABLE acctab;
CREATE TABLE acctab(
    accnum NUMBER (15) 
    , acctype VARCHAR2 (100)
    , balance FLOAT (100)
    , savings FLOAT (100)
    , user_ID_FK NUMBER (15) 
    , FOREIGN KEY (user_ID_FK)
    REFERENCES userbank (user_id)
);

SELECT * FROM acctab;
INSERT INTO acctab VALUES(66, 'Checking', 176.09, 54.32, 1);
INSERT INTO acctab VALUES(67, 'Checking', 234.78, 129.00, 2);
INSERT INTO acctab VALUES(68, 'Checking', 43.21, 1.50, 3);


CREATE OR REPLACE TRIGGER newcustomer
BEFORE INSERT ON userbank
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('We got a new customer!');
END;
/
CREATE OR REPLACE TRIGGER customerleft
BEFORE DELETE ON userbank
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('We lost a customer');
END;
/
CREATE OR REPLACE TRIGGER newaccount
BEFORE INSERT ON acctab
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new account has openned');
END;
/
CREATE OR REPLACE TRIGGER lostaccount
BEFORE DELETE ON acctab
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A account has closed.');
END;
/


CREATE OR REPLACE PROCEDURE insert_user(user_id IN NUMBER , first_name IN VARCHAR2, 
last_name IN VARCHAR2, username IN VARCHAR2, password IN VARCHAR2, isAdmin IN NUMBER)
   
IS --- After is you create variables
BEGIN
    INSERT INTO userbank VALUES (user_id, first_name, last_name, username, password, isAdmin);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE insert_account( accnum IN NUMBER,acctype IN VARCHAR2, balance IN FLOAT, savings IN FLOAT,
userFK IN NUMBER)
IS
BEGIN
    
END;
/
CREATE OR REPLACE PROCEDURE deleteaccount(user_id IN NUMBER)
IS
BEGIN
    DELETE FROM acctab WHERE user_ID_FK = user_id;
    DELETE FROM userbank WHERE user_id = user_id;
    --COMMIT;---
END;
/

UPDATE acctab SET balance = '443.92' WHERE accnum = 2;
 DELETE FROM acctab WHERE accnum = 8889;
SELECT * FROM userbank u FULL OUTER JOIN acctab a ON u.user_id = a.user_ID_FK;

CREATE SEQUENCE userID
start with 1
increment by 1
minvalue 0
maxvalue 100
cycle;

CREATE SEQUENCE accID
start with 100
increment by 3
minvalue 100
maxvalue 1000
cycle;
Commit;
