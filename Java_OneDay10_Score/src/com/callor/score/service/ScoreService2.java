package com.callor.score.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreService2 extends ScoreService {

	public ScoreService2() { // 변수 초기화
		// TODO Auto-generated constructor stub

		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
		line = 80;

	}

	public void inputScore() { //학생별 성적리스트
		// TODO Auto-generated method stub
		super.inputScore();

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
		Integer kor = this.inputScore("국어"); // inputScore(매개변수) 호출을 하면 inputScore(매개변수)의 return 값을 넘겨준다.
		if (kor == null) {
			return; // void에서 리턴값을 쓰지않아도 되지만 쓰는 이유는
					// kor == null인경우 아무것도 실행시키지 않고 select로 다시 보내기 위한 것
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

}
