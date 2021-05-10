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
public class FoodVO {
	
	Integer my_seq;
	String my_date;
	String my_pdCode;
	Integer my_eat;

}
