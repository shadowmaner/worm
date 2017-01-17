package com.http;

public class Task1 {
	static int sum = 0;
	public static void main(String[] args) {
		final long timeInterval = 0;  
        Runnable runnable = new Runnable() { 
            public void run() {  
                while (true) {  
                    System.out.println("Hello !!"); 
                    Thread t = new Thread();
                    System.out.println("Hello !!!"+ t + sum++);
                    
                    try {  
                        Thread.sleep(timeInterval);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        };  
        Thread thread = new Thread(runnable);  
        thread.start();  
	}
}
