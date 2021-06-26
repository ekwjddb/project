package com.project.simple.board.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.project.simple.board.vo.ArticleVO;


@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	//notice�Խ���
	@Override
	public List<ArticleVO> selectAllNoticeList() throws DataAccessException {
		List<ArticleVO> noticeList = sqlSession.selectList("mapper.board.selectAllNoticeList");
		return noticeList;
	}
	
	@Override
	public ArticleVO selectNotice(int noticeNum) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNotice", noticeNum);
	}
	
	//question �Խ���
	@Override
	public List<ArticleVO> selectAllQuestionList() throws DataAccessException {
		List<ArticleVO> questionList = sqlSession.selectList("mapper.board.selectAllQuestionList");
		return questionList;
	}
	
	//inquiry �Խ���
	@Override
	public List<ArticleVO> selectAllInquiryList(String memId) throws DataAccessException {
		List<ArticleVO> inquiryList = sqlSession.selectList("mapper.board.selectAllInquiryList",memId);
		return inquiryList;
	}

}	
