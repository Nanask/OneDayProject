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
public class MyFoodDTO {
	
	String my_date; // AS 날짜,
    String fd_fname; // AS 식품명,
    Integer my_eat; // AS 섭취량,
    Integer fd_all; // AS "총내용량(g)",
    Integer fd_energy; //AS "에너지(Kcal)",
    Integer fd_protein; // AS "단백질(g)",
    Integer fd_fat; // AS "지방(g)",
    Integer fd_car; // AS "탄수화물(g)",
    Integer fd_sugars;  // AS "총당류(g)"

}
