package com.project.simple.board.vo;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import org.springframework.stereotype.Component;


@Component("articleVO")

public class ArticleVO {
	//notice �Խ���
	private int noticeNum;
	private Date noticeDate;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContent;
	private String noticeImg;

	//question �Խ���
	private int questionNum;
	private String questionTitle;
	private String questionContent;
	
	//notice �Խ���
	public ArticleVO() {
		System.out.println("ArticleVO ������");
	}
	
	public int getNoticeNum() {
		return noticeNum;
	}
	
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	
	public Date getNoticeDate() {
		return noticeDate;
	}
	
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle= noticeTitle;
	}
	
	public String getNoticeWriter() {
		return noticeWriter;
	}
	
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	
	public String getNoticeContent() {
		return noticeContent;
	}
	
	public void noticeContentt(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	public String getNoticeImg() {
		try {
			if(noticeImg != null & noticeImg.length() !=0) {
				noticeImg = URLDecoder.decode(noticeImg, "utf-8");
			}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
			return noticeImg;
		}
	
	public void setNoticeImg(String noticeImg) {
		try {
			if(noticeImg != null && noticeImg.length() !=0) {
				this.noticeImg = URLEncoder.encode(noticeImg, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	//question �Խ���
	public int getQuestionNum() {
		return questionNum;
	}
	
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	
	public String getQuestionContent() {
		return questionContent;
	}
	
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}


}
