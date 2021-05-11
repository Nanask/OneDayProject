package com.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
	
	String fd_tcode; // AS 분류코드,
    String it_group; // AS 분류명,
    String fd_pcode; // AS 식품코드, 
    String fd_fname; // AS 식품명,
    String fd_fdate; // AS 출시연도,
    String fd_ccode; // AS 제조사코드,
    String cp_cname; // AS 제조사명,
    Integer fd_one; // AS "1회제공량",
    Integer fd_all; // AS "총내용량(g)",
    Integer fd_energy; // AS "에너지(Kcal)",
    Integer fd_protein; // AS "단백질(g)",
    Integer fd_fat; // AS "지방(g)",
    Integer fd_car; // AS "탄수화물(g)",
    Integer fd_sugars; // AS "총당류(g)"

}
