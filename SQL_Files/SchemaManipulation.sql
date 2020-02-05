---SchemaManipulation.sql

--is SQL case sensitive? no.
------ BUT, anything in quotes IS case sensitive.
SELECT * FROM album; --but this is the convention
SELECT * FROM album;


----------ON TO SCHEMA MANIPULATION!!!!!

/*DATATYPES in oracle sql:
    NUMBER, VARCHAR, VARCHAR2, DATE, TIMESTAMP, BLOB, CLOB, and more

CONSTRAINTS: they are restrictions on data that can be entered into a
    column.
    NOT NULL- ensures the record has a value in this column
    UNIQUE- ensures that any two records will NOT have the same value for this
        column
    PRIMARY KEY- it represents the official identifier for the record
        ---PK is a combination of UNIQUE and NOT NULL
    FOREIGN KEY- is a reference pointer to another table's record
    
    ----example syntax for PK: PRIMARY KEY (refKey from THIS table)
    ----example syntax for FK: FOREIGN KEY (reference_attribute_from_this_table)
                                REFERENCES other_table (PK_from_other_table)
    
    CHECK creates an additional custom condition for the column
    ----example syntax: CONSTRAINT constraint_name CHECK (column_name >15);
    (some databases have DEFAULT constraint)
*/
--DDL: CREATE a table
CREATE TABLE pokemon(
    pokemon_id NUMBER(15) --PRIMARY KEY
    , pokemon_name VARCHAR2(100)
    , pokemon_type VARCHAR2(25)
    , PRIMARY KEY (pokemon_id)
);

--looking at all of a table's records
SELECT * FROM pokemon;
--how to look at a table's structure and datatypes
DESC pokemon;
DESCRIBE pokemon;

---DDL: DROP a table
DROP TABLE pokemon;
---DDL: ALTER a table
ALTER TABLE pokemon ADD pokemon_secondtype VARCHAR2(25);
--DDL: TRUNCATE
/*not going to do an example BUT truncate deletes all entries into a table
while keeping the table structure intact. DROP is like throwing a cup of water
into the trash, while TRUNCATE is like pouring out the water while keep the cup
 (deletes all rows, saves the columns)
*/



-----NOW TIME FOR DATA MANIPULATION!!!!!
--DML: SELECT
SELECT * FROM pokemon;

--DML: INSERT
INSERT INTO pokemon VALUES(1, 'bulbasaur', 'grass', 'ice');
INSERT INTO pokemon VALUES(7, 'squirtle', 'water', null);
INSERT INTO pokemon VALUES(121, 'starmie', 'water', 'psychic');
INSERT INTO pokemon VALUES(129, 'magikarp', 'water', null);
INSERT INTO pokemon(pokemon_name, pokemon_id, pokemon_type) 
    VALUES('mewtwo', 150, 'psychic');

--DML: UPDATE
UPDATE  pokemon SET pokemon_secondtype='poison' WHERE pokemon_id=7;
--UPDATE  pokemon SET pokemon_secondtype='barnacles';

--DML: DELETE
--DELETE FROM pokemon; --STAY AWAY FROM THIS
DELETE FROM pokemon WHERE pokemon_id>7;

COMMIT;
ROLLBACK;







