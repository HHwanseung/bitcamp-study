package com.eomcs.lang.ex07;

public class Test0250 {

	public static void hello(String...name) {
		for(int i = 0; i < name.length; i++) {
			System.out.printf("%s님 반갑습니다! ", name[i]);
		}
	}
	public static void main(String[] args) {
		hello("최한빛");
		System.out.println("-----------");
		hello("최한빛" , "이승환");
		System.out.println("---------------");
		hello("최한빛", "이승환", "남승범");
		System.out.println("---------------");
		
		String[] arr = {"최한빛", "이승환","남승범"};
		hello(arr);
		
	}
}
  