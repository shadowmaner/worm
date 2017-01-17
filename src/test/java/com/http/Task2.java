package com.http;

import java.util.Timer;
import java.util.TimerTask;

public class Task2 {
	static int sum = 0;
	public static void main(String[] args){
		TimerTask task = new TimerTask() {  
            @Override  
            public void run() {  
            	Thread t = new Thread();
                System.out.println("Hello !!!"+ t + sum++);
            }  
        };  
        Timer timer = new Timer();  
        long delay = 0;  
        long intevalPeriod = 1 * 1;  
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);  
	}
}
	
