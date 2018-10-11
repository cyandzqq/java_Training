package com.example.demo.day1;

public class testtwo {

	public static void main(String[] args) {
		//单例模式测试
		/*single.getInstant().showname();
		System.out.println(single.getInstant());
		single.getInstant().changename("zqq");
		single.getInstant().showname();
		System.out.println(single.getInstant());*/
		
		//多例模式
		System.out.println(doublem.getInstant());
		System.out.println(doublem.getInstant());
		System.out.println(doublem.getInstant());
		System.out.println(doublem.getInstant());
		System.out.println(doublem.getInstant());
		System.out.println(doublem.getInstant());
	}
}
