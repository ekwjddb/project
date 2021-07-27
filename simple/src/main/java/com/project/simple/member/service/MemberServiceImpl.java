package com.project.simple.member.service;


import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.simple.member.dao.MemberDAO;
import com.project.simple.member.vo.MemberVO;
import com.project.simple.page.Criteria;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void find_pw(HttpServletResponse response, MemberVO memberVO) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	
			// 임시 비밀번호 생성
			String memPwd = "";
			for (int i = 0; i < 12; i++) {
				memPwd += (char) ((Math.random() * 26) + 97);
			}
			memberVO.setmemPwd(memPwd);
			// 비밀번호 변경
			memberDAO.update_pw(memberVO);
			// 비밀번호 변경 메일 발송
			send_mail(memberVO, "find_pw");
			
			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
		
	}
	
	// 이메일 발송
		@Override
		public void send_mail(MemberVO memberVO, String div) throws Exception {
			// Mail Server 설정
			String charSet = "utf-8";
			String hostSMTP = "smtp.naver.com";
			String hostSMTPid = "ekwjd8683";
			String hostSMTPpwd = "Dbek4026";

			// 보내는 사람 EMail, 제목, 내용
			String fromEmail = "ekwjd8683@naver.com";
			String fromName = "Spring Homepage";
			String subject = "";
			String msg = "";

			if(div.equals("find_pw")) {

				subject = "Spring Homepage 임시 비밀번호 입니다.";
				msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
				msg += "<h3 style='color: blue;'>";
				msg += memberVO.getmemId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
				msg += "<p>임시 비밀번호 : ";
				msg += memberVO.getmemPwd() + "</p></div>";
			}
			

		
			// 받는 사람 E-Mail 주소
			String mail = memberVO.getmemEmail();
			try {
				HtmlEmail memEmail = new HtmlEmail();
				memEmail.setDebug(true);
				memEmail.setCharset(charSet);
				memEmail.setSSL(true);
				memEmail.setHostName(hostSMTP);
				memEmail.setSmtpPort(587);

				memEmail.setAuthentication(hostSMTPid, hostSMTPpwd);
				memEmail.setTLS(true);
				memEmail.addTo(mail, charSet);
				memEmail.setFrom(fromEmail, fromName, charSet);
				memEmail.setSubject(subject);
				memEmail.setHtmlMsg(msg);
				memEmail.send();
			} catch (Exception e) {
				System.out.println("메일발송 실패 : " + e);
			}
		}
		

	@Override
	public List<MemberVO> listMembers(Criteria cri) throws DataAccessException{
		List<MemberVO> membersList = memberDAO.selectAllMemberList(cri);
		return membersList;
	}
	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}
	
	@Override
	public int addMember_naver(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember_naver(member);
	}
	
	@Override
	public int removeMember(MemberVO removemember) throws DataAccessException{
		return memberDAO.deleteMember(removemember);
	}
	
	//로그인 기능 구현 추가
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberDAO.loginById(memberVO);
	}
	
	//네아로 로그인 기능 구현 추가
		@Override
		public MemberVO login_naver(MemberVO memberVO) throws Exception{
			return memberDAO.loginBynaver(memberVO);
		}
	
	@Override
	public int modMember(MemberVO modmember) throws DataAccessException {
		return memberDAO.updateMember(modmember);
	}
	@Override
	public int memberCount() throws Exception {
		int memberCount = memberDAO.selectMemberCount();
		return memberCount;
	}
	@Override
	public Map<String, Object> memberSearch(Map<String, Object> memberSearchMap) throws Exception {
		List<MemberVO> memberSearchList=memberDAO.memberSearchList(memberSearchMap);

		memberSearchMap.put("memberSearchList", memberSearchList);
		

		return memberSearchMap;
	}
	@Override
	public int memberSearchCount(Map<String, Object> search) throws Exception {
		int memberSearchCount = memberDAO.memberSearchCount(search);
		return memberSearchCount;
	}
	@Override
	public MemberVO admin_removeMember(String memId) throws DataAccessException {
		return memberDAO.deleteMemberlist(memId);

	}
	@Override
	public MemberVO findId(MemberVO memberVO) throws Exception {
		return memberDAO.find_Id(memberVO);
	}
	@Override
	public String overlapped(String memId) throws Exception {
		
		return memberDAO.selectOverlappedID(memId);
	}
	
}