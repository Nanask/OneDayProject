package com.callor.word.model;

public class WordVO {
	
	private String English;
	private String Korea;
	private Integer count;
	public String getEnglish() {
		return English;
	}
	public void setEnglish(String english) {
		English = english;
	}
	public String getKorea() {
		return Korea;
	}
	public void setKorea(String korea) {
		Korea = korea;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "WordService [영어=" + English + ", 한글=" + Korea + ", count=" + count + "]";
	}
	
	
	

}
