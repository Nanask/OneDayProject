-- 관리자모드로 접속

CREATE TABLESPACE FoodDB
DATAFILE 'C:/oraclexe/data/food.dbf'
SIZE 1M AUTOEXTEND ON NEXT 1K;

CREATE USER food IDENTIFIED BY food
DEFAULT TABLESPACE FoodDB;

GRANT DBA TO food;
