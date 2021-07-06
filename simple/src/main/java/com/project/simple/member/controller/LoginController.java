package com.project.simple.member.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.scribejava.core.model.OAuth2AccessToken;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

//�α��� ù ȭ�� ��û �޼ҵ�
	@RequestMapping(value = "/login_01", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
		/* ���̹����̵�� ���� URL�� �����ϱ� ���Ͽ� naverLoginBOŬ������ getAuthorizationUrl�޼ҵ� ȣ�� */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("���̹�:" + naverAuthUrl);
//���̹�
		model.addAttribute("url", naverAuthUrl);
		return "login_01";
	}

//���̹� �α��� ������ callbackȣ�� �޼ҵ�
	@RequestMapping(value = "/join_03", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
//1. �α��� ����� ������ �о�´�.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String������ json������

//2. String������ apiResult�� json���·� �ٲ�
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
//3. ������ �Ľ�
//Top���� �ܰ� _response �Ľ�
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
//response�� ���� �� �Ľ�
		String Id = (String) response_obj.get("id");
		String Email = (String) response_obj.get("email");
		String Mobile = (String) response_obj.get("mobile");
		String Name = (String) response_obj.get("name");
		System.out.println(Id);
		System.out.println(Email);
		System.out.println(Mobile);
		System.out.println(Name);

//4.�Ľ�  �������� ����//���� ����
		model.addAttribute("Id", Id);
		model.addAttribute("Email", Email);
		model.addAttribute("Mobile", Mobile);
		model.addAttribute("Name", Name);
		model.addAttribute("result", apiResult);
		System.out.println(apiResult);

		String FullmemPhoneNum = Mobile;
		String FullmemEmail = Email;

		String e1 = "@";
		String p1 = "-";

		String[] memEmail = FullmemEmail.split(e1);
		String[] memPhoneNum = FullmemPhoneNum.split(p1);

		for (int i = 0; i < memEmail.length; i++) {
		}
		for (int i = 0; i < memPhoneNum.length; i++) {
		}

		model.addAttribute("Email0", memEmail[0]);
		model.addAttribute("Email1", memEmail[1]);

		model.addAttribute("Mobile0", memPhoneNum[0]);
		model.addAttribute("Mobile1", memPhoneNum[1]);
		model.addAttribute("Mobile2", memPhoneNum[2]);

		return "join_03";
	}

}
