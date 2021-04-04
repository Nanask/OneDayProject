package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreService {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	int line;

	public ScoreService() {//변수 초기화
		// TODO Auto-generated constructor stub

		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
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

	public void inputScore() { //성적계산

		
		int num = 0;
		String strName = "";
		String Kor = "";
		String Eng = "";
		String Math = "";
		String His = "";
		String Sic = "";
//		Integer Sic = 0;
		int total = 0;
		float Avg = 0;

		int intKor = 0;
		int intEng = 0;
		int intMath = 0;
		int intHis = 0;
		int intSic = 0;

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

		num = scoreList.size() + 1; // 배열의 시작값에 1을 더하라 / 배열이 정해지지 않았기 때문에 0이므로
		
		System.out.println("=".repeat(line));
		System.out.println(num + "번 " + strName + "학생의 성적을 입력하세요(성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT)");
		System.out.println("-".repeat(line));

//		while (true) {
//			try {
//				System.out.print("국어 >> ");
//				Kor = scan.next();
//
//				if (Kor.equals("QUIT")) {
//					return;
//				} else { // QUIT를 입력하지 않았다면 문자열 Kor을 정수형으로 변환시켜라
//					intKor = Integer.valueOf(Kor);
//
//					if (intKor < 0 || intKor > 100) {
//						System.out.println("성적범위는 0 ~ 100까지 입니다");
//						continue;
//					}
//				} // else end
//
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("숫자만 입력하세요");
//				continue;
//			}
//			break;
//		}
		while (true) {
			System.out.print("국어 >> ");
			Kor = scan.nextLine();
			if (Kor.equals("QUIT")) {
				return;
			}
			try {
				intKor = Integer.valueOf(Kor); // 문자열His를 정수형으로 변환하겠다

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자만 입력하세요");
				continue;
			}
			if (intKor < 0 || intKor > 100) {
				System.out.println("성적범위는 0 ~ 100까지 입니다");
				continue;
			}
			break;
		}

		while (true) {
			System.out.print("영어 >> ");
			Eng = scan.nextLine();
			if (Eng.equals("QUIT")) {
				return;
			}
			try {
				intEng = Integer.valueOf(Eng); // 문자열His를 정수형으로 변환하겠다

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자만 입력하세요");
				continue;
			}
			if (intEng < 0 || intEng > 100) {
				System.out.println("성적범위는 0 ~ 100까지 입니다");
				continue;
			}
			break;
		}

		while (true) {
			System.out.print("수학 >> ");
			Math = scan.nextLine();
			if (Math.equals("QUIT")) {
				return;
			}
			try {
				intMath = Integer.valueOf(Math); // 문자열His를 정수형으로 변환하겠다

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자만 입력하세요");
				continue;
			}
			if (intMath < 0 || intMath > 100) {
				System.out.println("성적범위는 0 ~ 100까지 입니다");
				continue;
			}
			break;
		}
		while (true) {
			System.out.print("국사 >> ");
			His = scan.nextLine();
			if (His.equals("QUIT")) {
				return;
			}
			try {
				intHis = Integer.valueOf(His); // 문자열His를 정수형으로 변환하겠다

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자만 입력하세요");
				continue;
			}
			if (intHis < 0 || intHis > 100) {
				System.out.println("성적범위는 0 ~ 100까지 입니다");
				continue;
			}
			break;
		}
		while (true) {
			System.out.print("과학 >> ");
			Sic = scan.nextLine();
			if (Sic.equals("QUIT")) {
				return;
			}
			try {
				intSic = Integer.valueOf(Sic); // 문자열His를 정수형으로 변환하겠다

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자만 입력하세요");
				continue;
			}
			if (intSic < 0 || intSic > 100) {
				System.out.println("성적범위는 0 ~ 100까지 입니다");
				continue;
			}
			break;
		}
//		while (true) {
//
//			String strSic = "";
//			System.out.print("과학 >> ");
//			
//			Sic = scan.nextline();
//			strSic = Integer.toString(Sic); // sic인 정수형을 문자열로 변환하겠다.
//
//			if (strSic.equals("QUIT")) {
//				return;
//
//			} else {
//				if (Sic < 0 || Sic > 100) {
//					System.out.println("성적범위는 0 ~ 100까지 입니다");
//					continue;
//				}
//			}
//			break;
//		}

		total = intKor + intEng + intMath + intHis + intSic; // 입력받은 과목들의 합을 score리스트에 묶기위해 total이란 변수를 지정함
		Avg = total / 5;

		ScoreVO scoreVO = new ScoreVO();
		scoreVO.setNum(num);
		scoreVO.setStrname(strName);
		scoreVO.setKor(intKor);
		scoreVO.setEng(intEng);
		scoreVO.setMath(intMath);
		scoreVO.setHis(intHis);
		scoreVO.setSci(intSic);
		scoreVO.setTotal(total);
		// total라는 변수값을 지정하여 성적들의 합을 구함
		scoreVO.setAvg(Avg);

		scoreList.add(scoreVO);
		
		System.out.println("=".repeat(line));
		System.out.println(strName + "학생의 성적이 추가 되었습니다.");
		System.out.println("-".repeat(line));

		System.out.println("국어 >> " + scoreVO.getKor());
		System.out.println("영어 >> " + scoreVO.getEng());
		System.out.println("수학 >> " + scoreVO.getMath());
		System.out.println("국사 >> " + scoreVO.getHis());
		System.out.println("과학 >> " + scoreVO.getSci());
	}

	

	public void printList() { // 각 학생 별 성적 리스트
		

		System.out.println("=".repeat(line));
		System.out.println("순번\t학생\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println("-".repeat(line));

		for (int i = 0; i < scoreList.size(); i++) {

			// scoreList의 i번째 저장된 값을 읽어서 ScoreVO형 sVO 객체에 담기
			ScoreVO vo = scoreList.get(i);

			System.out.print(vo.getNum() + "\t");
			System.out.print(vo.getStrname() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMath() + "\t");
			System.out.print(vo.getSci() + "\t");
			System.out.print(vo.getHis() + "\t");
			System.out.print(vo.getTotal() + "\t");
			System.out.printf("%3.2f\n" ,vo.getAvg());

		}
		this.printAllList();

		
	}
	
	public void printAllList() { // 리스트 총합 구하기

		int totalKor = 0;
		int totalEng = 0;
		int totalMath = 0;
		int totalHis = 0;
		int totalSci = 0;
		int totalAll = 0;
		float totalAvg = (float) 0;
		
		System.out.println("=".repeat(line));

		for (int i = 0; i < scoreList.size(); i++) {

			ScoreVO vo = scoreList.get(i);

			totalKor += vo.getKor();
			totalEng += vo.getEng();
			totalMath += vo.getMath();
			totalHis += vo.getHis();
			totalSci += vo.getSci();
			totalAll += vo.getTotal();
			totalAvg += (float) vo.getAvg() / scoreList.size();

		}

		// scoreList.size()값은 배열의 수가 몇개 있는지 알려주는 것
		System.out.println("=".repeat(line));
		System.out.print(scoreList.size() + "\t");
		System.out.print("총점" + "\t");
		System.out.print(totalKor + "\t");
		System.out.print(totalEng + "\t");
		System.out.print(totalMath + "\t");
		System.out.print(totalSci + "\t");
		System.out.print(totalHis + "\t");
		System.out.print(totalAll + "\t");
		System.out.printf("%3.2f\n" , totalAvg);

	}

}
