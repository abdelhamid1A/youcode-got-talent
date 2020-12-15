package com.method.YoucodeGotTalent;

import java.util.Random;

public class Methods {
	public Long randomId() {
		Random r = new Random();
		Long id =Math.abs(r.nextLong());
		return id;
	}
}
