package com.eomcs.lang.oop.overview.step02;

import java.util.Date;
import java.util.Scanner;

public class App {

	static final int BOARD_LENGTH = 100;	
	static String[] titles = new String[BOARD_LENGTH];
	static String[] contents = new String[BOARD_LENGTH];
	static String[] passwords = new String[BOARD_LENGTH];
	static int[] viewCounts = new int[BOARD_LENGTH]; // new로 만드는 변수는 기본적으로 0으로 초기화 됌
	static Date[] createdDates = new Date[BOARD_LENGTH];
	static int size = 0;
	static Scanner keyScan = new Scanner(System.in);
		
	public static void main(String[] atgs) {
		
	System.out.println("[게시판 관리]");
		
	loop: while (true) {
		System.out.println("명령> ");
		String command = keyScan.nextLine();
		
		int index = 0;
		
		switch (command) {
			case "list" : list(); break;
			case "add" : add(); break;
			case "update" : update(); break;
			case "delete" : delete(); break;
			case "view" : view(); break;
			case "quit" : break loop;
			default:
				System.out.println("지원하지 않는 명렵입니다.");
		}
	}

	keyScan.close();
	
	System.out.println("안녕히 가세요!");
	}
	
	static void list() {
		System.out.println("[게시글 목록]");
		
		for (int i =0; i < size; i++) {
			System.out.printf("%d, %s, %s, %d\n", 
				i, 
				titles[i],
				String.format("%1$tY-%1$tm-%1$td", createdDates[i]), 
				viewCounts[i]);
		}
		
	}
	static void add() {
		System.out.println("[게시글 등록]");
		
		if (size == BOARD_LENGTH) {
			System.out.println("더 이상 게시글을 추가할 수 없습니다.");
			return;
		}
		
		System.out.println("제목: ");
		titles[size] = keyScan.nextLine();
		
		System.out.println("내용: ");
		contents[size] = keyScan.nextLine();
		
		System.out.println("비밀번호: ");
		passwords[size] = keyScan.nextLine();
		
		createdDates[size] = new Date(); // 현재 날짜, 시간을 생성하여 배열에 저장
		
		System.out.println("게시글을 등록했습니다.");
			
		size++;
	}
	
	static void update() {
		System.out.println("[게시글 변경]");
		
		System.out.print("번호? ");
		int index = Integer.parseInt(keyScan.nextLine());
		
		if (index < 0 || index >= size) {
			System.out.println("무효한 게시글 번호입니다.");
			return;
		}
		
		System.out.printf("제목(%s?) ", titles[index]);
		String title = keyScan.nextLine();
		
		System.out.printf("내용(%s?) ", contents[index]);
		String content = keyScan.nextLine();
		
		System.out.print("정말 변경하시겠습니까?(y/N) ");
		if (!keyScan.nextLine().equals("y")) {
			System.out.println("게시글 변경을 취소하였습니다. ");
			
			titles[index] = title;
			contents[index] = content;
			
			System.out.println("게시글을 변경을 취소하였습니다.");
			
			
			return;
	}
	
	static void delete() {
		System.out.println("[게시글 삭제]");
		
		System.out.print("번호? ");
		int index = Integer.parseInt(keyScan.nextLine());
		
		if (index < 0 || index >= size) {
			System.out.println("무효한 게시글 번호입니다.");
			break;
		}
			
		System.out.print("정말 삭제하시겠습니까?(y/N) ");
		if (!keyScan.nextLine().equals("y")) {
			System.out.println("게시글 삭제를 취소하셨습니다. ");
			break;
			
			for (int i = index; i < size - 1; i++) {
				titles[i] = titles[i + 1];
				contents[i] = contents[i + 1];
				viewCounts[i] = viewCounts[i + 1];
				createdDates[i] = createdDates[i + 1];
				
			}
			
			size--;
			
			System.out.println("게시글을 삭제하셨습니다.");
			
			return;
	}
	
	static void view() {
		System.out.println("[게시글 조회]");
		
		System.out.print("번호? ");
		int index = Integer.parseInt(keyScan.nextLine());
		
		if (index < 0 || index >= size) {
			System.out.println("무효한 게시글 번호입니다.");
		return;
		}
	
		viewCounts[index]++;
		
		System.out.printf("제목: %s\n", titles[index]);
		System.out.printf("내용: %s\n", contents[index]);
		System.out.printf("조회수: %d\n", viewCounts[index]);
		System.out.printf("등록일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", createdDates[index]);
		
	}
}
