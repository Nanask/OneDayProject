-- 여기는 myfood로 접속

CREATE TABLE tbl_foods (
    fd_code	    CHAR(7)	PRIMARY KEY,
    fd_name 	nVARCHAR2(125)	NOT NULL,	
    fd_year	    NUMBER	,	
    fd_ccode	CHAR(6)	NOT NULL,	
    fd_icode	CHAR(4)	NOT NULL,	
    fd_one	    NUMBER,		
    fd_capa	    NUMBER,		
    fd_cal	    NUMBER,		
    fd_protein	NUMBER,		
    fd_fat  	NUMBER,		
    fd_carbo	NUMBER,		
    fd_sugar	NUMBER

);

DROP TABLE tbl_foods;

CREATE TABLE tbl_company (
    cp_ccode	CHAR(6)		PRIMARY KEY,
    cp_cname	nVARCHAR2(125)	NOT NULL,	
    cp_ceo	nVARCHAR2(50),		
    cp_tel	VARCHAR2(20),		
    cp_addr	nVARCHAR2(125),		
    cp_item	nVARCHAR2(30)		

);

CREATE TABLE tbl_items (
    it_icode	CHAR(4)		PRIMARY KEY,
    it_group	nVARCHAR2(10)	NOT NULL	

);

CREATE TABLE tbl_myfoods (
    my_seq	NUMBER		PRIMARY KEY,
    my_date	VARCHAR2(10)	NOT NULL,	
    my_pdcode	CHAR(7)	NOT NULL,	
    my_eat	VARCHAR2(10)	NOT NULL	

);

--seq만들어야하는 테이블과 이름을 같게 해야 헷갈리지 않는다.
CREATE SEQUENCE seq_myfoods
START WITH 1 INCREMENT BY 1;


-- 임포트 된 데이터 개수 확인
SELECT COUNT(*) FROM tbl_foods;
SELECT COUNT(*) FROM tbl_company;
SELECT COUNT(*) FROM tbl_items;

-- 식품정보와 제조사정보를 JOIN 하여 데이터가 정상으로 임포트 됐는지 확인
-- 여기서 데이터가 출력된다면 제조사정보 테이블에 문제가 있는것이다.
SELECT *
FROM tbl_foods F
    LEFT JOIN tbl_company C
        ON F.fd_ccode = C.cp_ccode
        WHERE C.cp_ccode IS NULL;
        
SELECT *
FROM tbl_foods F
    LEFT JOIN tbl_items I
        ON f.fd_icode = I.it_icode
        WHERE I.it_icode IS NULL;
        
-- 세개의 table 간의 참조무결성 설정 (fk키 설정)
-- 누가 부모이고 누가 자손인지 파악
-- 자손 : tbl_foods, 부모: tbl_company , tbl_items
-- FK 설정은 자손 table에 설정하기

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_company
FOREIGN KEY (fd_ccode)
REFERENCES tbl_company(cp_ccode);

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_items
FOREIGN KEY (fd_icode)
REFERENCES tbl_items(it_icode);

-- AS를 사용하지 않아도 칼럼명 변경 가능
-- 단 변수명이 겹치지 않아야 한다.

CREATE VIEW view_식품정보 AS 
(    SELECT 
        fd_code	식품코드,
        fd_name	식품명,
        fd_year	출시연도,
        fd_ccode	제조사코드,
        fd_icode	분류코드,
        fd_one	제공량,
        fd_capa	총내용량,
        fd_cal	에너지,
        fd_protein	단백질,
        fd_fat	지방,
        fd_carbo	탄수화물,
        fd_sugar	총당류,
        cp_cname	제조사명,
        cp_ceo	대표,
        cp_tel	대표전화,
        cp_addr	주소,
        cp_item	주요품목,
        it_group	분류명
    
    FROM tbl_foods
        LEFT JOIN tbl_company
            ON fd_ccode = cp_ccode
        LEFT JOIN tbl_items
            ON fd_icode = it_icode
);

CREATE VIEW view_섭취정보 AS (
SELECT
    my_seq	일련번호,
    my_date	섭취일자,
    my_pdcode	식품코드,
    my_eat	섭취량,
    식품명,
    출시연도,
    제조사코드,   
    분류코드,
    제공량,
    총내용량,
    에너지,
    단백질,
    지방,
    탄수화물,
    총당류,
    제조사명,
    대표,
    대표전화,
    주소,
    주요품목,
    분류명
FROM tbl_myfoods
    LEFT JOIN view_식품정보
        ON my_pdcode = 식품코드
        );
        
INSERT INTO tbl_myfoods(my_seq, my_pdcode, my_date, my_eat)
VALUES(seq_myfoods.NEXTVAL,'PD00001','2021-05-12',1);

CREATE VIEW view_섭취량계산 AS(
SELECT
    my_date	섭취일자,
    my_pdcode	식품코드,
    식품명,
    my_eat	섭취량,
    제공량 * my_eat AS 제공량,
    총내용량 * my_eat AS 총내용량,
    에너지 * my_eat AS 에너지,
    단백질 * my_eat AS 단백질,
    지방 * my_eat AS 지방,
    탄수화물 * my_eat AS 탄수화물,
    총당류 * my_eat AS 총당류
    
FROM tbl_myfoods
    LEFT JOIN view_식품정보
        ON my_pdcode = 식품코드
);

INSERT INTO tbl_myfoods(my_seq, my_pdcode, my_date, my_eat)
VALUES(seq_myfoods.NEXTVAL,'PD00001','2021-05-12',1);

commit;


