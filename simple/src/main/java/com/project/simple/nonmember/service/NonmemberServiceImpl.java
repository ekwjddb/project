package com.project.simple.nonmember.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.simple.nonmember.dao.NonmemberDAO;
import com.project.simple.nonmember.vo.NonmemberVO;

@Service("nonmemberService")
public class NonmemberServiceImpl implements NonmemberService{
	
	@Autowired
	private NonmemberDAO nonmemberDAO;

	@Override
	public NonmemberVO order_lookup(NonmemberVO nonmemberVO) throws Exception {
		return nonmemberDAO.nonmemberorderById(nonmemberVO);
	}

}
