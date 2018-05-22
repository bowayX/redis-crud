package com.alone.utils;

import java.util.List;

public interface RedisBaiseTackes<H,K,V> {
	//增加
	public boolean add(K key,String value);
	public boolean addObj(H objectKey,K key,V object);
	//删除
	public boolean delete(K key);
	public boolean delete(List<K> listKeys);
	public boolean deleteObj(H object,K key);
	//修改
	public boolean update(K key,String value);
	public boolean updateObj(H objectKey,K key,V object);
	//查询
	public String get(K key);
	public V getObj(H ObjectKey,K key);
	
	//校验
	public boolean checkKey(K key);
}
