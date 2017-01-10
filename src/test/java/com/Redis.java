package com;

import com.util.RedisUtil;

public class Redis {
	
	public static void main(String[] args) {
		
		for(int i = 0;i <= 100;i++){
			RedisUtil.set("fuck", "fffff");
			System.out.println(RedisUtil.get("fuck")+i+"次");
		}
		
	}
	
}
