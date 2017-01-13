package com.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年12月22日
 */
public final class RedisUtil {
	
	private static JedisPool pool = null;

	private static final String HOST = "127.0.0.1";
	private static final int PORT = 6379;
//	private static final String PASS ="gofucking";
	
	
	public static JedisPool getPool(){
		if(pool == null){
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(100);
			config.setMaxIdle(5);
			config.setMaxWaitMillis(1000);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
			pool = new JedisPool(config,HOST,PORT,6666);
		}
		return pool;
	}
	
	
    public static String get(String key){
        Jedis jedis = null;
        String value = null;
        try {
            jedis = getPool().getResource();
            value = jedis.get(key);
        } catch (Exception e) {
        	jedis.close();
            e.printStackTrace();
        } finally {
            if(null != jedis) {
            	jedis.close();        
            }
        }
        return value;
    }
    
    
    public static String set(String key,String value){
        Jedis jedis = null;
        try {
            jedis = getPool().getResource();
            return jedis.set(key, value);
        } catch (Exception e) {
        	jedis.close();
            e.printStackTrace();
            return "exp";
        } finally {
            if(null != jedis) {
            	jedis.close();        
            }
        }
    }
    
    
    
}