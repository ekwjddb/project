package com.project.simple.nonmember.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.simple.nonmember.service.NonmemberService;
import com.project.simple.nonmember.vo.NonmemberVO;



@Controller("nonmemberController")
public class NonmemberControllerImpl implements NonmemberController{
	@Autowired
	private NonmemberService nonmemberService;
	@Autowired
	private NonmemberVO nonmemberVO;

	// @Override
	@RequestMapping(value = "/nonmember/order_lookup.do", method = RequestMethod.POST)
	public ModelAndView order_lookup(@ModelAttribute("nonmember") NonmemberVO nonmember, RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		nonmemberVO = nonmemberService.order_lookup(nonmember);
		if(nonmemberVO != null) {
			mav.setViewName("redirect:/nonorderinquiry.do");
		}else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/login_01.do");
		}
		
		
		
		return mav;
	}
	
	@RequestMapping(value = "/nonorderinquiry.do", method = RequestMethod.GET)
	private ModelAndView nonorderinquiry(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}


}
