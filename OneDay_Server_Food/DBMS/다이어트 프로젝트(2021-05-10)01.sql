-- food로 접속

CREATE TABLE tbl_foods (

    fd_pcode	CHAR(7)	PRIMARY KEY,
    fd_fname	nVARCHAR2(125)	NOT NULL,
    fd_fdate	VARCHAR2(4)	NOT NULL,	
    fd_ccode	CHAR(6)	NOT NULL,	
    fd_tcode	CHAR(4)	NOT NULL,	
    fd_one	NUMBER,		
    fd_all	NUMBER,		
    fd_energy	NUMBER,		
    fd_protein	NUMBER,		
    fd_fat	NUMBER,		
    fd_car	NUMBER,		
    fd_sugars	NUMBER		

);

CREATE TABLE tbl_company (

    cp_ccode	CHAR(6)		PRIMARY KEY,
    cp_cname	nVARCHAR2(125)	NOT NULL	

);

CREATE TABLE tbl_items (

    it_icode	CHAR(4)		PRIMARY KEY,
    it_group	nVARCHAR2(10)	NOT NULL	

);

SELECT COUNT(*) FROM tbl_foods;
SELECT COUNT(*) FROM tbl_company;
SELECT COUNT(*) FROM tbl_items;


-- tbl_foods와 tbl_company 간의 외래키 선언
ALTER TABLE tbl_foods
ADD CONSTRAINT fk_ccode 
FOREIGN KEY(fd_ccode) 
REFERENCES tbl_company(cp_ccode); 

-- tbl_foods와 tbl_items 간의 외래키 선언
ALTER TABLE tbl_foods
ADD CONSTRAINT fk_tcode 
FOREIGN KEY(fd_tcode) 
REFERENCES tbl_items(it_icode);

CREATE VIEW view_식품정보 AS
(
SELECT
        F.fd_tcode AS 분류코드,
        I.it_group AS 분류명,
        F.fd_pcode AS 상품코드, 
        F.fd_fname AS 식품명,
        F.fd_fdate AS 출시연도,
        F.fd_ccode AS 제조사코드,
        C.cp_cname AS 제조사명,
        F.fd_one AS "1회제공량",
        F.fd_all AS "총내용량(g)",
        F.fd_energy AS "에너지(Kcal)",
        F.fd_protein AS "단백질(g)",
        F.fd_fat AS "지방(g)",
        F.fd_car AS "탄수화물(g)",
        F.fd_sugars AS "총당류(g)"
FROM tbl_foods F
    LEFT JOIN tbl_company C
        ON F.fd_ccode = C.cp_ccode
    LEFT JOIN tbl_items I
        ON F.fd_tcode = I.it_icode
);    

SELECT * FROM "VIEW_식품정보";

CREATE SEQUENCE seq_food_list 
START WITH 1 -- 시작값
INCREMENT BY 1; -- 자동증가값

CREATE TABLE tbl_myfoods(
    my_seq NUMBER PRIMARY KEY,
    my_date	VARCHAR2(10)	NOT NULL,	
    my_pdcode	CHAR(7)		NOT NULL,
    my_eat	VARCHAR2(10)	NOT NULL	
);

DROP TABLE tbl_myfoods;

CREATE VIEW view_섭취리스트 AS
(
SELECT M.my_date AS 날짜,
        F.fd_fname AS 식품명,
        M.my_eat AS 섭취량,
        F.fd_all AS "총내용량(g)",
        F.fd_energy AS "에너지(Kcal)",
        F.fd_protein AS "단백질(g)",
        F.fd_fat AS "지방(g)",
        F.fd_car AS "탄수화물(g)",
        F.fd_sugars AS "총당류(g)"
FROM tbl_foods F
    LEFT JOIN tbl_myfoods M
        ON F.fd_pcode = M.my_pdcode
);

COMMIT; 



