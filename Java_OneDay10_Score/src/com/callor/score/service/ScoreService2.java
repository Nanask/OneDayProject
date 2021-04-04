package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreService2 {

	protected List<ScoreVO> scoreList;
	protected Scanner scan;
	protected int line;

	public ScoreService2() {
		scoreList = new ArrayList<ScoreVO>();
		scan = new Scanner(System.in);
		line = 80;
	}

	public void selectMenu() { // 메뉴

		while (true) {
			System.out.println("=".repeat(line));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("-".repeat(line));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("-".repeat(line));
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
				this.printList();

			}
		} // end while
		System.out.println("업무종료");
	}

	public void inputScore() {// 학생별 성적입력
		int num = 0;
		String strName = "";

		while (true) {
			System.out.println("=".repeat(line));
			System.out.printf("학생 이름을 입력하세요(입력을 중단하려면 QUIT)\n");
			System.out.println("-".repeat(line));
			System.out.print("이름 : ");
			strName = scan.nextLine();
			if (strName.equals("QUIT")) {
				return;
			}
			break;
		}
		num = scoreList.size() + 1;

		System.out.println(num + "번 " + strName + "학생의 성적을 입력하세요(성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT)");
		Integer kor = this.inputScore("국어"); //inputScore(매개변수) 호출을 하면 inputScore(매개변수)의 return 값을 넘겨준다.
		if (kor == null) {
			return; //void에서 리턴값을 쓰지않아도 되지만 쓰는 이유는
					//kor == null인경우 아무것도 실행시키지 않고 select로 다시 보내기 위한 것
		}
		Integer eng = this.inputScore("영어");
		if (eng == null) {
			return;
		}
		Integer math = this.inputScore("수학");
		if (math == null) {
			return;
		}
		Integer sic = this.inputScore("과학");
		if (sic == null) {
			return;
		}
		Integer his = this.inputScore("국사");
		if (his == null) {
			return;
		}
		int total = kor + eng + math + sic + his;
		float avg = total / 5;

		ScoreVO vo = new ScoreVO();
		vo.setNum(num);
		vo.setStrname(strName);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMath(math);
		vo.setSci(sic);
		vo.setHis(his);
		vo.setTotal(total);
		vo.setAvg(avg);
		scoreList.add(vo);

		System.out.println(strName + "학생의 성적이 추가 되었습니다.");

		System.out.println("국어 >> " + vo.getKor());
		System.out.println("영어 >> " + vo.getEng());
		System.out.println("수학 >> " + vo.getMath());
		System.out.println("국사 >> " + vo.getHis());
		System.out.println("과학 >> " + vo.getSci());
	}

	public Integer inputScore(String subject) { // 성적 입력 유효성 검사
		while (true) {
			System.out.print(subject + ">> ");
			String strScore = scan.nextLine();
			if (strScore.equals("QUIT")) {
				return null; // QUIT를 사용했을 때 리턴값으로 
			}
			Integer intScore = 0;

			try {
				intScore = Integer.valueOf(strScore);
			} catch (Exception e) {
				System.out.println("성적은 숫자로만 입력해주세요");
				continue;
			}
			if (intScore < 0 || intScore > 100) {
				System.out.println("성적범위 : 0 ~ 100까지");
				continue;
			}
			return intScore;// return값은 void형이 아닌 Integer형이기 때문에 무조건 사용해야 하는데
							// intScore값을 return값으로 정한 이유는 유효성검사에 맞는 값이 입력되었을때 
							// intScore값으로 하기 위해 
		}
	}

	public void printList() { // 각 학생별 성적리스트

		System.out.println("순번\t이름\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println("-".repeat(line));

		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);
			
			System.out.print(vo.getNum() + "\t");
			System.out.print(vo.getStrname() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMath() + "\t");
			System.out.print(vo.getSci() + "\t");
			System.out.print(vo.getHis() + "\t");

			System.out.print(vo.getTotal() + "\t");
			System.out.print(vo.getAvg() + "\n");
		}
		this.printAllList();

	}

	public void printAllList() { // 각 리스트의 합
		int totalKor = 0;
		int totalEng = 0;
		int totalMath = 0;
		int totalSci = 0;
		int totalHis = 0;

		int allTotal = 0;
		float allAvg = 0;

		System.out.println("-".repeat(line));
		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);

			totalKor += vo.getKor();
			totalEng += vo.getEng();
			totalMath += vo.getMath();
			totalSci += vo.getSci();
			totalHis += vo.getHis();

			allTotal += vo.getTotal();
			allAvg += (float)vo.getAvg() / scoreList.size();

		}
		System.out.print(scoreList.size() + "\t");
		System.out.print("총점\t");
		System.out.print(totalKor + "\t");
		System.out.print(totalEng + "\t");
		System.out.print(totalMath + "\t");
		System.out.print(totalSci + "\t");
		System.out.print(totalHis + "\t");

		System.out.print(allTotal + "\t");
		System.out.print(allAvg + "\n");
	}
}
