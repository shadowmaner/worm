package com;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

//test
public class Test {
	
    
    public static void main(String[] args) {
    	int aaa = 415613;
    	String bbb =  "gjrioeasgj";
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("aaa", aaa);
    	map.put("bbb", bbb);
    	
    	
    	System.out.println(new Gson().toJson(map));
    }
    
	
}
	
