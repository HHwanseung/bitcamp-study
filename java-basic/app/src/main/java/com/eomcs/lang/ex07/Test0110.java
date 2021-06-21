package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Test0110 {

  static void printSpaces(int len) {

    for (int i = 0; i <= len; i++) {
      System.out.print(" ");
    }

  }

  static void printStars(int len) {
    for (int j = 1; j <= len; j++) {
      System.out.print("*");
    }

  }

  static int getSpacesLength(int totalStar, int displayedStar ) {
    return (totalStar - displayedStar) / 2;
  }
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();


    for (int starLen = 1; starLen <= len; starLen += 2) {
      // 출력할 스페이스의 개수를 계산하는 코드를 
      // 블록에 묶어 놓고 이름을 부여해두고 사용하면
      // 코드를 이해하기가 더 쉽다.
      printSpaces(getSpacesLength(len, starLen));
      printStars(starLen);
      System.out.println();
    }
    keyScan.close();
  }
}