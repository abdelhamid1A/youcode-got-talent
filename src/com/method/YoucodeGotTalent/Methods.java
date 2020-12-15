package com.method.YoucodeGotTalent;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
	public Long randomId() {
		Random r = new Random();
		Long id =Math.abs(r.nextLong());
		return id;
	}
	public static void validateEmail(String email) {
		Pattern p = Pattern.compile ("^([a-zA-Z-_])+@(gmail||outlook||yahoo)\\.([a-z]{2,3})$");
		Matcher m = p.matcher (email );
		boolean mat = m.matches();
		if(mat) {
			System.out.println("correct");
		}else {
			System.out.println("eror");
		}
	}
	public static void validatePhone(String phone) {
		Pattern p = Pattern.compile ("^(\\+2126)\\d{8}");
		Matcher m = p.matcher (phone);
		boolean mat = m.matches();
		if(mat) {
			System.out.println("correct");
		}else {
			System.out.println("eror");
		}
	}
}
