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

import com.project.simple.board.vo.ArticleVO;
import com.project.simple.member.dao.MemberDAO;
import com.project.simple.member.vo.MemberVO;
import com.project.simple.page.Criteria;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	
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
	
	//�α��� ��� ���� �߰�
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberDAO.loginById(memberVO);
	}
	
	//�׾Ʒ� �α��� ��� ���� �߰�
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
	//��й�ȣ ã�� �̸��Ϲ߼�
	@Override
	public void sendEmail(MemberVO member, String div) throws Exception {
		// Mail Server ����
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com"; //���̹� �̿�� smtp.naver.com
		String hostSMTPid = "ekwjd8683@naver.com";
		String hostSMTPpwd = "dbek4026";

		// ������ ��� EMail, ����, ����
		String fromEmail = "ekwjd8683@naver.com";
		String fromName = "������";
		String subject = "";
		String msg = "";

		if(div.equals("findpw")) {
			subject = "simple �ӽ� ��й�ȣ �Դϴ�.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += member.getmemId() + "���� �ӽ� ��й�ȣ �Դϴ�. ��й�ȣ�� �����Ͽ� ����ϼ���.</h3>";
			msg += "<p>�ӽ� ��й�ȣ : ";
			msg += member.getmemPwd() + "</p></div>";
		}

		// �޴� ��� E-Mail �ּ�
		String mail = member.getmemEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587); //���̹� �̿�� 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("���Ϲ߼� ���� : " + e);
		}
	}

	//��й�ȣã��
	@Override
	public void findPw(HttpServletResponse response, MemberVO member) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		MemberVO ck = memberDAO.readMember(member.getmemId());
		PrintWriter out = response.getWriter();
		// ���Ե� ���̵� ������
		if(memberDAO.idCheck(member.getmemId()) == null) {
			out.print("��ϵ��� ���� ���̵��Դϴ�.");
			out.close();
		}
		// ���Ե� �̸����� �ƴϸ�
		else if(!member.getmemEmail().equals(ck.getmemEmail())) {
			out.print("��ϵ��� ���� �̸����Դϴ�.");
			out.close();
		}else {
			// �ӽ� ��й�ȣ ����
			String memPwd = "";
			for (int i = 0; i < 12; i++) {
				memPwd += (char) ((Math.random() * 26) + 97);
			}
			member.setmemPwd(memPwd);
			// ��й�ȣ ����
			memberDAO.updatePw(member);
			// ��й�ȣ ���� ���� �߼�
			sendEmail(member, "findpw");

			out.print("�̸��Ϸ� �ӽ� ��й�ȣ�� �߼��Ͽ����ϴ�.");
			out.close();
		}
	}
}