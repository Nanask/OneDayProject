package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ListDTO {
	
	private String num;
	private String name;
	private String dept;
	private int grade;
	private int subject;
	private int total;
	private Float avg;
	

}
