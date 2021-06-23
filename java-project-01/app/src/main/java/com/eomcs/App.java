package com.eomcs;

import java.util.Date;
import java.util.Scanner;

public class App {

  // 한 개의 게시글을 담을 복합 데이터의 변수를 설계
  static class Board {
    String title;
    String content;
    String password;
    int viewCount;
    Date createdDate;
  }

  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {

    // App 클래스에서 만든 Scanner 인스턴스를 BoardHandler 와 같이 쓴다.
    BoardHandler.keyScan = keyScan;

    System.out.println("[게시판 관리]");

    loop: while (true) {
      System.out.print("명령> ");
      String command = keyScan.nextLine();

      switch (command) {
        case "list": BoardHandler.list(); break; //class.메소드명
        case "add": BoardHandler.add(); break;
        case "update": BoardHandler.update(); break;
        case "delete": BoardHandler.delete(); break;
        case "view": BoardHandler.view(); break;
        case "quit":
          break loop;
        default:
          System.out.println("지원하지 않는 명령입니다.");
      }
    }

    keyScan.close();

    System.out.println("안녕히 가세요!");
  }

}