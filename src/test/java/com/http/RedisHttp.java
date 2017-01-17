package com.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@WebServlet(name="RedisHttp", urlPatterns={"/RedisHttp"})
public class RedisHttp extends HttpServlet {

	private static final long serialVersionUID = -8821788920272882642L;

	
	private static JedisPool pool;
	private static final int MAX_TOTAL = 100;
	private static final int MAX_IDELE = 5;
	private static final int MAX_WAIT_MILLIS = 1000;
	
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 6379;
	private static final int MAX_TIMEOUT = 6666;
	
	int sum = 0;
	
	public synchronized static JedisPool getPool(){
		if(null == pool){
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_TOTAL);
			config.setMaxIdle(MAX_IDELE);
			config.setMaxWaitMillis(MAX_WAIT_MILLIS);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
			pool = new JedisPool(config,HOST,PORT,MAX_TIMEOUT);
		}
		return pool;
	}
	
    public synchronized static String set(final String key, final String value){
        if(null != pool){
        	Jedis jedis = null;
        	try {
                jedis = getPool().getResource();
                jedis.set(key, value);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(null != jedis) {
                	jedis.close();
                }
            }
        }
		return value;
        
    }
    
    public synchronized static String get(final String key){
        Jedis jedis = null;
        String value = null;
        try {
            jedis = getPool().getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != jedis) {
            	jedis.close();
            }
        }
        return value;
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RedisHttp.set("fuck", "ffff");
		System.out.println(RedisHttp.get("fuck") + sum++);
		
		resp.getWriter().print("ok");
	}
	
}
