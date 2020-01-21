package com.my.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

public class SqlMapConfig {

	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory()	{
		
		//Config.xml 파일 경로
		String resource = "com/my/db/Config.xml";
		
		try {
			//Config.xml 파일의 정보를 읽어온다.
			Reader reader = Resources.getResourceAsReader(resource);
			
			//읽어온 정보를 가지고 SqlSessionFactory 객체 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);	//reader에 있는 값을 읽어옴?
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
	
}