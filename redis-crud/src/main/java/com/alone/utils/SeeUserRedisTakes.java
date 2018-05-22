package com.alone.utils;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alone.entity.UserBean;

@Component("seeUserRedisTakes")
public class SeeUserRedisTakes implements RedisBaiseTackes<String, String, UserBean> {
	@Resource(name="redisTemplate")
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean add(String key, String value) {
        if(redisTemplate==null){
            return false;
        }else{
           redisTemplate.opsForValue().set(key,value);
        }
        return true;
    }

    @Override
    public boolean addObj(String objectKey, String key, UserBean object) {
        if(redisTemplate==null){
            return false;
        }else{
            redisTemplate.opsForHash().put(objectKey,key,object);
        }
        return true;
    }

	@Override
	public boolean delete(String key) {
		if(redisTemplate==null){
            return false;
        }
//        redisTemplate.opsForHash().delete(key);
        redisTemplate.delete(key);
		return true;
	}

	@Override
	public boolean delete(List<String> listKeys) {
		return false;
	}

	@Override
	public boolean deleteObj(String object, String key) {
		return false;
	}

	@Override
	public boolean update(String key, String value) {
		if(redisTemplate==null){
            return false;
        }
        //redisTemplate.rename(key, value);
        redisTemplate.opsForValue().set(key,value);
		return true;
	}

	@Override
	public boolean updateObj(String objectKey, String key, UserBean object) {
		return false;
	}

	@Override
    public String get(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }

    @Override
    public UserBean getObj(String objectKey, String key) {
    	UserBean seeUser = (UserBean) redisTemplate.opsForHash().get(objectKey,key);
        return seeUser;
    }
 
	@Override
	public boolean checkKey(String key) {
		if(redisTemplate==null){
            return false;
        }else{
        	Object object = redisTemplate.opsForValue().get(key);
        	System.out.println("check         " + object);
        	if (null==object) {
        		return false;
        	}
        	return true;
        }
	}
}
