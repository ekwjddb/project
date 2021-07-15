package com.project.simple.nonmember.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


import com.project.simple.nonmember.vo.NonmemberVO;



@Repository("nonmemberDAO")
public class NonmemberDAOImpl implements NonmemberDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public NonmemberVO nonmemberorderById(NonmemberVO nonmemberVO) throws DataAccessException {
		NonmemberVO vo = sqlSession.selectOne("mapper.nonmember.nonmemberorderById", nonmemberVO);
		return vo;
	}

}
