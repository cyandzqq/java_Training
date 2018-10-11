package com.example.demo.day1;

public class single {

	private static single a; //单例对象
    //private static single a=new single();//饿汉模式先实例化
	private static String name;//one对象的属性名
	
	private single(){
		name="cy";//第一次创建对象(用getInstant方法)时给name属性赋值
	}
	
	//初始化块 控制台打印111 由此可知单例创建的次数(1次)
	{
		System.out.println(111);
	}
	
	//用于返回a这个单例  如果为空(即a=null)则new(会调用私有构造器)一个one给他
	public static single getInstant(){
		if(a==null){
			a=new single();
		}
		return a;
		//return a;//饿汉模式直接返回实例a
	}
	
	//控制台显示a的name属性值
	public void showname(){
		System.out.println(name);
	}
	
	//改变a的name属性值
	public void changename(String s){
		a.name=s;
	}
}
