package com.eomcs;

import java.util.Date;
import java.util.Scanner;

//01. main(): 프로그램 entry point
//02. 사용자로부터 명령어 입력 받기
//03. 사용자로부터 계속 명령어 입력 받기
//04. quit 명령어를 입력 받았을 때 반복 종료하기
//05. 명령어 별로 실행을 분기하기
//06. 게시글 입력 받기
//07. 배열을 이용하여 여러 개의 게시글 보관하기
//08. 상수(final 변수)를 이용하여 배열의 크기를 다루기
//09. 게시글 목록 출력하기
//10. 게시글 상세 조회
//11. 게시글 조회수 추가하기
//12. 게시글 등록일 추가하기
//13. 게시글 변경하기
//14. 게시글 삭제하기
//15. 메서드 문법을 이용하여 기능 별로 명령어를 묶어 관리하기
//16. 클래스를 이용하여 새 데이터타입을 정의하기

public class App {
	public static void main(String[] args) {
		
		final int BOARD_LENGTH = 3;
		String[] titles = new String[BOARD_LENGTH];
		String[] contents = new String[BOARD_LENGTH];
		String[] passwords = new String[BOARD_LENGTH];
		int[] viewCounts = new int[BOARD_LENGTH];
		Date[] createdDates = new Date[BOARD_LENGTH];
		
		int size = 0;
	
		System.out.println("[게시판]");
		
		Scanner keyScan = new Scanner(System.in);
		
	loop: while (true) {
			
		System.out.printf("명령> ");
		String typing = keyScan.nextLine();
		
		int index = 0;
		
		switch (typing) {
		case "list":
			System.out.println("<게시물 목록>");
			
			for (int i = 0; i < size; i++) {
				System.out.printf("%d, %s %d\n", i, titles[i],viewCounts[i]);
			}
			
			break;
		
		case "add":
			System.out.println("<게시물 등록>");
			
			if (size == BOARD_LENGTH) {
				System.out.println("더 이상 게시글을 추가할 수 없습니다.");
				break;
			}
			
			System.out.println("제목: ");
			titles[size] = keyScan.nextLine();
			
			System.out.println("내용: ");
			contents[size] = keyScan.nextLine();
			
			System.out.println("비밀번호: ");
			passwords[size] = keyScan.nextLine();
			
			createdDates[size] = new Date();
			
			System.out.println("게시글을 등록했습니다.");
			
			size++;
			
			break;
			
		case "update":
			System.out.println("<게시물 변경>");
			System.out.print("번호? ");
			index = Integer.parseInt(keyScan.nextLine());
			
			if (index < 0 || index >= size) {
				System.out.println("무효한 게시글 번호입니다.");
				break;
			}
			
			System.out.printf("제목(%s)?", titles[index]);
			String title = keyScan.nextLine();
			
			System.out.printf("내용(%s)? ", contents[index]);
	        String content = keyScan.nextLine();
	        
	        System.out.print("정말로 변경하시겠습니까?(y/N)");
	        if (!keyScan.nextLine().equals("y")) {
	        	System.out.println("게시글 변경을 취소하였습니다.");
	        	break;
	        }
	        
	        titles[index] = title;
	        contents[index] = content;
			
		case "delete":
			System.out.println("<게시물 삭제>");
			break;	
			
		case "view":
			System.out.println("<게시물 조회>");
			System.out.print("번호? ");
			index = Integer.parseInt(keyScan.nextLine());
			
			if (index < 0 || index >= size) {
				System.out.println("무효한 게시글 번호입니다");
				break;
			}	
			
			viewCounts[index]++;
			
			System.out.printf("제목: %s\n", titles[index]);
			System.out.printf("내용: %s\n", contents[index]);
			System.out.printf("조회수: %d\n", viewCounts[index]);
			System.out.printf("등록일 : %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", createdDates[index]);
			
			break;	
		
		case "quit" :
			break loop;
		
		default:
			System.out.println("xX 잘못된 명령입니다 Xx");
		}

	}
		
	keyScan.close();
	
	System.out.println("안녕히 가세요!");
		
	}
}
