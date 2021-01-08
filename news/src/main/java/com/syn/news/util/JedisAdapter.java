package com.syn.news.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Component
public class JedisAdapter implements InitializingBean {

    private JedisPool pool = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化redis");
        pool = new JedisPool("localhost",6379);
    }

    private Jedis getJedis(){
        return pool.getResource();
    }

    public long sadd(String key,String value){
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            return jedis.sadd(key,value);
        }catch (Exception e ){
            System.out.println("Redis异常"+e.getMessage());
            return 0;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public long srem(String key,String value){
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            return jedis.srem(key,value);
        }catch (Exception e ){
            System.out.println("Redis异常"+e.getMessage());
            return 0;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public boolean sismember(String key,String value){
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            return jedis.sismember(key,value);
        }catch (Exception e ){
            System.out.println("Redis异常"+e.getMessage());
            return false;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public long scard(String key){
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            return jedis.scard(key);
        }catch (Exception e ){
            System.out.println("Redis异常"+e.getMessage());
            return 0;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }


    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            System.out.println("发生异常"+e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return getJedis().get(key);
        } catch (Exception e) {
            System.out.println("发生异常" + e.getMessage());
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }



    public void setObject(String key,Object obj){
        set(key, JSON.toJSONString(obj));
    }

    public <T> T getObject(String key,Class<T> clazz){
        String value = get(key);
        if(value!=null){
            return JSON.parseObject(value,clazz);
        }
        return null;
    }


    public long lpush(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.lpush(key, value);
        } catch (Exception e) {
            System.out.println("队列添加异常"+e.getMessage());
            return 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public List<String> brpop(int timeout, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.brpop(timeout, key);
        } catch (Exception e) {
            System.out.println("发生异常" + e.getMessage());
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }



}
