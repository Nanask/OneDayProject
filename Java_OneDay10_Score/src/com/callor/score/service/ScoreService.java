package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreService {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	int Line;
	Integer sumKor ;
	Integer sumEng ;
	Integer sumMath ;
	Integer sumHis ;
	Integer sumSci ;
	Integer sumNum ;
	Integer sumTotal ;
	Float sumAvg ;
	
	

	public ScoreService() {
		// TODO Auto-generated constructor stub

		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
		Line = 50;
		
		

	}

	public void selectMenu() {

		while (true) {
			System.out.println("=".repeat(Line));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("-".repeat(Line));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("-".repeat(Line));
			System.out.print("업무선택 >> ");
			String strMenu = scan.nextLine();
			if (strMenu.equals("QUIT")) {
				break;

			}
			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				// TODO: handle exception

				System.out.println("메뉴를 다시 입력주세요");
				System.out.println("메뉴는 1~2, QUIT만 입력가능");
				continue;
			}

			if (intMenu == 1) {
				this.inputScore();
			} else if (intMenu == 2) {
				this.printAllList();

			}
		} // end while
		System.out.println("업무종료!!! 신난다 퇴근이다!!");
	}

	public void inputScore() {

		int num = 0;
		String strName = "";
		int Kor = 0;
		int Eng = 0;
		int Math = 0;
		int His = 0;
		int Sic = 0;

		while (true) {
			System.out.println("=".repeat(Line));
			System.out.printf("학생 이름을 입력하세요(입력을 중단하려면 QUIT)\n");
			System.out.println("-".repeat(Line));
			System.out.print("이름 : ");
			strName = scan.nextLine();
			if (strName.equals("QUIT")) {
				return;
			}
			break;
		}
			System.out.println(strName + " 학생 이름의 성적을 입력하세요(성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT)\n");
		
			System.out.print("국어 >> ");
			Kor = scan.nextInt();
			System.out.print("영어 >> ");
			Eng = scan.nextInt();
			System.out.print("수학 >> ");
			Math = scan.nextInt();
			System.out.print("국사 >> ");
			His = scan.nextInt();
			System.out.print("과학 >> ");
			Sic = scan.nextInt();
			
		ScoreVO scoreVO = new ScoreVO();
		scoreVO.setNum(num);
		scoreVO.setStrname(strName);
		scoreVO.setKor(Kor);
		scoreVO.setEng(Eng);
		scoreVO.setMath(Math);
		scoreVO.setHis(His);
		scoreVO.setSci(Sic);
		
		Integer total = this.makeTotal();
		float avg = (float) total / 5;
		scoreVO.setTotal(total);
		scoreVO.setAvg(avg);
		

		scoreList.add(scoreVO);

		System.out.println(strName + "학생의 성적이 추가 되었습니다.");

		System.out.println("국어 >> " + scoreVO.getKor());
		System.out.println("영어 >> " + scoreVO.getEng());
		System.out.println("수학 >> " + scoreVO.getMath());
		System.out.println("국사 >> " + scoreVO.getHis());
		System.out.println("과학 >> " + scoreVO.getSci());
		System.out.println(scoreVO.getTotal());
		System.out.println(scoreVO.getAvg());

	}

	public void makeScore() {
		sumKor = 0;
		sumEng = 0;
		sumMath = 0;
		sumHis = 0;
		sumSci = 0;
		sumNum = 0;
		sumTotal = 0;
		sumAvg = 0.f;
		
		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);

			sumKor += vo.getKor();
			sumEng += vo.getEng();
			sumMath += vo.getMath();
			sumHis += vo.getHis();
			sumSci += vo.getSci();
			sumNum += vo.getNum();
			sumTotal += vo.getTotal(); 
			sumAvg +=(float)vo.getTotal() / 5 / scoreList.size();
					
			
		}
		
	}
	public Integer makeTotal() {
		Integer total = 0;
		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);
			total = vo.getKor();
			total += vo.getEng();
			total += vo.getMath();
			total += vo.getHis();
			total += vo.getSci();
		}
		return total;
	}

	public void printAllList() {

		for (int i = 0; i < scoreList.size(); i++) {

			// scoreList의 i번째 저장된 값을 읽어서 ScoreVO형 sVO 객체에 담기
			ScoreVO vo = scoreList.get(i);

			System.out.println("순번\t학생\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
			System.out.print(vo.getNum() + "\t");
			System.out.print(vo.getStrname() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMath() + "\t");
			System.out.print(vo.getSci() + "\t");
			System.out.print(vo.getHis() + "\t");
			System.out.print(vo.getTotal() + "\t");
			System.out.print(vo.getAvg() + "\n");
			
			System.out.println("총점학생수국어영어수학과학국사총점평균");
			

		}
	}
	

}
