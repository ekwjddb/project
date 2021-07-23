package com.project.simple.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.simple.member.service.MemberService;
import com.project.simple.member.vo.MemberVO;
import com.project.simple.page.Criteria;
import com.project.simple.page.PageMaker;

/**
 * Handles requests for the application home page.
 */
@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "admin_listmember";
	}

	// 멤버로그인작업 ppt226
	// @Override
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(member);
		if (memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/main.do");
		} else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/login_01.do");
		}
		return mav;
	}

	@RequestMapping(value = "/findId.do", method = RequestMethod.POST)
	public ModelAndView findId(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.findId(member);
		if (memberVO != null) {
			mav.addObject("check", 1);
			mav.setViewName("redirect:/login_01.do");
		} else {
			mav.addObject("check", 0);
			mav.addObject("memId",memberVO.getmemId());
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/login_01.do");
		}
		return mav;
	}
	
	// 로그아웃 작업
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		session.removeAttribute("quickList");
		session.removeAttribute("quickListNum");
			
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main.do");
		return mav;
	}

	// 회원가입작업
	@Override
	@RequestMapping(value = "/addMembers.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/join_02.do");
		return mav;
	}

	// 네아로 DB에 추가정보작업 후 로그인작업
	@Override
	@RequestMapping(value = "/addMembers_naver.do", method = RequestMethod.POST)
	public ModelAndView addMember_naver(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember_naver(member);

		// 로그인작업
		memberVO = memberService.login_naver(member);

		if (memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/main.do");
		} else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/login_01.do");
		}
		return mav;
	}

	// 네이버로그인시 DB에 값이 있으면 추가정보 거치지 않고 바로 로그인
	@RequestMapping(value = "/login_naver.do", method = RequestMethod.GET)
	public ModelAndView naver_login(RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("member", memberVO);
		session.setAttribute("isLogOn", true);
		mav.setViewName("redirect:/main.do");

		return mav;
	}

	// 회원탈퇴작업
	@RequestMapping(value = "/removeMember.do", method = RequestMethod.POST)
	public ModelAndView removeMember(@ModelAttribute("removemember") MemberVO removemember, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes rAttr) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String sessionmemPwd = member.getmemPwd();
		String memPwd = removemember.getmemPwd();

		if (!(sessionmemPwd.equals(memPwd))) {
			rAttr.addAttribute("result", false);
			ModelAndView mav = new ModelAndView("redirect:/deletemember.do");
			return mav;
		}

		int result = memberService.removeMember(removemember);
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView("redirect:/drop_out.do");
		return mav;

	}

	// 회원정보수정
	@RequestMapping(value = "/modMember.do", method = RequestMethod.POST)
	public ModelAndView modMember(@ModelAttribute("modmember") MemberVO modmember, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes rAttr) throws Exception {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.modMember(modmember);
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView("redirect:/mypage_10.do");
		return mav;
	}

	// 회원수정 비밀번호확인
	@RequestMapping(value = "/mypage_03.do", method = RequestMethod.POST)
	public ModelAndView mypage_03(@ModelAttribute("confirmPwd") MemberVO confirmPwd, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes rAttr) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String sessionmemPwd = member.getmemPwd();
		String memPwd = confirmPwd.getmemPwd();

		if (!(sessionmemPwd.equals(memPwd))) {
			rAttr.addAttribute("result", false);
			ModelAndView mav = new ModelAndView("redirect:/mypage_02.do");
			return mav;
		}

		ModelAndView mav = new ModelAndView("redirect:/mypage_03.do");
		return mav;
	}

	@RequestMapping(value = "/mypage_03.do", method = RequestMethod.GET)
	private ModelAndView mypage_03(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/drop_out.do", method = RequestMethod.GET)
	private ModelAndView drop_out(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/deletemember.do", method = RequestMethod.GET)
	private ModelAndView deletemember(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	

	@RequestMapping(value = "/mypage_02.do", method = RequestMethod.GET)
	private ModelAndView mypage_02(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/mypage_01.do", method = RequestMethod.GET)
	private ModelAndView mypage_01(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/mypage_10.do", method = RequestMethod.GET)
	private ModelAndView mypage_10(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/join_02.do", method = RequestMethod.GET)
	private ModelAndView join_02(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/join_01.do", method = RequestMethod.GET)
	private ModelAndView join_01(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/storeinfomation.do", method = RequestMethod.GET)
	private ModelAndView storeinfomation(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value = "/login_03.do", method = RequestMethod.GET)
	private ModelAndView login_03(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}


	@Override
	@RequestMapping(value = "/admin_listmember.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listMembers(Criteria cri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List<MemberVO> membersList = memberService.listMembers(cri);
		int memberCount = memberService.memberCount();
		ModelAndView mav = new ModelAndView(viewName);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberCount);
		int pageNum = pageMaker.getCri().getPage();

		mav.addObject("pageNum", pageNum);
		mav.addObject("membersList", membersList);
		mav.addObject("pageMaker", pageMaker);

		return mav;
	}

	@Override
	@RequestMapping(value = "/admin_listmember/memberSearch.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView memberSearch(@RequestParam("search") String search, @RequestParam("searchType") String searchType,
			Criteria cri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		Map<String, Object> memberSearchMap = new HashMap<String, Object>();
		int pageStart = cri.getPageStart();
		int perPageNum = cri.getPerPageNum();
		memberSearchMap.put("pageStart", pageStart);
		memberSearchMap.put("perPageNum", perPageNum);
		memberSearchMap.put("search", search);
		System.out.println(search);
		memberSearchMap.put("searchType", searchType);
		System.out.println(searchType);
		memberSearchMap = memberService.memberSearch(memberSearchMap);
		System.out.println(memberSearchMap);
		int memberSearchCount = memberService.memberSearchCount(memberSearchMap);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int pageNum = pageMaker.getCri().getPage();
		memberSearchMap.put("pageNum", pageNum);
		pageMaker.setTotalCount(memberSearchCount);
		mav.addObject("memberSearchMap", memberSearchMap);
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("pageNum", pageNum);
		
		return mav;

	}
	
	@RequestMapping(value = "/admin_removeMember.do", method = RequestMethod.GET)
	private ModelAndView admin_removeMember(@RequestParam("memId") String memId, HttpServletRequest request, HttpServletResponse response)  throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.admin_removeMember(memId);
		mav.addObject("memId", memberVO);
		System.out.println(memId);
		mav.setViewName("redirect:/admin_listmember.do");
		return mav;
	}
	
	

}
