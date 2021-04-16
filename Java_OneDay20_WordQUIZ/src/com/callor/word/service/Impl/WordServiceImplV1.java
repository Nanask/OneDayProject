package com.callor.word.service.Impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.WordVO;
import com.callor.word.service.WordService;

public class WordServiceImplV1 implements WordService {

	Scanner scan;
	List<WordVO> wordList;
	Random rnd;

	protected final int 영어 = 0;
	protected final int 한글 = 1;
	
	int point = 0;

	public WordServiceImplV1() {
		scan = new Scanner(System.in);
		wordList = new ArrayList<WordVO>();
		rnd = new Random();
		

		this.loadWord();

	}

	@Override
	public void selectMenu() {
		// TODO 메뉴
		while (true) {
			System.out.println("=".repeat(80));
			System.out.println("괴도 뤼팡의 영단어 퀴즈");
			System.out.println("-".repeat(80));
			System.out.println("1.게임시작");
			System.out.println("2.게임불러오기");
			System.out.println("3.게임저장하기");
			System.out.println("Quit.게임종료");
			System.out.println("=".repeat(80));
			System.out.print(">> ");
			String strMenu = scan.nextLine();
			if (strMenu.equalsIgnoreCase("Quit"))
				return;
			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (intMenu == 1) {
				this.viewWord();
			} else if (intMenu == 2) {
				this.loadUser();
				this.viewWord();
				
			} else if (intMenu == 3) {
				this.saveWord();
			}
		}
	}

	@Override
	public void loadWord() {

		String wordFile = "src/com/callor/word/word.txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(wordFile);
			buffer = new BufferedReader(fileReader);

			while (true) {
				String reader = buffer.readLine();
				if (reader == null)
					break;

				String word[] = reader.split(":");
				WordVO vo = new WordVO();

				vo.setEnglish(word[영어]);
				vo.setKorea(word[한글]);
				wordList.add(vo);
//				System.out.println(vo.toString());

			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 여는 도중 문제가 발생했습니다.");
		} catch (IOException e) {
			System.out.println("데이터를 읽는 중 문제가 발생했습니다.");
		}

	}

	@Override
	public void viewWord() {
		// TODO 알파벳 배열맞추기 문제
		
		while (true) {
			int nCount = 3;
			WordVO vo = this.getWord();
			String strEng = vo.getEnglish();
			String[] strWord = strEng.split("");

			for (int i = 0; i < 100; i++) {

				int num1 = rnd.nextInt(strWord.length);
				int num2 = rnd.nextInt(strWord.length);

				String temp = strWord[num1];
				strWord[num1] = strWord[num2];
				strWord[num2] = temp;
			}
			while (true) {
				
				System.out.println("=".repeat(80));
				System.out.println("제시된 영 단어를 바르게 배열하시오(종료 : Quit)");
				System.out.println("-".repeat(80));
				System.out.println(Arrays.toString(strWord)); //영단어 보여주기
				System.out.println("-".repeat(80));
				System.out.println("힌트 : Hint  , 다음문제 : Next" );
				System.out.print(">> ");
				String strInput = scan.nextLine();
				if (strInput.equals("Hint")) {
					System.out.println("힌트");
				}
				if (strInput.equals("Next")) {
					return;
				}
				if (strInput.equals("Quit")) {
					return;
				} else if (strInput.equalsIgnoreCase(vo.getEnglish())) {
					System.out.println("정답입니다");
					System.out.println("point 1점을 획득합니다");
					point++;
					System.out.printf("현재까지 point는 %d 입니다\n", point);

					break;
				} else if (nCount < 1) {
					System.out.printf("정답은 %s뜻을 가진 %s입니다.",vo.getKorea(),vo.getEnglish());
					System.out.println("다음 문제로 넘어갑니다");
					break;
				} else if (0 < nCount || nCount < 2) {
					System.out.printf("틀렸습니다. 기회는 %d번!\n", nCount-- );
					System.out.println("point 1점을 잃었습니다");
					point--;
					
				}
				
				System.out.printf("현재까지 point는 %d 입니다\n", point);
				
			} // 안쪽 while end
		} // 바깥 while end

	}
	
	@Override
	public void loadUser() {
		// TODO 유저포인트 불러오기 
		
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		System.out.println("이름을 입력해주세요");
		System.out.print(">> ");
		String name = scan.nextLine(); //이름받기
		
		String fileName = "src/com/callor/word/" + name + ".txt";
		Integer intReader = null;
		
		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);
			
			String reader = null;
			
			reader = buffer.readLine(); //한 줄을 읽는다
			point = Integer.valueOf(reader);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	@Override
	public void hintWord() {
		// TODO Auto-generated method stub

	}

	protected WordVO getWord() {

		Random rnd = new Random();

		int nSize = wordList.size();
		int num = rnd.nextInt(nSize);

		WordVO vo = wordList.get(num);
		System.out.println(vo.toString());

		return vo;
	}

	@Override
	public void saveWord() {
		// TODO 저장하기
		
		FileWriter fileWriter = null;
		PrintWriter out = null;
		
		System.out.println("게임저장");
		System.out.println("저장할 파일이름을 입력하세요");
		System.out.print(">> ");
		String strName = scan.nextLine();
		if(strName.equals("")) {
			System.out.println("파일이름은 반드시 입력해야 합니다");
		}
		
		String fileName = "src/com/callor/word/" + strName + ".txt";
		
		try {
			fileWriter = new FileWriter(fileName);
			out = new PrintWriter(fileWriter);
			
			out.print(point);
			
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
