package com.capgemini.lessys.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testt {

	public static void main(String[] args) {
		String s="1234";

		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(s);
		if( !isNum.matches() ){
		
		}else{
			
		}
		
		}
}

	
