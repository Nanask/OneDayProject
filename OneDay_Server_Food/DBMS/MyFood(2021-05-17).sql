-- 여기는 MyFood로 접속

SELECT *
FROM tbl_myfoods
ORDER BY my_seq;

SELECT *
FROM view_섭취량계산;

DROP VIEW view_섭취량계산;

  CREATE VIEW VIEW_섭취량계산 AS 
  (
SELECT
    my_seq 일련번호,
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

