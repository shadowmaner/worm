package com;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Redis {
	private static JedisPool pool;

	private static final String HOST = "127.0.0.1";
	private static final int PORT = 6379;
	
	public static void main(String[] args) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000);
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);
		pool = new JedisPool(config,HOST,PORT,6666);
		
		Jedis jedis = pool.getResource();
		
		System.out.println(jedis.set("fuck", "ffff"));
	}
	
}
