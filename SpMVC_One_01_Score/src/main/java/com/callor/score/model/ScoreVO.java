package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ScoreVO {
	
	private Long sc_Seq =0l;	//BIGINT
	private String sc_Stnum;	//	CHAR(8)
	private String sc_Subject;	//	VARCHAR(20)
	private Integer sc_Score;	//	INT


}
