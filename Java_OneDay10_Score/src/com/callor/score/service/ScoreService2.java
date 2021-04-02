package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreService2 {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	int Line;

	public ScoreService2() {
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
				this.input(null, null, null);
			} else if (intMenu == 2) {

			}
		} // end while
		System.out.println("업무종료!!! 신난다 퇴근이다!!");
	}

	public Integer input(String strNum, String strName, String strSub) {

		int intScore = 0;

		while (true) {
			System.out.printf("%d번 학생 이름을 입력하세요(입력을 중단하려면 QUIT", strNum);
			System.out.print("이름 : ");
			strName = scan.nextLine();
			if (strName.equals("QUIT")) {
				break;
			}
			System.out.println(strName + "학생의" + strSub + "점수를 입력하세요(중단하려면 QUIT");
			System.out.println("점수는 0 ~ 100까지 입력해주세요");
			System.out.print(strSub + ">> ");
			intScore = scan.nextInt();
			if (intScore == -1) {

				return null;
			} else if (intScore < 0 || intScore > 100) {
				System.out.println(strSub + "점수는 0부터 100까지 입력해주세요");
				continue;
			}
			break;
		}
		return intScore;

	}

	public void inputScore() {
		
		String[] strSubject = {"국어", "영어", "수학", "과학", "국사"};
		Integer[] intScores = new Integer[strSubject.length];
		
		int nSize = scoreList.size();
		String strNum = String.format("%03d", nSize + 1);
		
		for(int i = 0 ; i <strSubject.length ; i++) {
			intScores[i] = this.input(strNum, strSubject[i]);
			if(intScores[i] == null) {
				return null;
			}
		}
		


	}

	public void printAllList(ScoreVO vo) {

		for (int i = 0; i < scoreList.size(); i++) {

			// scoreList의 i번째 저장된 값을 읽어서 ScoreVO형 sVO 객체에 담기
			ScoreVO sVO = scoreList.get(i);

			System.out.println("순번\t학생\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
			System.out.print(vo.getNum() + "\t");
			System.out.print(vo.getStrname() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMath() + "\t");
			System.out.print(vo.getSci() + "\t");
			System.out.print(vo.getHis() + "\t");
			System.out.print(vo.getTotal() + "\t");
			System.out.print(vo.getAvg() + "\t");

		}

	}
}
