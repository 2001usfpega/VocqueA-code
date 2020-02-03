---daoSuperhuman_junction.sql



--TO CREATE A NEW USER
CREATE USER superhuman IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO superhuman;
GRANT DBA TO superhuman WITH ADMIN OPTION;

---DROP TABLES
DROP TABLE shuman_spower_junction;
DROP TABLE superhumans;
DROP TABLE superpowers;
DROP SEQUENCE my_global_seq;
DROP TRIGGER shuman_insertb;
DROP TRIGGER spower_insertb;
COMMIT;

--TABLE CREATION
CREATE TABLE superhumans(
    shuman_id NUMBER(15),
    shuman_name VARCHAR2(100) NOT NULL,
    bounty NUMBER(30) NOT NULL,
    PRIMARY KEY(shuman_id),
    UNIQUE(shuman_name)
);

CREATE TABLE superpowers(
    spower_id NUMBER(15),
    spower_name VARCHAR2(100) NOT NULL,
    PRIMARY KEY(spower_id),
    UNIQUE(spower_name)
);

CREATE TABLE shuman_spower_junction(
    my_shuman_id NUMBER NOT NULL,
    my_spower_id NUMBER NOT NULL,
    CONSTRAINT my_combo_key PRIMARY KEY
        (my_shuman_id, my_spower_id),
    FOREIGN KEY (my_shuman_id) REFERENCES superhumans (shuman_id),
    FOREIGN KEY (my_spower_id) REFERENCES superpowers (spower_id)
);

---my "global" seq
CREATE SEQUENCE my_global_seq
    START WITH 100
    INCREMENT BY 5;
    
    
--MY TRIGGERS  
CREATE OR REPLACE TRIGGER shuman_insertb
BEFORE INSERT ON superhumans
FOR EACH ROW
BEGIN
    IF :new.shuman_id IS NULL THEN
        SELECT my_global_seq.NEXTVAL INTO :new.shuman_id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER spower_insertb
BEFORE INSERT ON superpowers
FOR EACH ROW
BEGIN
    --catch the null insert
    IF :new.spower_id IS NULL THEN
        SELECT my_global_seq.NEXTVAL INTO :new.spower_id FROM dual;
    END IF;
END;
/

SELECT * FROM superhumans;
SELECT * FROM superpowers;


---INSERTS
INSERT INTO superhumans VALUES(null, 'Danny Boy', 250000);
INSERT INTO superhumans VALUES(null, 'Abyss', 240000);
INSERT INTO superhumans VALUES(null, 'Aster', 120000);
INSERT INTO superhumans VALUES(null, 'Asura', 250000);

INSERT INTO superpowers VALUES(null, 'Flying');
INSERT INTO superpowers VALUES(null, 'Toy Chest');
INSERT INTO superpowers VALUES(null, 'Fire Breath');
INSERT INTO superpowers VALUES(null, 'Hair Needles');
INSERT INTO superpowers VALUES(null, 'Regen');
INSERT INTO superpowers VALUES(null, 'error unknown');

INSERT INTO shuman_spower_junction VALUES(100, 120);
INSERT INTO shuman_spower_junction VALUES(100, 125);
INSERT INTO shuman_spower_junction VALUES(100, 140);
INSERT INTO shuman_spower_junction VALUES(105, 145);
INSERT INTO shuman_spower_junction VALUES(110, 130);
INSERT INTO shuman_spower_junction VALUES(110, 140);
INSERT INTO shuman_spower_junction VALUES(115, 135);
INSERT INTO shuman_spower_junction VALUES(115, 145);

SELECT * FROM superhumans; --useraccount (restaurant or inspector)
SELECT * FROM superpowers; -- fridge
SELECT * FROM shuman_spower_junction;  -- user_fridge_junction

----JOIN two tables with their junction table (3 tables total)
SELECT * -----A.shuman_name, C.Spower_name
FROM superhumans A
INNER JOIN shuman_spower_junction B
ON A.shuman_id = B.my_shuman_id
INNER JOIN superpowers C
ON C.spower_id = B.my_spower_id
WHERE A.shuman_name = 'Danny Boy';
---- remover the WHERE clause if you want the entire result set, not just Danny Boy
COMMIT;




