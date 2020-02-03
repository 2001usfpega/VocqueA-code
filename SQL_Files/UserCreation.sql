----THIS IS A COMMENT IN SQL!!!!!

--TO CREATE A NEW USER
------and grant that user permissions
CREATE USER pokemondb IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO pokemondb;
GRANT DBA TO pokemondb WITH ADMIN OPTION;