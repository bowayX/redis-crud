package com.alone.mapper;

public interface IUserMapper {
	public Integer registerRedis();
	public Integer registerMysql();
	public Integer loginRedis();
	public Integer loginMsyql();
}
