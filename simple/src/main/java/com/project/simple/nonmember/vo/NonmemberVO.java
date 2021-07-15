package com.project.simple.nonmember.vo;

import org.springframework.stereotype.Component;

@Component("nonmemberVO")
public class NonmemberVO {
	
	private int nonMemOrderNum;            //비회원 주문 번호
	private int nonMemCartId;              //비회원 장바구니 번호
	private String nonMemName;             //비회원 주문자
	private String nonMemPwd;             //비회원 주문 비밀번호
	private String nonEmail;             //비회원 이메일
	private String nonMemPhoneNum;             //비회원 전화번호
	private String nonMemSpName;             //비회원 받는 사람
	private String nonMemPhoneNum1;             //비회원 받는 사람 전화번호1
	private String nonMemPhoneNum2;             //비회원 받는 사람 전화번호2
	private String nonMemSpAdr;             //비회원 받는 사람 주소
	private String nonMemOrderMsg;             //주문 메시지
	private String nonMemDepositorName;             //
	private String nonMemPaymentMethod;             //지불 방법
	private String nonMemCardSelect;             //카드선택
	private int totalPrice;             //총 가격
	private String nonMemOrderDate;             //주문 날짜
	
	public NonmemberVO() {

	}
	public int getnonMemOrderNum() {
		return nonMemOrderNum;
	}
	public void setnonMemOrderNum(int nonMemOrderNum) {
		this.nonMemOrderNum = nonMemOrderNum;
	}
	public int getnonMemCartId() {
		return nonMemCartId;
	}
	public void setnonMemCartId(int nonMemCartId) {
		this.nonMemCartId = nonMemCartId;
	}
	public String getnonMemName() {
		return nonMemName;
	}
	public void setnonMemName(String nonMemName) {
		this.nonMemName = nonMemName;
	}
	public String getnonMemPwd() {
		return nonMemPwd;
	}
	public void setnonMemPwd(String nonMemPwd) {
		this.nonMemPwd = nonMemPwd;
	}
	public String getnonEmail() {
		return nonEmail;
	}
	public void setnonEmail(String nonEmail) {
		this.nonEmail = nonEmail;
	}
	public String getnonMemPhoneNum() {
		return nonMemPhoneNum;
	}
	public void setnonMemPhoneNum(String nonMemPhoneNum) {
		this.nonMemPhoneNum = nonMemPhoneNum;
	}
	public String getnonMemSpName() {
		return nonMemSpName;
	}
	public void setnonMemSpName(String nonMemSpName) {
		this.nonMemSpName = nonMemSpName;
	}
	public String getnonMemPhoneNum1() {
		return nonMemPhoneNum1;
	}
	public void setnonMemPhoneNum1(String nonMemPhoneNum1) {
		this.nonMemPhoneNum1 = nonMemPhoneNum1;
	}
	public String getnonMemPhoneNum2() {
		return nonMemPhoneNum2;
	}
	public void setnonMemPhoneNum2(String nonMemPhoneNum2) {
		this.nonMemPhoneNum2 = nonMemPhoneNum2;
	}
	public String getnonMemSpAdr() {
		return nonMemSpAdr;
	}
	public void setnonMemSpAdr(String nonMemSpAdr) {
		this.nonMemSpAdr = nonMemSpAdr;
	}
	public String getnonMemOrderMsg() {
		return nonMemOrderMsg;
	}
	public void setnonMemOrderMsg(String nonMemOrderMsg) {
		this.nonMemOrderMsg = nonMemOrderMsg;
	}
	public String getnonMemDepositorName() {
		return nonMemDepositorName;
	}
	public void setnonMemDepositorName(String nonMemDepositorName) {
		this.nonMemDepositorName = nonMemDepositorName;
	}
	public String getnonMemPaymentMethod() {
		return nonMemPaymentMethod;
	}
	public void setnonMemPaymentMethod(String nonMemPaymentMethod) {
		this.nonMemPaymentMethod = nonMemPaymentMethod;
	}
	public String getnonMemCardSelect() {
		return nonMemCardSelect;
	}
	public void setnonMemCardSelect(String nonMemCardSelect) {
		this.nonMemCardSelect = nonMemCardSelect;
	}
	public int gettotalPrice() {
		return totalPrice;
	}
	public void settotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getnonMemOrderDate() {
		return nonMemOrderDate;
	}
	public void setnonMemOrderDate(String nonMemOrderDate) {
		this.nonMemOrderDate = nonMemOrderDate;
	}
	

}
