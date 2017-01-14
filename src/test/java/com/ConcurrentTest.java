package com;

import java.util.concurrent.CountDownLatch;

import com.util.RedisUtil;

public class ConcurrentTest {
	
	static int sum = 0;
	
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CountDownLatch cdl = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new MyThread(cdl).run();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static class MyThread implements Runnable {
        private CountDownLatch cdl;

        public MyThread(CountDownLatch cdl) {
            this.cdl = cdl;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            cdl.countDown();
            RedisUtil.set("fuck", "fdsfdsafd");
        	System.out.println(RedisUtil.get("fuck") + sum++);
        }
    }
}
