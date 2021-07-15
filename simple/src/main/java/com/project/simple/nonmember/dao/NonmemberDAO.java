package com.project.simple.nonmember.dao;

import org.springframework.dao.DataAccessException;

import com.project.simple.nonmember.vo.NonmemberVO;

public interface NonmemberDAO {

	public NonmemberVO nonmemberorderById(NonmemberVO nonmemberVO)throws DataAccessException;

}
