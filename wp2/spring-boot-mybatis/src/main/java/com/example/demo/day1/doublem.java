package com.example.demo.day1;

import java.util.ArrayList;
import java.util.Random;

public class doublem {

	private static int maxNum=10;//实例个数
	private static ArrayList<doublem> list=new ArrayList<>();//饿汉模式
	//private static ArrayList<doublem> list;  //懒汉模式
	private doublem(){
		
	}
	static{
		for(int i=0;i<maxNum;i++){
			doublem tt=new doublem();
			list.add(tt);
		}
	}
	public static doublem getInstant(){
		//这是饿汉模式    懒汉模式加一个空值判断
		Random random=new Random();
		int i=random.nextInt(maxNum);
		System.out.println(i);
		doublem t=list.get(i);
		return t;
	}
	
}
