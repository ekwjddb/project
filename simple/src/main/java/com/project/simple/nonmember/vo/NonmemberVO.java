package com.project.simple.nonmember.vo;

import org.springframework.stereotype.Component;

@Component("nonmemberVO")
public class NonmemberVO {
	
	private int nonMemOrderNum;            //��ȸ�� �ֹ� ��ȣ
	private int nonMemCartId;              //��ȸ�� ��ٱ��� ��ȣ
	private String nonMemName;             //��ȸ�� �ֹ���
	private String nonMemPwd;             //��ȸ�� �ֹ� ��й�ȣ
	private String nonEmail;             //��ȸ�� �̸���
	private String nonMemPhoneNum;             //��ȸ�� ��ȭ��ȣ
	private String nonMemSpName;             //��ȸ�� �޴� ���
	private String nonMemPhoneNum1;             //��ȸ�� �޴� ��� ��ȭ��ȣ1
	private String nonMemPhoneNum2;             //��ȸ�� �޴� ��� ��ȭ��ȣ2
	private String nonMemSpAdr;             //��ȸ�� �޴� ��� �ּ�
	private String nonMemOrderMsg;             //�ֹ� �޽���
	private String nonMemDepositorName;             //
	private String nonMemPaymentMethod;             //���� ���
	private String nonMemCardSelect;             //ī�弱��
	private int totalPrice;             //�� ����
	private String nonMemOrderDate;             //�ֹ� ��¥
	
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
