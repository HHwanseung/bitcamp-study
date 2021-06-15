package com.eomcs.lang.ex05;

//# 비트 연산자 : 응용 II
//
public class Test01 {
  public static void main(String[] args) {
    // Yes/No 또는 true/false 값을 저장할 때
    // 비트 연산자를 사용하면 메모리를 절약할 수 있다.

    // 비트 연산자 사용 전
    // => 각각의 상태를 별도의 변수에 저장해야 한다.
    // => 8개의 데이터를 저장하기 위해 32바이트가 소요된다.
    boolean c, cpp, java, js, python, php, html, css;
    c = true;
    cpp = false;
    java = true;
    js = false;
    python = true;
    php = false;
    html = true;
    css = false;

    // => 물론 배열을 이용할 수 있다.
    //    boolean 배열을 JVM에서 다룰 때는 각 boolean에 대해
    //    1바이트를 사용한다.
    // => 따라서 8개의 데이터를 저장하기 위해 8바이트를 사용한다.
    boolean[] lang = new boolean[8];
    lang[0] = true;
    lang[1] = false;
    lang[2] = true;
    lang[3] = false;
    lang[4] = true;
    lang[5] = false;
    lang[6] = true;
    lang[7] = false;

    // 비트 연산자 사용 후
    // => 4바이트 변수 한 개만 있으면
    //    최대 32개의 데이터를 저장할 수 있다.
    // 어떻게?
    int lang2 = 0;
    // 00000000 00000000 00000000 00000000

    // 32비트에서 뒤에 8비트를 사용하여 8개의 true/false 값을 저장할 수 있다.
    // 8 비트에서 각 언어에 값을 저장할 비트를 다음과 같다고 가정하자.
    // 00000000
    // ||||||||- css
    // |||||||- html
    // ||||||- php
    // |||||- python
    // ||||- javascript
    // |||- java
    // ||- c++
    // |- c

    final int LANG_C      = 0b10000000;
    final int LANG_CPP    = 0b01000000;
    final int LANG_JAVA   = 0b00100000;
    final int LANG_JS     = 0b10010000;
    final int LANG_PYTHON = 0b10001000;
    final int LANG_PHP    = 0b10000100;
    final int LANG_HTML   = 0b10000010;
    final int LANG_CSS    = 0b10000001;

    lang2 |= LANG_C;
    lang2 |= LANG_JAVA;
    lang2 |= LANG_PYTHON;
    lang2 |= LANG_HTML;
    System.out.println(Integer.toBinaryString(lang2));

    lang2 = LANG_C | LANG_JAVA | LANG_PYTHON | LANG_HTML;
    System.out.println(Integer.toBinaryString(lang2));

    lang2 = lang2 - LANG_JAVA;
    System.out.println(Integer.toBinaryString(lang2));
  }
}
