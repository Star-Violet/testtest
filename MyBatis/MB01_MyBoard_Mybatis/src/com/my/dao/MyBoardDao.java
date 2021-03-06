﻿package com.my.dao;

import java.util.List;
import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;

import com.my.vo.MyBoardVo;

public class MyBoardDao extends SqlMapConfig {	//객체생성 하지말고 상속을 받음(내것처럼 쓸 수 있음)

	private String namespace="com.my.myboard.";	//Mapper.xml에서 확인
												//aa.selectAll 이런식으로 가져올 수 있음. bb.selectAll 등 여러개를 만들어서 쓸 수 있음
	public List<MyBoardVo> selectAll(){
		List<MyBoardVo> res = new ArrayList<>();
		
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		//opensession(true) : true -> autoCommit, false -> autoCommit X		
		res = session.selectList(namespace+"selectAll");	//실행할 쿼리문+selectAll id를 가진 태그를 가지고 와서 
								//com.my.myboard.selectAll

		return res;
	}
	
	public MyBoardVo selectOne(int myno) {
		SqlSession session = null;
		MyBoardVo res = null;
		
		session = getSqlSessionFactory().openSession(true);
		
		res = session.selectOne(namespace+"selectOne", myno);
		
		session.close();
		
		return res;
	}
	
	public int insert(MyBoardVo vo) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace+"myinsert", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
}